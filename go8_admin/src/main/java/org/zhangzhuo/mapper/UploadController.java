package org.zhangzhuo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.service.UploadService;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/file")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    /**
     * 往虚拟机里面添加图片
     * @param file
     * @return
     */
    @CrossOrigin(origins = "*",methods = RequestMethod.POST)
    @PostMapping("/upload")
    public ServiceResponse upload(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            String substring = filename.substring(filename.indexOf(".") + 1);

//            System.out.println(substring);
            HashMap<String, Object> map = uploadService.upload(file.getInputStream(), file.getSize(), substring);
            return ServiceResponse.ok(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 根据前台传入的路径进行删除图片
     * @param path
     * @return
     */
    @DeleteMapping
    public ServiceResponse setRemove(String path){
        try {
            uploadService.setRemove(path);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
