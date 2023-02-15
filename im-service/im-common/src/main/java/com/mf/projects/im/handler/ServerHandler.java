package com.mf.projects.im.handler;

import com.mf.projects.im.packet.HeartBeatPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends IdleStateHandler {

    private Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    private static final int  HEAT_BEAT_TIME = 15;


    public ServerHandler() {
        super(0, 0, HEAT_BEAT_TIME);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        logger.warn("In {} seconds, process do not received any heat beat" , HEAT_BEAT_TIME);
        ctx.channel().close();
    }
}
