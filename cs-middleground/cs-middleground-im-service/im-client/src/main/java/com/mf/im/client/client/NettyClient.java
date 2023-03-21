package com.mf.im.client.client;

import com.mf.im.client.handler.ClientIdleHandler;
import com.mf.im.client.handler.LoginHandler;
import com.mf.im.client.handler.LoginResponseHandler;
import com.mf.im.client.handler.MessageResponseHandler;
import com.mf.im.client.service.ImRouterService;
import com.mf.im.client.service.LoginService;
import com.mf.im.client.util.FutureUtil;
import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMServerInfo;
import com.mf.projects.im.handler.PacketCodecHandler;
import com.mf.projects.im.handler.ServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Slf4j
@Scope(value = "prototype")
@Component
public class NettyClient {

    @Autowired
    private ImRouterService imRouterService;

    public ChannelFuture  start (IMServerInfo serverInfo, IMLoginRequest request) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast(new ServerHandler());
                        channel.pipeline().addLast(PacketCodecHandler.getInstance());
                        channel.pipeline().addLast(new ClientIdleHandler());
                        channel.pipeline().addLast(new LoginHandler(request.getUserId(), request.getUserName(), request.getPassword()));
                        channel.pipeline().addLast(LoginResponseHandler.getInstance());
                        channel.pipeline().addLast(MessageResponseHandler.getInstance());
                    }
                });
        val future = bootstrap.connect(serverInfo.getHost(), serverInfo.getNettyPort()).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    log.info("{}:({}) connect to netty server success", request.getUserName(), request.getUserId());
                } else {
                    log.info("{}:({}) failed to netty connect the server", request.getUserName(), request.getUserId());
                }
            }
        });

        FutureUtil.saveFuture(request.getUserId(), future);

        try {
            future.channel().closeFuture().sync();
            imRouterService.logout(request.getUserId());
            log.info("{}:({}) close the connection with netty server ", request.getUserName(), request.getUserId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return future;
    }
}
