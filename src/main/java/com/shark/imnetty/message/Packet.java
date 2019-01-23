package com.shark.imnetty.message;

/**
 * Created by qinghualiu on 2018/12/20.
 */
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    public Byte getVersion(){
        return version;
    }

    public abstract Byte getCommand();

    public void setVersion(Byte version) {
        this.version = version;
    }
}
