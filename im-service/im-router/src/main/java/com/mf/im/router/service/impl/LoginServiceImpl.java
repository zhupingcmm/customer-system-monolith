package com.mf.im.router.service.impl;

import com.mf.im.router.service.LoginService;
import com.mf.projects.im.handler.IMLoginRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginServiceImpl implements LoginService {

    private static Map<String, IMLoginRequest> loginRequestMap = new ConcurrentHashMap<>();


    @Override
    public void login(IMLoginRequest request) {
        loginRequestMap.putIfAbsent(request.getUserId(), request);

    }

    @Override
    public Boolean isLogin(String userId) {
        return loginRequestMap.containsKey(userId);
    }

    @Override
    public void logout(String userId) {
        loginRequestMap.remove(userId);
    }

    @Override
    public IMLoginRequest getLoginInfo(String userId) {
        return loginRequestMap.get(userId);
    }
}
