package com.mf.im.router.service;

import com.mf.projects.im.handler.IMLoginRequest;

public interface LoginService {

    void login(IMLoginRequest request);

    Boolean isLogin(String userId);

    void logout(String userId);


    IMLoginRequest getLoginInfo(String userId);


}
