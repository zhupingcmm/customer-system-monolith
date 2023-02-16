package com.mf.projects.im.util;

import io.netty.channel.Channel;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class SessionUtil {

    private static final Map<String, Channel> sessionMap = new HashMap<>();

    public static void bindSession (Session session, Channel channel) {
        sessionMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static boolean hasLogin(Channel channel) {
        val login = channel.attr(Attributes.LOGIN);
        return login.get() != null;
    }

    public static Session getSessionByChannel(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannelByUserId(String userId){
       return sessionMap.get(userId);
    }

    public static void removeChannel(Channel channel){
        sessionMap.values().remove(channel);
        System.out.println(sessionMap);
    }



}
