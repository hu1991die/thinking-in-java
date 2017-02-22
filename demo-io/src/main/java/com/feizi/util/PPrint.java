/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/12/29 19:29
 * @Package_name com.feizi.util
 */
public class PPrint {

    public static String pformat(Collection<?> c){
        if(c.size() == 0){
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c){
            if(c.size() != 1){
                result.append("\n   ");
            }
            result.append(elem);
        }

        if(c.size() != 1){
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}
