package org.zhangzhuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("org.zhangzhuo.mapper")
public class CataLogStart {
    public static void main(String[] args) {
        SpringApplication.run(CataLogStart.class,args);
    }
}
