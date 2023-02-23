package com.mf.im.router.cache;

import com.mf.projects.im.handler.IMLoginRequest;

import java.util.List;

public interface LoginRedisRepository {

    void save(IMLoginRequest request);

    void logout(String userId);

    IMLoginRequest getLoginInfo(String userId);


    List<IMLoginRequest> getAllIMLoginRequests();
}
