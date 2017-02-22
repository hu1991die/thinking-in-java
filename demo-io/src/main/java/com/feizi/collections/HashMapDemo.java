/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc HashMap实现
 * @Author feizi
 * @Date 2017/2/20 10:06
 * @Package_name com.feizi.collections
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Object o = map.put("1","feizi");
        System.out.println(o);
        o = map.put("1","hello");
        System.out.println(o);

        HashSet set = new HashSet();
        set.add("feizi");
        set.add("feizi");
        set.add("hello");
        System.out.println(set);

        System.out.println(12 & 14);
        System.out.println(13 & 14);
        System.out.println(14 & 14);

        Hashtable table = new Hashtable();

        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();

        TreeMap treeMap = new TreeMap();
        TreeSet treeSet = new TreeSet();
    }
}
