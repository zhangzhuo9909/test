package org.zhangzhuo.server;

import org.springframework.stereotype.Service;

import java.io.InputStream;

public interface UploadServer {
    String setUpload(InputStream inputStream, long size, String extension);
}
