package org.zhangzhuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "org.zhangzhuo")
@MapperScan("org.zhangzhuo.mapper")
public class MallStart {
    public static void main(String[] args) {
        SpringApplication.run(MallStart.class,args);
    }
    @Bean
    public CartCache cartCache(){
        return new CartCache();
    }
}
