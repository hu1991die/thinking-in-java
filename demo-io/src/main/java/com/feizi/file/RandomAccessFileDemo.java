/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @Desc 随机访问文件内容
 * RandomAccessFile 是java提供的对文件内容的访问，既可以读文件，
 * 也可以写文件，同时还支持随机访问文件，并且可以访问文件的任意位置
 *
 * (1)Java文件模型
 *  在硬盘上的文件是byte byte byte方式进行存储的，是数据的集合
 *
 * (2)打开文件
 * 有两种模式：
 *  “rw”——读写方式
 *  “r”——只读方式
 *
 *  构造函数：
 *  RandomAccessFile raf = new RandomAccessFile(file, "rw");
 *
 *  文件指针，打开文件时指针处在开头的位置，即pointer = 0;
 *  随着文件的读写操作进行，指针会后移
 *
 *  (3)写文件
 *  raf.write(int)——》只写一个字节（后8位）,同时指针指向下一个字节的位置，准备再次写入
 *
 *  (4)读文件
 *  int b = raf.read();——》读一个字节
 *
 *  (5)文件读写完成以后一定要关闭文件流（Oracle官方说明）
 * @Author feizi
 * @Date 2016/12/30 13:19
 * @Package_name com.feizi.file
 */
public class RandomAccessFileDemo{

    public static void main(String[] args) throws IOException{
        //创建目录
        File dir = new File("demo");
        if(!dir.exists()){
            dir.mkdir();
        }

        //创建文件
        File file = new File(dir, "raf.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //指针的位置
        System.out.println(raf.getFilePointer());//0

        raf.write('A');//只写了一个字节，后8位
        System.out.println(raf.getFilePointer());//1

        raf.write('B');
        System.out.println(raf.getFilePointer());//2

        int i = 0x7fffffff;
        //用write方法每次只能写一个字节，如果要把这个整型的i写进去，就得写4次
        raf.write((i >>> 24) & 0xFF);//高8位，右移24
        raf.write((i >>> 16) & 0xFF);
        raf.write((i >>> 8) & 0xFF);
        raf.write((i >>> 0) & 0xFF);
        System.out.println(raf.getFilePointer());//6

        //可以直接写一个int
        raf.writeInt(i);

        String str = "中";
        byte[] gbks = str.getBytes("gbk");

        raf.write(gbks);
        System.out.println(raf.getFilePointer());//8
        System.out.println(raf.length());//12

        //读文件时，必须把指针移动到文件头部
        raf.seek(0);

        //一次性读取,把文件中的内容一次性都读取到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);

        System.out.println(Arrays.toString(buf));

        String s1 = new String(buf, "gbk");
        System.out.println(s1);

        for (byte b: buf) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }


        //关闭文件流
        buf.clone();
    }
}
