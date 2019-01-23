package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.LOGIN_RESPONSE;

/**
 * Created by qinghualiu on 2018/12/24.
 */
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String userId;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
