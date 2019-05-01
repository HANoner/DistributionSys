package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResultUtil.exec(userService.save(user),"添加用户成功",null);
    }
}
