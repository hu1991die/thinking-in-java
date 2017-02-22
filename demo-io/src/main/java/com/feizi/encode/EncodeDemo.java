/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.encode;

import java.io.UnsupportedEncodingException;

/**
 * @Desc 编码学习
 * @Author feizi
 * @Date 2016/12/30 10:05
 * @Package_name com.feizi.encode
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "慕课ABC";
        //转换成字节序列使用的是项目默认设置的编码格式（默认设置成了UTF-8,中文汉字占用三个字节，英文占用一个字节）
        byte[] bytes1 = strToByteArray(str);
        printBytes(bytes1);

        //GBK，中文汉字占用两个字节，英文占用一个字节
        byte[] bytes2 = strToByteArray(str, "GBK");
        printBytes(bytes2);

        //GB2312，中文汉字占用两个字节，英文占用一个字节
        byte[] bytes3 = strToByteArray(str, "GB2312");
        printBytes(bytes3);

        //utf-16be，中文汉字占用两个字节，英文占用两个字节,java是双字节编码
        byte[] bytes4 = strToByteArray(str, "utf-16be");
        printBytes(bytes4);

        /***
         * 当你的字节序列为某一种编码格式时，这个时候如果想把字节序列转换
         * 成字符串，也需要使用相应的编码格式进行转换，否则会出现乱码
         */
        //项目默认是UTF-8，而bytes4使用了utf-16be,所以结果会出现乱码:aU�� A B C
        String str1 = new String(bytes4);
        System.out.println(str1);

        String str2 = new String(bytes4, "utf-16be");
        System.out.println(str2);

        String str3 = new String(bytes3, "GB2312");
        System.out.println(str3);

        String str4 = new String(bytes2, "GBK");
        System.out.println(str4);

        String str5 = new String(bytes1, "UTF-8");
        System.out.println(str5);

        /***
         * 得出结论：
         * 文本文件，就是字节序列
         * 可以是任意编码格式的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文本文件默认
         * 是以ansi编码格式保存文本信息。
         * 联通只是一种巧合，刚好符合UTF-8编码规则
         */
    }

    /**
     * @Desc 打印字节数组
     * @Author feizi
     * @Date 2016/12/30 10:24
     * @param 
     * @return 
     */
    public static void printBytes(byte[] bytes){
        for (byte b: bytes) {
            //把字节转换成int，以十六进制方式显示
            System.out.print(Integer.toHexString(b) + " ");
        }

        System.out.println("");

        for (byte b: bytes) {
            //把字节转换成int，以十六进制方式显示,去除前面24个0
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println("");
    }

    /**
     * @Desc 字符串转换成字节数组（取系统默认设置的编码格式）
     * @Author feizi
     * @Date 2016/12/30 10:23
     * @param
     * @return
     */
    public static byte[] strToByteArray(String str){
        return str.getBytes();
    }

    /**
     * @Desc 字符串转换成字节数组
     * @Author feizi
     * @Date 2016/12/30 10:16
     * @param
     * @return
     */
    public static byte[] strToByteArray(String str, String sourceEncoding){
        try {
            return str.getBytes(sourceEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
