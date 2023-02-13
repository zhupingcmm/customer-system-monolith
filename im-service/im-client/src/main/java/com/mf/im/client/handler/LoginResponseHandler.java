package com.mf.im.client.handler;

import com.mf.projects.im.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    private static Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    private LoginResponseHandler () {};
    private static LoginResponseHandler instance = new LoginResponseHandler();
    public static LoginResponseHandler getInstance() {
        return instance;
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.success()) {
            logger.info("login success");
        } else {
            logger.error("failed to login");
        }

    }
}
