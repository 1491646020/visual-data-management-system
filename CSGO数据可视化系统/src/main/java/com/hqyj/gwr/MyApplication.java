package com.hqyj.gwr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//springboot的启动类
@SpringBootApplication
@MapperScan("com.hqyj.gwr.mapper")
public class MyApplication {
    public static void main(String[] args) {
        //.var+回车  自动补全返回值
        SpringApplication springApplication = new SpringApplication(MyApplication.class);
        springApplication.run(args);
    }
}
