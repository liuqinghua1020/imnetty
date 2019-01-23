package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.HEARTBEAT_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/20.
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
