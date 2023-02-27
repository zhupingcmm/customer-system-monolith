package com.mf.im.client.service;

import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMServerInfo;

public interface LoginService {
    void login(IMLoginRequest request);

    void logout(String userId, IMServerInfo imServerInfo);
}
