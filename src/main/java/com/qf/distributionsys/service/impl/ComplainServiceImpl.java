package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.dao.ComplainDao;
import com.qf.distributionsys.entity.Complaint;
import com.qf.distributionsys.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ComplainServiceImpl extends ServiceImpl<ComplainDao, Complaint> implements ComplainService {
   @Autowired
   private ComplainDao complainDao;
    @Override
    public void add(Complaint complaint, MultipartFile picture) {

    }
   ////根据用户id查询该用户的投诉记录
    @Override
    public List<Complaint> searchAll(int uid) {
        return complainDao.findAll(uid);
    }

}
