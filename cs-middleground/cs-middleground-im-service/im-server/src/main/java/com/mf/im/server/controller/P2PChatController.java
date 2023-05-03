package com.mf.im.server.controller;

import com.mf.projects.im.dto.ChatResponse;
import com.mf.projects.im.dto.P2PChatRequest;
import com.mf.projects.im.packet.MessageResponsePacket;
import com.mf.projects.im.util.ChannelUtil;
import com.mf.projects.im.util.SessionUtil;
import lombok.val;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/p2p")
public class P2PChatController {

    @GetMapping("/chat")
    public String test() {
        return "hello zp";
    }

    @PostMapping("/chat")
    public ChatResponse p2pChat(@RequestBody P2PChatRequest p2PChatRequest){
        ChatResponse chatResponse = new ChatResponse();

        val toUserId = p2PChatRequest.getToUserId();
        // 获取 channel
        val channel = SessionUtil.getChannelByUserId(toUserId);
        if (channel == null) {
            chatResponse.setCode("4001");
            chatResponse.setMsg(toUserId + " do not login, and can not send msg");
            return chatResponse;
        }

        // 获取到 session
        val session = SessionUtil.getSessionByChannel(channel);

        // 组装 response
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserName(session.getUserName());
        responsePacket.setFromUserId(p2PChatRequest.getFromUserId());
        responsePacket.setMsg(p2PChatRequest.getMsg());

        // 通过chanel 向客户端写入数据
        ChannelUtil.writeAndFlush(channel, responsePacket);

        return chatResponse;
    }

}
