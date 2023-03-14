package com.mf.im.client.handler;

import com.mf.projects.im.packet.LoginRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginHandler extends ChannelInboundHandlerAdapter {
    private String userId;
    private String userName;

    private String password;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(this.userId);
        loginRequestPacket.setUserName(this.userName);
        loginRequestPacket.setPassword(this.password);

        ctx.channel().writeAndFlush(loginRequestPacket);
    }
}
