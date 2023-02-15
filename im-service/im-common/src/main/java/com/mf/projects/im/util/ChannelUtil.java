package com.mf.projects.im.util;

import com.mf.projects.im.protocol.Packet;
import com.mf.projects.im.protocol.PacketCodeC;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.val;

public class ChannelUtil {

    public static void writeAndFlush(Channel channel, Packet packet) {
        val byteBuf = PacketCodeC.getInstance().encode(packet);
        channel.writeAndFlush(byteBuf);
    }

    public static void writeAndFlushWithCtx(ChannelHandlerContext context, Packet packet) {
        val byteBuf = PacketCodeC.getInstance().encode(packet);
        context.writeAndFlush(byteBuf);
    }
}
