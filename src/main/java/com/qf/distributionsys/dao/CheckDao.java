package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.entity.Chenk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CheckDao extends BaseMapper<Chenk> {
    @Insert("insert into `check` values(null,#{checkuid},#{uid},#{behindimg},#{frontimg},1)")
    public  void insertRecord(Chenk chenk);
    //通过uid查找邀请人id来作为审核人Id
    @Select("select p.uid from user p\n" +
            "inner join user c\n" +
            "on p.Invitationcode = c.Invitatedcode\n" +
            "where c.uid = #{uid}")
    public int selectCheckedId(int uid);

    //审核列表（查找本人需要审核的所有信息）
    @Select("select * from `check` where checkuid = #{uid} and flag = 1")
    public List<Chenk> findAllCheck(int uid);

    //重写更新方法
    @Update(" UPDATE `check`  SET flag=#{flag}  WHERE id=#{id}")
    public boolean newUpdate(Chenk chenk);
}

