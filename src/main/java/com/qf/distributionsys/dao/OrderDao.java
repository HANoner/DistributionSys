package com.qf.distributionsys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.distributionsys.entity.Order;
import com.qf.distributionsys.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao extends BaseMapper<Order> {
    //查找当前用户所购买的所有产品商家的uid
    @Select("SELECT u.* from `order` o INNER JOIN `user` u on o.saleuid = u.uid where o.buyuid = #{uid}")
    public List<User> findAllSale(int uid);

}
