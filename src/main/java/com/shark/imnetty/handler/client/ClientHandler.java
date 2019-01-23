package com.shark.imnetty.handler.client;

import com.shark.imnetty.message.LoginRequestPacket;
import com.shark.imnetty.message.LoginResponsePacket;
import com.shark.imnetty.message.MessageResponsePacket;
import com.shark.imnetty.message.Packet;
import com.shark.imnetty.serializer.PacketCodeC;
import com.shark.imnetty.util.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

/**
 * Created by qinghualiu on 2018/12/19.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + " 客户端开始登陆");

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    }

}
