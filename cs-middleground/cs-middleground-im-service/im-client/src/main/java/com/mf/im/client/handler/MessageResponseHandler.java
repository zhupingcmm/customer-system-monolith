package com.mf.im.client.handler;

import com.mf.projects.im.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    private static Logger logger = LoggerFactory.getLogger(MessageResponseHandler.class);

    private MessageResponseHandler () {}
    private static MessageResponseHandler instance = new MessageResponseHandler();
    public static MessageResponseHandler getInstance (){
        return instance;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket responsePacket) throws Exception {
        logger.info("{}({}): msg {}", responsePacket.getFromUserName(), responsePacket.getFromUserId(), responsePacket.getMsg());

    }
}
