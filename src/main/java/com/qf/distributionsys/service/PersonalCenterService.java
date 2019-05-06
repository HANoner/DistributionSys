package com.qf.distributionsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.distributionsys.vo.PersonalCenterVo;

import java.util.List;

public interface PersonalCenterService extends IService<PersonalCenterVo>{

    public List<PersonalCenterVo> findPunish(int uid);
}
