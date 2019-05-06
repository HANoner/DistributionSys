package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("level")
@Api(value = "关于用户的等级",tags = "操作用户的等级")
public class UserLevelController {
    @Autowired
    private UserService userService;

    @GetMapping("selectuserlevel.do")
    @ApiOperation(value = "查找用户",notes = "根据用户的id查找用户的等级")
    //这里的用户id也需要从redis里面获取 所以。。写不了 报错是因为git合并的时候accept their 了  不写了  垃圾前端  5/4 16点31分
    public ResultVO selectuserlevel(@ApiParam(name = "user",value = "user的uid") int uid){
        //User user= userService.findUserLevle(uid);
        //int level = user.getLevel();
       // return ResultUtil.exec(user != null,"查找用户的等级",level);
        return null;
    }



}
