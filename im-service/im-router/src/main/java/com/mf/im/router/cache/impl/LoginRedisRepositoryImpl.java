package com.mf.im.router.cache.impl;

import com.mf.im.router.cache.LoginRedisRepository;
import com.mf.projects.im.handler.IMLoginRequest;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class LoginRedisRepositoryImpl implements LoginRedisRepository {

    private static final String HASH_NAME = "ImLogin:";

    @Autowired
    private RedisTemplate<String, IMLoginRequest> redisTemplate;

    private String getKey(String id){
        return HASH_NAME + id;
    }


    @Override
    public void save(IMLoginRequest request) {
        redisTemplate.opsForValue().set(getKey(request.getUserId()), request, 30, TimeUnit.MINUTES);
    }

    @Override
    public void logout(String userId) {
        redisTemplate.delete(getKey(userId));
    }

    @Override
    public IMLoginRequest getLoginInfo(String userId) {
        return redisTemplate.opsForValue().get(getKey(userId));
    }

    @Override
    public List<IMLoginRequest> getAllIMLoginRequests() {
        val keys = redisTemplate.keys(HASH_NAME + "*");
        return redisTemplate.opsForValue().multiGet(keys);
    }
}
