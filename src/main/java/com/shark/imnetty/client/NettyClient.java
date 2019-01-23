package com.shark.imnetty.client;

import com.shark.imnetty.codec.PacketDecoder;
import com.shark.imnetty.codec.PacketEncoder;
import com.shark.imnetty.codec.Spliter;
import com.shark.imnetty.command.ConsoleCommandManager;
import com.shark.imnetty.command.LoginConsoleCommand;
import com.shark.imnetty.handler.PacketCodecHandler;
import com.shark.imnetty.handler.client.*;
import com.shark.imnetty.message.GroupMessageResponsePacket;
import com.shark.imnetty.message.LoginRequestPacket;
import com.shark.imnetty.message.MessageRequestPacket;
import com.shark.imnetty.serializer.PacketCodeC;
import com.shark.imnetty.util.LoginUtil;
import com.shark.imnetty.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinghualiu on 2018/12/17.
 */
public class NettyClient {

    private static Integer MAX_RETRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                 .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                 .handler(new ChannelInitializer<SocketChannel>(){
                     @Override
                     public void initChannel(SocketChannel ch) {
                         ch.pipeline().addLast(new Spliter());
                         ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                         //ch.pipeline().addLast(new PacketDecoder());
                         ch.pipeline().addLast(new LoginResponseHandler());
                         ch.pipeline().addLast(new LogoutResponseHandler());
                         ch.pipeline().addLast(new MessageResponseHandler());
                         ch.pipeline().addLast(new CreateGroupResponseHandler());
                         //ch.pipeline().addLast(new PacketEncoder());
                         ch.pipeline().addLast(new JoinGroupResponseHandler());
                         ch.pipeline().addLast(new ListGroupMembersResponseHandler());
                         ch.pipeline().addLast(new GroupMessageResponseHandler());
                     }
                 });

        // 4.建立连接
        connect(bootstrap, "localhost", 8080, MAX_RETRY);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void connect(Bootstrap bootstrap, String host ,
                                Integer port, int retry){
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(
                        () -> connect(bootstrap, host, port, retry - 1),
                        delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
