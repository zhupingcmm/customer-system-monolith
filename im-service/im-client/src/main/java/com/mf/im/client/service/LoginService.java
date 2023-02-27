package com.mf.im.client.service;

import com.mf.projects.im.handler.IMLoginRequest;

public interface LoginService {
    void login(IMLoginRequest request);

    void logout(String userId);
}
