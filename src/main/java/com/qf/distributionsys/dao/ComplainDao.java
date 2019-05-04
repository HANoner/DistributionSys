package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.entity.Complaint;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ComplainDao extends BaseMapper<Complaint> {
    //根据用户id查询该用户的投诉记录
    @Select("select * from complaint where complaint_uid = #{uid}")
    public List<Complaint> findAll(int uid);

    //添加投诉记录利用内置save



}
