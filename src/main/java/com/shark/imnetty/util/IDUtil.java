package com.shark.imnetty.util;

import java.util.UUID;

/**
 * Created by qinghualiu on 2019/1/14.
 */
public class IDUtil {

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

}
