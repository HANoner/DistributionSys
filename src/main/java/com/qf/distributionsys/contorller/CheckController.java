package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.entity.Chenk;
import com.qf.distributionsys.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(value = "check身份验证相关操作" ,tags = "验证操作")
public class CheckController {
    @Autowired
    private CheckService checkService;
    //增加投诉记录
    @PostMapping("check/save.do")
    @ApiOperation(value = "上传身份证正反面",notes = "上传照片")
    public ResultVO save(@RequestParam("checkid") int checkid,@ApiParam(name = "uid",value = "申请人id") @RequestParam("uid") int uid, @ApiParam(name = "behindimg",value = "身份证反面照片")@RequestParam("behindimg") MultipartFile behindimg,@ApiParam(name = "frontimg",value = "身份证正面照片") @RequestParam("frontimg") MultipartFile frontimg){
        checkService.insert(checkid,uid,behindimg,frontimg);
        return ResultUtil.setOK();
    }

    //审核列表
    @GetMapping("check/list.do")
    public  ResultVO list(int uid){
        List<Chenk> list = checkService.searchAllCheck(uid);
        return  ResultUtil.exec(true,"审核列表加载成功",list);
    }

    //审核
    @PutMapping("check/update.do")
    public ResultVO updateFlag(int id){
        Chenk chenk = new Chenk();
        chenk.setId(id);
        chenk.setFlag(3);
        checkService.newUpdateCheck(chenk);
        return  ResultUtil.setOK();
    }
}
