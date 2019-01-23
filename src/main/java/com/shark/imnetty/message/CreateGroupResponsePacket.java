package com.shark.imnetty.message;

import java.util.List;

import static com.shark.imnetty.message.Command.CREATE_GROUP_RESPONSE;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String>  userNameList;
    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }
}
