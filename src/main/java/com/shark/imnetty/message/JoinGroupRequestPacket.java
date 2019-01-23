package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.JOIN_GROUP_REQUEST;

/**
 * Created by qinghualiu on 2019/1/19.
 */
public class JoinGroupRequestPacket extends Packet{

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
