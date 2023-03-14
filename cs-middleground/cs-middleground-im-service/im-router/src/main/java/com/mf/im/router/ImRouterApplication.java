package com.mf.im.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ImRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImRouterApplication.class, args);
	}

}
