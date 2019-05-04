package com.qf.distributionsys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.common.util.JedisUtil;
import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.util.TokenUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.common.vo.TokenVO;
import com.qf.distributionsys.dao.Userdao;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<Userdao,User> implements UserService{
	@Autowired
	private Userdao userdao;
	@Autowired
	private JedisUtil jedisUtil;

	public ResultVO regist(User user){

		if (user.getPhone().length() != 11){
			throw new RuntimeException("手机号应为11位数");
		}else if (!user.getPhone().matches("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")) {
			throw new RuntimeException("手机号格式不正确");
		}else {
			/*判断电话号码是不是注册过*/
			QueryWrapper queryWrapper = new QueryWrapper();
			queryWrapper.eq("phone",user.getPhone());

			List list = userdao.selectList(queryWrapper);
			if(list.size()!=0){
				return ResultUtil.exec(false,"号码已注册",null);
			}else {
				/*判断邀请码是不是正确*/
				User invitatedcode = userdao.selectOne(new QueryWrapper<User>().eq("Invitationcode", user.getInvitatedcode()));
				if (invitatedcode !=null){
					User lastUser=userdao.findLastUser();
					Integer invitationcode = lastUser.getInvitationcode();
					user.setInvitationcode(invitationcode+1);
					user.setFlag(0);
					userdao.insert(user);
					return ResultUtil.setOK("注册成功");
				}else{
					return ResultUtil.exec(false,"邀请码错误",null);
				}

			}
		}
	}

	@Override
	public ResultVO login(User user, HttpServletResponse response,Boolean isRememberPassword) {
		/*查询用户是否存在*/
		User findUser = userdao.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
		if(findUser != null){
			/*校验密码*/
			if(findUser.getPassword().equals(user.getPassword())){
				/*登陆成功，生成token*/

				String token = TokenUtil.createToken(findUser.getUid(),findUser.getPhone());
				//2、存储到Redis
				//记录Token有效期30分钟
				jedisUtil.setStr("user:"+findUser.getPhone(),token,1800);
				/*System.out.println(jedisUtil.getStr("user:"+findUser.getPhone()));*/
				//记录当前登录用户的详细信息
				jedisUtil.setStr(token,JSON.toJSONString(findUser),1800);
				/*如果选择记住密码，则生成cookie*/

					//3、存储到Cookie
					Cookie cookie=new Cookie("usertoken",token);
					cookie.setPath("/");
					response.addCookie(cookie);


				return ResultUtil.exec(true,"登录成功",token);

			}else{
				return ResultUtil.exec(false,"密码不正确",null);
			}
		}else{
			return ResultUtil.exec(false,"用户不存在",null);
		}

	}

	@Override
	public ResultVO checkLogin(HttpServletRequest request) {
		Cookie[] arr=request.getCookies();
		String token="";
		for(Cookie c:arr){
			if(c.getName().equals("usertoken")){
				token=c.getValue();
				break;
			}
		}
		if(token.length()>0){
			//token存在
			if(jedisUtil.isExists(token)){
				//有效
				String json=jedisUtil.getStr(token);
				User user=JSON.parseObject(json,User.class);
				return ResultUtil.exec(true,"已经登录，且有效",user.getPhone());
			}else {
				return  ResultUtil.exec(false,"Token已经失效，请重新登录",null);
			}
		}else {
			return ResultUtil.setERROR();
		}
	}

	@Override
	public ResultVO logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] arr=request.getCookies();
		String token="";
		for(Cookie c:arr){
			if(c.getName().equals("usertoken")){
				token=c.getValue();
				break;
			}
		}
		//删除Redis
		jedisUtil.delKey(token);
		TokenVO tokenVO=TokenUtil.parseToken(token);
		jedisUtil.delKey("user:"+tokenVO.getContent());
		//删除Cookie
		Cookie cookie=new Cookie("usertoken","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return ResultUtil.setOK("注销成功");
	}


}
