package com.qf.distributionsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.distributionsys.entity.Complaint;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ComplainService extends IService<Complaint> {
    //重写添加方法
    public void add(Complaint complaint, MultipartFile picture);
    //根据用户id查询该用户的投诉记录
    public List<Complaint> searchAll(int uid);
}
