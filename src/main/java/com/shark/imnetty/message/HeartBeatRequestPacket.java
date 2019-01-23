package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.HEARTBEAT_REQUEST;

/**
 * Created by qinghualiu on 2019/1/20.
 */
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
