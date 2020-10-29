package org.zhangzhuo.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadService{
//    @Value("${fdfs.sorageServer}")
//    private String sorageServer;


    @Autowired
    private FastFileStorageClient fastFileStorageClient;


    public HashMap<String, Object> upload(InputStream inputStream, long size, String substring) {
        HashMap<String, Object> map = new HashMap<>();
//        System.out.println(sorageServer);
        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, size, substring, null);
        map.put("url","http://192.168.118.119/"+storePath.getFullPath());
//        System.out.println("URL =" + storePath.getGroup());
        map.put("path",storePath.getFullPath());
//        System.out.println("path = " + storePath.getFullPath());
        return map;
    }

    /**
     * 调用deletefile方法进行删除
     * @param path
     */
    public void setRemove(String path) {
        fastFileStorageClient.deleteFile(path);
    }
}
