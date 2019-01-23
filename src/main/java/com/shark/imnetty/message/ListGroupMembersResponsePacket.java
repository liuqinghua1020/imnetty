package com.shark.imnetty.message;

import com.shark.imnetty.handler.Session;

import java.util.List;

import static com.shark.imnetty.message.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/19.
 */
public class ListGroupMembersResponsePacket extends Packet{

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}
