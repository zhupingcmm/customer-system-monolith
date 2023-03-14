package com.mf.im.server.handler;

import com.alibaba.fastjson.JSON;
import com.mf.projects.im.packet.HeartBeatPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class HeartBeatHandler extends SimpleChannelInboundHandler<HeartBeatPacket> {

    private Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);

    private HeartBeatHandler(){}

    private static HeartBeatHandler instance = new HeartBeatHandler();

    public static HeartBeatHandler getInstance() {
        return instance;
    }



    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HeartBeatPacket heartBeatPacket) throws Exception {
       // logger.info("收到心跳包：{}", JSON.toJSONString(heartBeatPacket));
        logger.info("=== zp ====");
        channelHandlerContext.writeAndFlush(heartBeatPacket);
    }
}
