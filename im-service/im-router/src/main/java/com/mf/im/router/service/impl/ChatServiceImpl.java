package com.mf.im.router.service.impl;

import com.mf.im.router.service.ChatService;
import com.mf.im.router.service.LoginService;
import com.mf.projects.im.dto.ChatResponse;
import com.mf.projects.im.dto.P2PChatRequest;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private LoginService loginService;
    @Override
    public ChatResponse p2pChat(P2PChatRequest request) {
        val loginInfo = loginService.getLoginInfo(request.getFromUserId());
        val chatResponse = restTemplate.postForObject("http://" + loginInfo.getServerHost() + ":" + loginInfo.getHttpPort() + "/p2p/chat",
                request, ChatResponse.class);
        return chatResponse;
    }
}
