package com.mf.im.server.handler;

import com.mf.projects.im.packet.LoginRequestPacket;
import com.mf.projects.im.packet.LoginResponsePacket;
import com.mf.projects.im.util.LoginUtil;
import com.mf.projects.im.util.Session;
import com.mf.projects.im.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class LoginRequestHandler  extends SimpleChannelInboundHandler<LoginRequestPacket> {

    private static Logger logger = LoggerFactory.getLogger(LoginRequestHandler.class);


    private LoginRequestHandler () {};

    private static LoginRequestHandler instance = new LoginRequestHandler();

    public static LoginRequestHandler getInstance() {
        return instance;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket packet) throws Exception {
        val responsePacket = login(ctx, packet);
        ctx.channel().writeAndFlush(responsePacket);
    }


    private LoginResponsePacket login(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        LoginResponsePacket responsePacket = new LoginResponsePacket();

        if (!SessionUtil.hasLogin(ctx.channel())) {
            responsePacket.setCode("0000");
            responsePacket.setMsg("login success");

            // 标记已经登陆
            LoginUtil.markAsLogin(ctx.channel());
            // session 和 channel 产生绑定关系， 并且把session的信息存储到channel中
            SessionUtil.bindSession(new Session(packet.getUserId(), packet.getUserName(), packet.getPassword()), ctx.channel());
            logger.info("{}({}): login netty server success", packet.getUserName(), packet.getUserId());
        } else {
            responsePacket.setCode("1001");
            responsePacket.setMsg("login failed");
        }

        return responsePacket;
    }


}
