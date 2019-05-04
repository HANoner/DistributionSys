package com.qf.distributionsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.distributionsys.common.util.FileUtils;
import com.qf.distributionsys.dao.CheckDao;
import com.qf.distributionsys.dao.ChenkMapper;
import com.qf.distributionsys.entity.Chenk;
import com.qf.distributionsys.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
@Service
public class CheckServiceImpl extends ServiceImpl<CheckDao, Chenk>  implements CheckService{
    @Autowired
    private CheckDao checkDao;
  @Override
    public void insert(int checkid, int uid, MultipartFile behindimg, MultipartFile frontimg) {
        Chenk chenk = new Chenk();
        MultipartFile[] files = {behindimg,frontimg};
        //保存路径
        List<String> path = new ArrayList<>();

        for (MultipartFile file : files) {    //循环保存文件

            Map<String,Object> result=new HashMap<String, Object>();//一个文件上传的结果
            String result_msg="";//上传结果信息

            if (file.getSize() / 1000 > 100){
                result_msg="图片大小不能超过100KB";
            }
            else{
                //判断上传文件格式
                String fileType = file.getContentType();
                if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                    // 要上传的目标文件存放的绝对路径
                    final String localPath="D:\\idealfiles\\DistributionSys\\src\\main\\resources\\static\\img";
                    //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                    //获取文件名
                    String fileName = file.getOriginalFilename();
                    //获取文件后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    //重新生成文件名
                    fileName = UUID.randomUUID()+suffixName;
                    if (FileUtils.upload(file, localPath, fileName)) {
                        //文件存放的相对路径(一般存放在数据库用于img标签的src)
                        String relativePath="img/"+fileName;
                        //插入数据库
                        path.add(relativePath);
                        System.out.println(relativePath+"++++++++++++");
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
//            root.add(result);
            //设置审核人id
        }
      chenk.setCheckuid(checkid);
      //设置申请人Id
      chenk.setUid(uid);
      System.out.println("长度========="+path.size());
      //设置身份证反面路径
      chenk.setBehindimg(path.get(0));
      //设置身份证后面路径
      chenk.setFrontimg(path.get(1));
      checkDao.insertRecord(chenk);
  }

    @Override
    public int searchChecked(int uid) {
        return checkDao.selectCheckedId(uid);
    }

    @Override
    public List<Chenk> searchAllCheck(int uid) {
        return checkDao.findAllCheck(uid);
    }

    @Override
    public boolean newUpdateCheck(Chenk chenk) {
        return checkDao.newUpdate(chenk);
    }


}




















