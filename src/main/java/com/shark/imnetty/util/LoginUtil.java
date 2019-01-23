package com.shark.imnetty.util;

import com.shark.imnetty.message.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * Created by qinghualiu on 2018/12/26.
 */
// @see SessionUtil
@Deprecated
public class LoginUtil {

    public static void markAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr =  channel.attr(Attributes.LOGIN);
        if(loginAttr == null || loginAttr.get() == null) return false;
        return loginAttr.get();
    }


}
