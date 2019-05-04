package com.qf.distributionsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import org.apache.http.HttpRequest;

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
public interface UserService extends IService<User>{
	public ResultVO regist(User user);
	public ResultVO login(User user, HttpServletResponse response,Boolean isRememberPassword);
	public ResultVO checkLogin(HttpServletRequest request);
	public ResultVO logout(HttpServletRequest request,HttpServletResponse response);
}
