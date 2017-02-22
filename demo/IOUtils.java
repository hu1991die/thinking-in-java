/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.FileInputStream;
import java.io.IOException;

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
            //将整型b转换为16进制表示的字符串
            System.out.print(Integer.toHexString(b) + "  ");
            if(i++ % 10 == 0){
                //每输出10个byte换行
                System.out.println();
            }
        }
        fin.close();
    }

    public static void main(String[] args) throws IOException {
        IOUtils.printHex("E:\\idea_workspace\\thinking-in-java\\demo\\raf.txt");
    }
}
