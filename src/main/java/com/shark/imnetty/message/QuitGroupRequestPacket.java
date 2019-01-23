package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.QUIT_GROUP_REQUEST;

/**
 * Created by qinghualiu on 2019/1/19.
 */
public class QuitGroupRequestPacket extends Packet{
    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
