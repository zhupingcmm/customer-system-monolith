package com.mf.im.server;

import com.mf.im.server.server.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ImServerApplication {

    private static int port = 8888;

    public static void main(String[] args) {

        SpringApplication.run(ImServerApplication.class, args);

        if (args.length != 0 && args[0] != null) {
            port = Integer.parseInt(args[0]);
        }
        Server.start(port);
    }

}
