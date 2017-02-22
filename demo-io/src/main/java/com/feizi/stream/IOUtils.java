/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Desc IO流工具类
 * @Author feizi
 * @Date 2016/12/30 14:28
 * @Package_name com.feizi.stream
 */
public class IOUtils {

    /**
     * @Desc 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * @Author feizi
     * @Date 2016/12/30 14:29
     * @param fileName 文件名称
     * @return
     */
    public static void printHex(String fileName) throws IOException{
        //把文件作为字节流进行读操作
        FileInputStream fin = new FileInputStream(fileName);

        int b;
        int i = 1;
        while ((b = fin.read()) != -1){
            if(b <= 0xf){
                //单位数前面补0
                System.out.print("0");
            }

            //将整型b转换为16进制表示的字符串
            System.out.print(Integer.toHexString(b & 0xff) + "  ");
            if(i++ % 10 == 0){
                //每输出10个byte换行
                System.out.println();
            }
        }

        //关闭文件流
        fin.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException{
        FileInputStream fin = new FileInputStream(fileName);

        //定义20k大小的字节数组
        byte[] buf = new byte[20 * 1024];
        int j = 1;
        /*int bytes = fin.read(buf, 0, buf.length);
        for (int i = 0; i < bytes; i++){
            if(buf[i] <= 0xf){
                System.out.print("0");
            }

            System.out.print(Integer.toHexString(buf[i]) + "  ");
            if(j++ % 10 == 0){
                System.out.println();
            }
        }*/
        /***
         * 从fin流中批量读取字节，放入到buf这个字节数组中，从第0个
         * 位置开始放，最多放buf.length长度,返回的是读到的字节的长度
         */
        //一次性读完，说明字节数组足够大，返回的是最终读取到的字节的长度

        int bytes = 0;
        while((bytes = fin.read(buf, 0, buf.length)) != -1){
            for (int i = 0; i < bytes; i++){
                if(buf[i] <= 0xf){
                    System.out.print("0");
                }

                /***
                 * byte类型8位，int类型32位，为了避免转换错误，通过
                 * &0xff将高24位清零
                 */
                System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");

                if(j++ % 10 == 0){
                    System.out.println();
                }
            }
        }
    }

    /**
     * @Desc 文件拷贝操作,字节批量读取
     * @Author feizi
     * @Date 2016/12/30 15:30
     * @param
     * @return
     */
    public static void copyFile(File srcFile, File destFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件" + srcFile + "不存在！");
        }

        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile + "不是文件！");
        }

        //读文件
        FileInputStream in = new FileInputStream(srcFile);

        //写文件
        FileOutputStream out = new FileOutputStream(destFile);

        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1){
            out.write(buf, 0, b);
        }
        out.flush();//最好加上,刷新缓冲区

        in.close();
        out.close();
    }

    /**
     * @Desc 利用缓冲流进行文件copy
     * @Author feizi
     * @Date 2016/12/30 17:32
     * @param 
     * @return 
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件" + srcFile + "不存在！");
        }

        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile + "不是文件！");
        }

        //缓冲读取流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        //缓冲写入流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        int c;
        while ((c = bis.read()) != -1){
            bos.write(c);
        }
        bos.flush();//刷新缓冲区
        bis.close();
        bos.close();
    }

    /**
     * @Desc 单字节，不带缓冲进行文件拷贝
     * @Author feizi
     * @Date 2016/12/30 18:28
     * @param
     * @return
     */
    public static void copyFileByByte(File srcFile, File destFile) throws  IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件" + srcFile + "不存在！");
        }

        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile + "不是文件！");
        }

        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        int c;
        while ((c = in.read()) != -1){
            out.write(c);
        }
        out.flush();

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
//        IOUtils.printHex("E:\\idea_workspace\\thinking-in-java\\demo\\IOUtils.java");
//        IOUtils.printHexByByteArray("E:\\idea_workspace\\thinking-in-java\\demo\\IOUtils.java");

//        copyFile(new File("F:\\javaio\\feizi\\日记1.txt"), new File("F:\\javaio\\feizi\\日记2.txt"));
//        copyFileByBuffer(new File("F:\\javaio\\feizi\\日记1.txt"), new File("F:\\javaio\\feizi\\日记3.txt"));

        String srcFileName = "F:\\资源文件\\QQEmotion\\exception.jpg";
        String destFileName1 = "F:\\资源文件\\QQEmotion\\001.jpg";
        String destFileName2 = "F:\\资源文件\\QQEmotion\\002.jpg";
        String destFileName3 = "F:\\资源文件\\QQEmotion\\003.jpg";
        long start = System.currentTimeMillis();

        copyFile(new File(srcFileName), new File(destFileName1));//拷贝文件耗时：7
//        copyFileByBuffer(new File(srcFileName), new File(destFileName2));//拷贝文件耗时：16
//        copyFileByByte(new File(srcFileName), new File(destFileName3));//拷贝文件耗时：238

        long end = System.currentTimeMillis();

        System.out.println("拷贝文件耗时：" + (end - start));
    }
}
