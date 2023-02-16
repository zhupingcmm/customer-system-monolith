package com.mf.im.client.client;

import com.mf.im.client.handler.ClientIdleHandler;
import com.mf.im.client.handler.LoginHandler;
import com.mf.im.client.handler.LoginResponseHandler;
import com.mf.im.client.handler.MessageResponseHandler;
import com.mf.projects.im.handler.*;
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
import org.springframework.web.client.RestTemplate;

public class ClientRouterTest1 {

    private static Logger logger = LoggerFactory.getLogger(ClientRouterTest1.class);
    public static String userid = "101";
    public static String username = "tianyalan";

    public static String password = "1234";
    public static String routeHost = "127.0.0.1";
    public static int routePort = 18002;

    public static void main(String[] args) {
        start();
    }


    public static void start () {
        // 获取 im server 的信息
        val imServerInfo = getIMServerInfo(routeHost, routePort);
        // 登录
        loginRoute(imServerInfo);
        // 链接netty的服务端
        connectToServer(imServerInfo);
    }

    private static void loginRoute (IMServerInfo imServerInfo){
        RestTemplate restTemplate = new RestTemplate();
        IMLoginRequest request = new IMLoginRequest();
        request.setUserId(userid);
        request.setUserName(username);
        request.setServerHost(imServerInfo.getHost());
        request.setHttpPort(imServerInfo.getHttpPort());
        request.setNettyPort(imServerInfo.getNettyPort());
        val response = restTemplate.postForObject("http://" + routeHost + ":" + routePort + "/auth/login", request, IMLoginResponse.class);

        if (response.success()) {
            logger.info("登陆成功");
        } else {
            logger.info("登陆失败");
            System.exit(0);
        }
    }
    public static IMServerInfo getIMServerInfo(String routeHost, int routePort){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + routeHost + ":" + routePort + "/serverinfo", IMServerInfo.class);
    }

    public static void connectToServer(IMServerInfo serverInfo) {
        startNettyClient(serverInfo);
    }

    public static void startNettyClient (IMServerInfo serverInfo) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast(new ServerHandler());
                        channel.pipeline().addLast(PacketCodecHandler.getInstance());
                        channel.pipeline().addLast(new ClientIdleHandler());
                        channel.pipeline().addLast(new LoginHandler(userid, username, password));
                        channel.pipeline().addLast(LoginResponseHandler.getInstance());
                        channel.pipeline().addLast(MessageResponseHandler.getInstance());
                    }
                });
        val future = bootstrap.connect(serverInfo.getHost(), serverInfo.getNettyPort()).addListener(new ChannelFutureListener() {
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
