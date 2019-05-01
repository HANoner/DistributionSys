package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.dao.Userdao;
import com.qf.distributionsys.entity.User;
import com.qf.distributionsys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<Userdao,User> implements UserService{
}
