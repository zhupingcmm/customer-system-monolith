package com.mf.im.router.service;

import com.mf.projects.im.handler.IMServerInfo;

public interface ServerInfoService {

    void addServerInfo(String userId, IMServerInfo serverInfo);

     IMServerInfo getServerInfo(String serverId);

}
