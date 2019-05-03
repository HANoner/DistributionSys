package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.Complaint;
import com.qf.distributionsys.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ComplainController {
    @Autowired
    private ComplainService complainService;
    //展示所有列表
    @GetMapping("complain/list.do")
    public ResultVO findAll(int uid){
        List<Complaint> list = complainService.searchAll(uid);
        for(Complaint complaint:list){
            System.out.println(complaint.getComplaintDate());
            System.out.println(complaint.getComplaintedUid());
        }
        return ResultUtil.exec(true,"展示成功",list);
    }

}
