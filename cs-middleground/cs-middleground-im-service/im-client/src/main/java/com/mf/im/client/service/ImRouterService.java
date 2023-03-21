package com.mf.im.client.service;

import com.mf.projects.im.handler.IMServerInfo;

import java.net.URI;

public interface ImRouterService {

    URI getImRouterUri();

    IMServerInfo getIMServerInfo();


    void logout(String userId);

}
