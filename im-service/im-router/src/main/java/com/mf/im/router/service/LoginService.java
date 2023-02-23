package com.mf.im.router.service;

import com.mf.projects.im.handler.IMLoginRequest;

import java.util.List;

public interface LoginService {

    void login(IMLoginRequest request);

    Boolean isLogin(String userId);

    void logout(String userId);


    IMLoginRequest getLoginInfo(String userId);

    List<IMLoginRequest> getAllIMLoginRequests();


}
