package com.qf.distributionsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.distributionsys.entity.Chenk;
import org.springframework.web.multipart.MultipartFile;

public interface CheckService extends IService<Chenk> {
    //插入
    public  void insert(int checkid, int uid, MultipartFile behindimg, MultipartFile frontimg);
    //根据uid查找审核人id
    public  int searchChecked(int uid);
}
