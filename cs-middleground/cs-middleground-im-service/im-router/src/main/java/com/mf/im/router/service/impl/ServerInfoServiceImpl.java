package com.mf.im.router.service.impl;

import com.mf.im.router.service.ServerInfoService;
import com.mf.projects.im.handler.IMServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



@Service
public class ServerInfoServiceImpl implements ServerInfoService {

    private static final String CLIENT_SERVER_RELATION = "client::server:relation::";

    @Autowired
    private RedisTemplate<String, IMServerInfo> redisTemplate;

    @Override
    public void addServerInfo(String userId, IMServerInfo serverInfo) {
        redisTemplate.opsForHash().put(CLIENT_SERVER_RELATION, userId, serverInfo);
    }

    @Override
    public IMServerInfo getServerInfo(String userId) {
        return (IMServerInfo) redisTemplate.opsForHash().get(CLIENT_SERVER_RELATION, userId);
    }


}
