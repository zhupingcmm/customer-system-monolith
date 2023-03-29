package com.mf.cs.security.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenEnhancerConfig {

    @Bean
    public JWTTokenEnhancer jwtTokenEnhancer(){
        return new JWTTokenEnhancer();
    }
}
