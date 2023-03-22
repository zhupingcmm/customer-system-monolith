package com.mf.im.router.service.impl;


import com.mf.im.router.service.ChatService;
import com.mf.im.router.service.LoginService;
import com.mf.projects.im.dto.ChatResponse;
import com.mf.projects.im.dto.P2PChatRequest;
import lombok.val;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {

    private static final String MESSAGE_EXCHANGE = "message_exchange";

    private static final String IM_MESSAGE_KEY = "im_messages_key";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public ChatResponse p2pChat(P2PChatRequest request) {
        // 获取 用户信息
        val loginInfo = loginService.getLoginInfo(request.getToUserId());

        // 发送 message 到 im server
        val chatResponse = restTemplate.postForObject("http://" + loginInfo.getServerHost() + ":" + loginInfo.getHttpPort() + "/p2p/chat",
                request, ChatResponse.class);
        // 存储 chat message
        rabbitTemplate.convertAndSend(MESSAGE_EXCHANGE, IM_MESSAGE_KEY, request);
        return chatResponse;
    }
}
