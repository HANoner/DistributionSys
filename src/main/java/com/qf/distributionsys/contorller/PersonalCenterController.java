package com.qf.distributionsys.contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.distributionsys.common.util.JedisUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.dao.Userdao;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.PersonalCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.PersistenceService;

/**
 * 〈一句话功能简述〉<br>
 * 〈和  我的中心 ——> 个人中心 下的相关接口 相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@RestController
@RequestMapping("center")
@Api(value = "我的中心",tags = "用户中心下的多个接口")
public class PersonalCenterController {

    @Autowired
    private PersonalCenterService personalCenterService;

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired
    private Userdao userdao;

    @ApiOperation(value = "我的奖励",notes = "根据用户的id查找用户的奖励")
    public ResultVO findUserAward(){
      return null;
    }



}
