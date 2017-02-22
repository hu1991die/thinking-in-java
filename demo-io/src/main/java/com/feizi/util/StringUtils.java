/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.util;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/12/30 10:18
 * @Package_name com.feizi.util
 */
public final class StringUtils {
    private StringUtils(){

    }

    public static boolean isBlank(String str){
        return str == null || str.trim().length() == 0;
    }

    public static boolean notBlank(String str){
        return !isBlank(str);
    }
}
