package com.mf.im.client.client;

import com.mf.im.client.handler.LoginHandler;
import com.mf.im.client.handler.LoginResponseHandler;
import com.mf.projects.im.handler.PacketCodecHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientTest {

    private static Logger logger = LoggerFactory.getLogger(ClientTest.class);
    public static String userid = "101";
    public static String username = "tianyalan";

    public static String password = "1234";
    public static String host = "127.0.0.1";
    public static int port = 8888;

    public static void main(String[] args) {
        start();
    }

    public static void start () {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(PacketCodecHandler.getInstance());
                        socketChannel.pipeline().addLast(new LoginHandler(userid, username, password));
                        socketChannel.pipeline().addLast(LoginResponseHandler.getInstance());
                    }
                });
        val future = bootstrap.connect(host, port).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    logger.info("connect to server success");
                } else {
                    logger.info("failed to connect the server");
                    System.exit(0);
                }
            }
        });

        try {
            future.channel().closeFuture().sync();
            logger.info(" close the connection ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
