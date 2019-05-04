package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.dao.OrderDao;
import com.qf.distributionsys.entity.Order;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    //查找当前用户所购买的所有产品商家的uid
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<User> searchAllSale(int uid) {
        return orderDao.findAllSale(uid);
    }
}
