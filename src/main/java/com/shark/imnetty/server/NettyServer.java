package com.shark.imnetty.server;

import com.shark.imnetty.codec.Spliter;
import com.shark.imnetty.handler.IMHandler;
import com.shark.imnetty.handler.server.IMIdleStateHandler;
import com.shark.imnetty.handler.PacketCodecHandler;
import com.shark.imnetty.handler.server.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by qinghualiu on 2018/12/16.
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workdGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workdGroup)
                       .channel(NioServerSocketChannel.class)
                       .childHandler(new ChannelInitializer<NioSocketChannel>() {
                           protected void initChannel(NioSocketChannel ch) {
                               ch.pipeline().addLast(new IMIdleStateHandler());
                               ch.pipeline().addLast(new Spliter());
                               ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                               ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                               ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                               ch.pipeline().addLast(AuthHandler.INSTANCE);
                               ch.pipeline().addLast(IMHandler.INSTANCE);
                           }
                       });
        try {
            ChannelFuture future = serverBootstrap.bind(8080).sync();

            future.channel().closeFuture().addListener(new ChannelFutureListener() {

                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("channel close");
                    bossGroup.shutdownGracefully();
                    workdGroup.shutdownGracefully();
                }
            });
        }finally {

        }
    }
}
