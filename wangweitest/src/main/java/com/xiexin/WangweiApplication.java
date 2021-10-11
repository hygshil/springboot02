package com.xiexin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiexin.dao")
public class WangweiApplication {

    public static void main(String[] args) {
        System.out.println("项目启动了....");
        SpringApplication.run(WangweiApplication.class, args);
    }

}
