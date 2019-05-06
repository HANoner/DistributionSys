package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.vo.PersonalCenterVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
public interface CenterDao extends BaseMapper<PersonalCenterVo>{
    //查询个人中心的奖励和处罚
    @Select("SELECT u.username username,us.username punishname ,p.award award,p.punish punish from punish p INNER JOIN `user` u ON p.uid = u.uid INNER JOIN `user` us on p.punishuid = us.uid where p.uid = #{uid}")
     public List<PersonalCenterVo> findPunish(int uid);
}
