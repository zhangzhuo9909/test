package org.zhangzhuo.serve;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zhangzhuo.server.UploadServer;

import java.io.InputStream;

@Service
public class UploadServerImpl implements UploadServer {
    @Value("${fdfs.storage}")
    private String storage;

    @Autowired
    private FastFileStorageClient client;



    /**
     * path = M00/00/00/wKgTglwnPEqASjgOAAHmWWJUGSA110.jpg
     */
    @Override
    public String setUpload(InputStream inputStream, long size, String extension) {
        StorePath uploadFile = client.uploadFile(inputStream, size, extension, null);
        String url = new StringBuffer(storage).append("/").append(uploadFile.getPath()).toString();
        System.out.println(url);
        return url;
    }
}
