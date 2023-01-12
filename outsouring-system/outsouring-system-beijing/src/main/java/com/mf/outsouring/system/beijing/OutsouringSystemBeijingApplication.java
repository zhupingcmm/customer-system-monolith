package com.mf.outsouring.system.beijing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mf.outsouring.system.beijing.mapper")
@SpringBootApplication
public class OutsouringSystemBeijingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutsouringSystemBeijingApplication.class, args);
    }

}
