package com.realworld.util;

import java.util.UUID;

public class GeneralUtil {

    public static String getCode(int len) {
        return UUID.randomUUID().toString().substring(0, len);
    }
}
