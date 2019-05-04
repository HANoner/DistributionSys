package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("order/findsale.do")
    public ResultVO findSale(int uid){
        List<User> list = orderService.searchAllSale(uid);
        return ResultUtil.exec(true,"查找成功",list);
    }
}
