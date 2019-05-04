package com.qf.distributionsys.contorller;

import com.alibaba.druid.stat.TableStat;
import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@RestController
@Api(value = "用户的相关操作" ,tags = "操作用户")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("adduser.do")
    @ApiOperation(value = "注册用户",notes = "实现用户的新增")
    public ResultVO adduser(@ApiParam(name = "user",value = "用户相关的键值对") User user){
        return userService.regist(user);
    }
    @PostMapping("login.do")
    @ApiOperation(value="用户登陆",notes = "实现用户的登陆")
    public ResultVO login(@ApiParam(name = "user",value = "用户相关的键值对") User user,HttpServletResponse response,Boolean isRememberPassword){
      return userService.login(user, response,isRememberPassword);
    }

    @PostMapping("checkLogin.do")
    @ApiOperation(value = "用户登陆检测",notes = "确认登陆状态")
    public ResultVO checkLogin(HttpServletRequest request){
        return  userService.checkLogin(request);
    }

    @PostMapping("logout.do")
    @ApiOperation(value = "用户退出登陆",notes = "用户退出")
    public ResultVO logout(HttpServletRequest request,HttpServletResponse response){
        return  userService.logout(request,response);
    }
}


