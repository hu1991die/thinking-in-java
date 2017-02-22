/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc FileOutputStreamDemo写文件
 * @Author feizi
 * @Date 2016/12/30 15:16
 * @Package_name com.feizi.stream
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        //如果该文件不存在，则直接创建,如果存在则删除后创建
        String fileName = "demo/out.txt";
        FileOutputStream out = new FileOutputStream(fileName);
        out.write('A');//写出了'A'的低8位
        out.write('B');//写出了'B'的低8位

        int a = 10;//write方法只能写低8位，那么写一个整数需要写4次，，每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a >>> 0);

        out.write(a);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtils.printHex(fileName);

    }
}
