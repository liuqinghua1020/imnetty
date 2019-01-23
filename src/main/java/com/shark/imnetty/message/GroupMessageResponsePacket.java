package com.shark.imnetty.message;

import com.shark.imnetty.handler.Session;

import static com.shark.imnetty.message.Command.GROUP_MESSAGE_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/20.
 */
public class GroupMessageResponsePacket extends Packet {
    private String fromGroupId;
    private String message;
    private Session fromUser;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(String fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }

    public Session getFromUser() {
        return fromUser;
    }

    public void setFromUser(Session fromUser) {
        this.fromUser = fromUser;
    }
}
