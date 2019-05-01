package com.qf.distributionsys.dao;


import com.qf.distributionsys.entity.Chenk;

public interface ChenkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chenk record);

    int insertSelective(Chenk record);

    Chenk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chenk record);

    int updateByPrimaryKey(Chenk record);
}