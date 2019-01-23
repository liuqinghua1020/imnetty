package com.shark.imnetty.handler.server;

import com.shark.imnetty.handler.Session;
import com.shark.imnetty.message.LoginRequestPacket;
import com.shark.imnetty.message.LoginResponsePacket;
import com.shark.imnetty.serializer.PacketCodeC;
import com.shark.imnetty.util.LoginUtil;
import com.shark.imnetty.util.SessionUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * Created by qinghualiu on 2018/12/28.
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    // 2. 构造单例
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    protected LoginRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        ctx.channel().writeAndFlush(login(ctx, loginRequestPacket));
    }

    private LoginResponsePacket login(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket){
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());

        if(valid(loginRequestPacket)){
            //验证成功
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
            //LoginUtil.markAsLogin(ctx.channel());

            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());

        }else{
            //验证失败
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("账号密码校验失败");
            System.out.println(new Date() + ": 登录失败!");
        }
        return loginResponsePacket;
    }

    // 用户断线之后取消绑定
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }

    private String randomUserId() {
        return UUID.randomUUID().toString();
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
