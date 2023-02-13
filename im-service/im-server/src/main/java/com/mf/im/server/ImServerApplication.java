package com.mf.im.server;

import com.mf.im.server.server.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImServerApplication.class, args);
        Server.start();
    }

}
