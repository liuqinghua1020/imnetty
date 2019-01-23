package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.GROUP_MESSAGE_REQUEST;
import static com.shark.imnetty.message.Command.GROUP_MESSAGE_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/20.
 */
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message){
        this.toGroupId = toGroupId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(String toGroupId) {
        this.toGroupId = toGroupId;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }


}
