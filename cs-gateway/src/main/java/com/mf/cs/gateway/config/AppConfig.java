package com.mf.cs.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    @Bean
    ThreadPoolExecutor executor() {
        return new ThreadPoolExecutor(20, 50, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000));
    }
}
