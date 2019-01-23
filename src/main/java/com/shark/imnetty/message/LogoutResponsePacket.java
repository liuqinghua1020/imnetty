package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.LOGOUT_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class LogoutResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
