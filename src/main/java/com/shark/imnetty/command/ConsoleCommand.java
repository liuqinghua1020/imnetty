package com.shark.imnetty.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
