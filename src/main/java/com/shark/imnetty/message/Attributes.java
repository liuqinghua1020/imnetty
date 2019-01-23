package com.shark.imnetty.message;

import com.shark.imnetty.handler.Session;
import io.netty.util.AttributeKey;

/**
 * Created by qinghualiu on 2018/12/26.
 */
public class Attributes {

    public static AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    public static AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
