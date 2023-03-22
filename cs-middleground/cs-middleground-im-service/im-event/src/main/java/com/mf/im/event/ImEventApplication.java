package com.mf.im.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.mf.im.event.mapper")
public class ImEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImEventApplication.class, args);
    }

}
