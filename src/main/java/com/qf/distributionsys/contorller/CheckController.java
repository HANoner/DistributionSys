package com.qf.distributionsys.contorller;

import com.qf.distributionsys.common.util.ResultUtil;
import com.qf.distributionsys.common.vo.ResultVO;
import com.qf.distributionsys.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "check身份验证相关操作" ,tags = "验证操作")
public class CheckController {
    @Autowired
    private CheckService checkService;
    //增加投诉记录
    @PostMapping("/check/save.do")
    @ApiOperation(value = "上传身份证正反面",notes = "上传照片")
    public ResultVO save(@ApiParam(name = "checkuid" ,value = "审核人id") @RequestParam("checkid") int checkid,@ApiParam(name = "uid",value = "申请人id") @RequestParam("uid") int uid, @ApiParam(name = "behindimg",value = "身份证反面照片")@RequestParam("behindimg") MultipartFile behindimg,@ApiParam(name = "frontimg",value = "身份证正面照片") @RequestParam("frontimg") MultipartFile frontimg){
        checkService.insert(checkid,uid,behindimg,frontimg);
        return ResultUtil.setOK();
    }
}
