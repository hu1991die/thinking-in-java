/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Desc 目录列表器
 * @Author feizi
 * @Date 2016/12/29 17:59
 * @Package_name com.feizi.file
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");

        String[] list;

        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        //迭代list集合
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }
}

/**
 * @Desc 目录过滤器
 * @Author feizi
 * @Date 2016/12/29 18:06
 * @param
 * @return
 */
class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
