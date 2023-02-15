package com.mf.im.server.server;

import com.mf.im.server.handler.LoginRequestHandler;
import com.mf.im.server.handler.MessageRequestHandler;
import com.mf.projects.im.handler.PacketCodecHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class Server {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private static int port = 8888;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        NioEventLoopGroup boss = new NioEventLoopGroup();

        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(PacketCodecHandler.getInstance());
                        nioSocketChannel.pipeline().addLast(LoginRequestHandler.getInstance());
                        nioSocketChannel.pipeline().addLast(MessageRequestHandler.getInstance());
                    }
                });
        val future = bootstrap.bind(port);
        future.addListener((ChannelFutureListener) channelFuture -> {
            if (channelFuture.isSuccess()) {
                logger.info("netty server started! using port {}", port);
            } else {
                logger.info("netty server start failed! using port {}", port);
                channelFuture.cause().printStackTrace();
                System.exit(0);
            }
        });
    }
}
