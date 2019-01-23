package com.shark.imnetty.handler.client;

import com.shark.imnetty.handler.Session;
import com.shark.imnetty.message.LoginRequestPacket;
import com.shark.imnetty.message.LoginResponsePacket;
import com.shark.imnetty.util.LoginUtil;
import com.shark.imnetty.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * Created by qinghualiu on 2018/12/28.
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            //LoginUtil.markAsLogin(ctx.channel());
            //System.out.println(new Date() + ": 客户端登录成功");
            System.out.println(new Date() + ": 客户端登录成功, userId :  "  + loginResponsePacket.getUserId());
            SessionUtil.buildSession(new Session(loginResponsePacket.getUserId(), null), ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
        }
    }
}
