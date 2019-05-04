package com.qf.distributionsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.distributionsys.entity.Order;
import com.qf.distributionsys.entity.User;

import java.util.List;

public interface OrderService extends IService<Order> {
    //查找当前用户所购买的所有产品商家的uid
    public List<User> searchAllSale(int uid);
}
