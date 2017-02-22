/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.file;

import com.feizi.util.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Desc java.io.File类用于表示文件（目录）
 * File类只用于表示文件（目录）的基本信息（名称、大小等）
 * 不能用于文件内容的访问
 * @Author feizi
 * @Date 2016/12/30 10:52
 * @Package_name com.feizi.file
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //创建目录对象
        File file = new File("F:\\javaio\\feizi");
        //判断目录和文件是否存在
        System.out.println(file.exists());

        if(!file.exists()){
            //创建单级目录
//            file.mkdir();

            //创建多级目录
            file.mkdirs();
        }else{
            //删除目录,或文件
//            file.delete();
        }

        //判断是否是一个目录,如果是目录返回true,如果不是目录或者目录不存在则返回false
        System.out.println(file.isDirectory());

        //判断是否是一个文件
        System.out.println(file.isFile());

        //创建文件对象
//        File file2 = new File("F:\\javaio\\feizi\\日记1.txt");
        File file2 = new File("F:\\javaio\\feizi", "日记1.txt");
        if(!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
//            file2.delete();
        }

        //直接打印，调用了toString()方法
        System.out.println(file);
        System.out.println(file2);

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.getParentFile());
        System.out.println(file2.getPath());
        try {
            System.out.println(file2.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUtils.listDirectory(file);
    }
}
