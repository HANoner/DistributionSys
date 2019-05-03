package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.entity.Chenk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CheckDao extends BaseMapper<Chenk> {
    @Insert("insert into `check` values(null,#{checkuid},#{uid},#{behindimg},#{frontimg},1)")
    public  void insertRecord(Chenk chenk);
    //通过uid查找邀请人id来作为审核人Id
    @Select("select p.uid from user p\n" +
            "inner join user c\n" +
            "on p.Invitationcode = c.Invitatedcode\n" +
            "where c.uid = #{uid}")
    public int selectCheckedId(int uid);

}
