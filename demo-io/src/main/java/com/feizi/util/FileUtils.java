/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.util;

import java.io.File;
import java.io.IOException;

/**
 * @Desc 列出File类的一些常用操作,比如过滤、遍历等操作
 * @Author feizi
 * @Date 2016/12/30 11:32
 * @Package_name com.feizi.util
 */
public class FileUtils {

    /**
     * @Desc 列出指定目录下（包括其子目录）的所有文件
     * @Author feizi
     * @Date 2016/12/30 11:34
     * @param
     * @return
     */
    public static void listDirectory(File dir) throws IOException{
        if(!dir.exists()){
            throw new IllegalArgumentException("目录：" + dir + "不存在！");
        }

        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir + "不是目录！");
        }

        //list()方法用于列出当前目录下的子目录或者文件,并且返回的是字符串数组
        /*String[] fileNames = dir.list();
        for (String fileName : fileNames){
            System.out.println(dir + File.separator + fileName);
        }*/

        //如果要遍历子目录下的内容就需要构造成File对象然后做递归操作，File提供了直接返回File对象的API
        File[] files = dir.listFiles();//返回的是直接子目录（文件）的抽象
        if(null != files && files.length > 0){
            for (File file : files) {
                if(file.isDirectory()){
                    //递归操作
                    listDirectory(file);
                }else{
                    System.out.println(file);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        listDirectory(new File("F:\\资源文件"));
    }
}
