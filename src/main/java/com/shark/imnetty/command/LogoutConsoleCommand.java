package com.shark.imnetty.command;

import com.shark.imnetty.message.LogoutRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class LogoutConsoleCommand implements ConsoleCommand  {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
