package com.mf.projects.im.handler;

import com.mf.projects.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends IdleStateHandler {

    private Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    private static final int  HEAT_BEAT_TIME = 15;


    public ServerHandler() {
        super(0, 0, HEAT_BEAT_TIME);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        val session = SessionUtil.getSessionByChannel(ctx.channel());
        logger.info("{}({}): logout netty server", session.getUserName(), session.getUserId());
        // 清空缓存的 channel 信息
        SessionUtil.removeChannel(ctx.channel());
        super.handlerRemoved(ctx);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        logger.warn("In {} seconds, process do not received any heat beat" , HEAT_BEAT_TIME);
        ctx.channel().close();
    }
}
