package com.mf.im.router.config;

import com.mf.projects.im.handler.IMLoginRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

    @Bean
    public RedisTemplate<String, IMLoginRequest> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate对象
        RedisTemplate<String, IMLoginRequest> redisTemplate = new RedisTemplate<>();
        // 设置ConnectionFactory
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置Key的序列化 - String 序列化 RedisSerializer.string() => StringRedisSerializer.UTF_8
        redisTemplate.setKeySerializer(RedisSerializer.string());
        // 设置Value的序列化 - JSON 序列化 RedisSerializer.json() => GenericJackson2JsonRedisSerializer
        redisTemplate.setValueSerializer(RedisSerializer.json());

        return redisTemplate;
    }
}
