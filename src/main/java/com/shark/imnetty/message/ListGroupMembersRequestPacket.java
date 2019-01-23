package com.shark.imnetty.message;

import static com.shark.imnetty.message.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * Created by qinghualiu on 2019/1/19.
 */
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
