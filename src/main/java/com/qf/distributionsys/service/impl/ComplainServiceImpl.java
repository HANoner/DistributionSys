package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.common.util.FileUtils;
import com.qf.distributionsys.dao.ComplainDao;
import com.qf.distributionsys.entity.Complaint;
import com.qf.distributionsys.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ComplainServiceImpl extends ServiceImpl<ComplainDao, Complaint> implements ComplainService {
   @Autowired
   private ComplainDao complainDao;
    @Override
    public void add(Complaint complaint, MultipartFile picture) {

        String result_msg="";//上传结果信息
        Map<String,Object> result=new HashMap<String, Object>();//一个文件上传的结果
        //判断图片大小
        if (picture.getSize() / 1000 > 100){
            result_msg="图片大小不能超过100KB";
        } else{
            //判断上传文件格式
            String fileType = picture.getContentType();
            if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                // 要上传的目标文件存放的绝对路径
                final String localPath="D:\\idealfiles\\DistributionSys\\src\\main\\resources\\static\\img";
                //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                //获取文件名
                String fileName = picture.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                if (FileUtils.upload(picture, localPath, fileName)) {
                    //文件存放的相对路径(一般存放在数据库用于img标签的src)
                    String relativePath="img/"+fileName;
                    //插入数据库
                    System.out.println(relativePath+"++++++++++++");
                    complaint.setComplaintImg(relativePath);
                    result.put("relativePath",relativePath);//前端根据是否存在该字段来判断上传是否成功
                    result_msg="图片上传成功";
                }
                else{
                    result_msg="图片上传失败";
                }
            }
            else{
                result_msg="图片格式不正确";
            }
        }
        result.put("result_msg",result_msg);
        complaint.setComplaintDate(new Date());
        complaint.setComplaintFlag(1);
        //添加投诉记录
        complainDao.insert(complaint);
    }
   ////根据用户id查询该用户的投诉记录
    @Override
    public List<Complaint> searchAll(int uid) {
        return complainDao.findAll(uid);
    }

}
