package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
public interface Userdao extends BaseMapper<User>{
	@Select("select * from  user order by uid desc limit 1")
	@ResultType(User.class)
	public User findLastUser();



}
