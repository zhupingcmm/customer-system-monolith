package com.mf.im.router.service.impl;

import com.mf.im.router.cache.LoginRedisRepository;
import com.mf.im.router.service.LoginService;
import com.mf.projects.im.handler.IMLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("redis")
public class RedisLoginServiceImpl implements LoginService {


    @Autowired
    private LoginRedisRepository loginRedisRepository;

    @Override
    public void login(IMLoginRequest request) {
        loginRedisRepository.save(request);
    }

    @Override
    public Boolean isLogin(String userId) {
        return loginRedisRepository.getLoginInfo(userId) != null;
    }

    @Override
    public void logout(String userId) {
        loginRedisRepository.logout(userId);

    }

    @Override
    public IMLoginRequest getLoginInfo(String userId) {
        return loginRedisRepository.getLoginInfo(userId);
    }

    @Override
    public List<IMLoginRequest> getAllIMLoginRequests() {
        return loginRedisRepository.getAllIMLoginRequests();
    }
}
