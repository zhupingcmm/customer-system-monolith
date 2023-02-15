package com.mf.im.server.handler;

import com.mf.projects.im.packet.DefaultErrorPacket;
import com.mf.projects.im.packet.MessageRequestPacket;
import com.mf.projects.im.packet.MessageResponsePacket;
import com.mf.projects.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    private static Logger logger = LoggerFactory.getLogger(MessageRequestHandler.class);

    private MessageRequestHandler(){}

    private static MessageRequestHandler instance = new MessageRequestHandler();

    public static MessageRequestHandler getInstance() {
        return instance;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket packet) throws Exception {
        logger.info("received message {} from client", packet.getMessage());

        val session = SessionUtil.getSessionByChannel(ctx.channel());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMsg(packet.getMessage());
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());

        p2tChat(ctx, packet.getToUserId(), messageResponsePacket);

    }


    private void p2tChat(ChannelHandlerContext ctx, String toUserId, MessageResponsePacket responsePacket) {
        Channel channel = SessionUtil.getChannelByUserId(toUserId);
        if ( ctx.channel() != null && SessionUtil.hasLogin(ctx.channel())) {
            channel.writeAndFlush(responsePacket);
        } else {
            DefaultErrorPacket defaultErrorPacket = new DefaultErrorPacket();
            defaultErrorPacket.setCode("3001");
            defaultErrorPacket.setMsg("该用户没有登录，无法发送消息");
            channel.writeAndFlush(defaultErrorPacket);
        }
    }
}
