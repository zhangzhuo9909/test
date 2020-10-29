package org.zhangzhuo.controoler;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.server.UploadServer;

@RestController
@RequestMapping("/file")
public class UploadController {

    @Autowired
    private UploadServer uploadServer;

    @PostMapping("/upload")
    public ServiceResponse setUpload(MultipartFile file){
        // 我们已经拿到文件流了，我们要调用fastdfs-client将这个文件流传到服务器上
        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String url = uploadServer.setUpload(file.getInputStream(), file.getSize(), extension);
            return ServiceResponse.ok(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
