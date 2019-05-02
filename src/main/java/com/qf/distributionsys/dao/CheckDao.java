package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.entity.Chenk;
import org.apache.ibatis.annotations.Insert;

public interface CheckDao extends BaseMapper<Chenk> {
    @Insert("insert into `check` values(null,#{checkuid},#{uid},#{behindimg},#{frontimg},1)")
    public  void insertRecord(Chenk chenk);
}
