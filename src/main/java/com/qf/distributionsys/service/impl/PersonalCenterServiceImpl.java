package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.common.util.JedisUtil;
import com.qf.distributionsys.dao.CenterDao;
import com.qf.distributionsys.service.PersonalCenterService;
import com.qf.distributionsys.vo.PersonalCenterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jnlp.PersistenceService;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈和___相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@Service
public class PersonalCenterServiceImpl extends ServiceImpl<CenterDao,PersonalCenterVo> implements PersonalCenterService{

    @Autowired
    private CenterDao centerDao;
    @Override
    public List<PersonalCenterVo> findPunish(int uid) {
        return centerDao.findPunish(uid);
    }
}
