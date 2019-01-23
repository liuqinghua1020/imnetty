package com.shark.imnetty.command;

import com.shark.imnetty.message.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
