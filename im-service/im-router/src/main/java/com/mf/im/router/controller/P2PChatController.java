package com.mf.im.router.controller;

import com.mf.im.router.service.ChatService;
import com.mf.im.router.service.LoginService;
import com.mf.projects.im.dto.ChatResponse;
import com.mf.projects.im.dto.P2PChatRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/p2p")
public class P2PChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/chat")
    public ChatResponse p2pChat (@RequestBody P2PChatRequest request) {
        ChatResponse chatResponse = new ChatResponse();

        if (!loginService.isLogin(request.getFromUserId())) {
            chatResponse.setCode("3001");
            chatResponse.setMsg("请先登陆");
        }

        if (!loginService.isLogin(request.getToUserId())) {
            chatResponse.setCode("3002");
            chatResponse.setMsg("请对方先登陆");
        }
        chatResponse = chatService.p2pChat(request);

        return chatResponse;
    }

}
