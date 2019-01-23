package com.shark.imnetty.message;

import java.util.List;

import static com.shark.imnetty.message.Command.CREATE_GROUP_REQUEST;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;


    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }
}
