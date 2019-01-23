package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.LOGOUT_REQUEST;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
