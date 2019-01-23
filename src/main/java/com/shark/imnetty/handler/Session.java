package com.shark.imnetty.handler;

/**
 * Created by qinghualiu on 2019/1/7.
 */
public class Session {

    private String userId;
    private String userName;

    public Session(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
