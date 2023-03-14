package com.mf.customer.service.provider.config;

import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

import static java.util.Collections.singletonMap;


@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig extends CachingConfigurerSupport {
//    @Bean
//    CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//
//        /* 默认配置， 默认超时时间为30s */
//        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration
//                .ofSeconds(30L)).disableCachingNullValues();
//
//        /* 配置"pagedObject"分页数据的超时时间为120s*/
//        RedisCacheManager cacheManager = RedisCacheManager.builder(RedisCacheWriter.lockingRedisCacheWriter(connectionFactory))
//                .cacheDefaults(defaultCacheConfig)
//                .withInitialCacheConfigurations(
//                        singletonMap("pagedObject", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(120L)).disableCachingNullValues())
//                )
//                .transactionAware()
//                .build();
//
//        return cacheManager;
//    }

    @Bean
    public <V> RedisTemplate<String, V> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate <String, V> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 使用GenericJackson2JsonRedisSerializer 替换默认序列化
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置key和value的序列化规则
        redisTemplate.setKeySerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setKeySerializer(genericJackson2JsonRedisSerializer);
        // 设置hashkey和hashvalue的序列化规则
        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
