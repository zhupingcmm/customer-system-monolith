package com.mf.im.client.util;

import io.netty.channel.ChannelFuture;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FutureUtil {
    private static final Map<String, ChannelFuture> futureMap = new ConcurrentHashMap<>();

    public static void saveFuture (String userId, ChannelFuture future) {
        futureMap.putIfAbsent(userId, future);
    }

    public static ChannelFuture getFuture (String userId) {
        return futureMap.get(userId);
    }
}
