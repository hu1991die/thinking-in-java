/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.*;

/**
 * @Desc 字符输入流和输出流,以字符的方式进行拷贝，需要注意编码格式问题
 * @Author feizi
 * @Date 2016/12/30 18:56
 * @Package_name com.feizi.stream
 */
public class IsrAndOswDemo {

    public static void main(String[] args) throws IOException{
        String fileName1 = "F:\\javaio\\feizi\\stream.txt";
        String fileName2 = "F:\\javaio\\feizi\\stream2.txt";

        FileInputStream in = new FileInputStream(fileName1);
        //默认为项目的缺省编码格式
        InputStreamReader isr = new InputStreamReader(in, "UTF-8");

        FileOutputStream out = new FileOutputStream(fileName2);
        OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");

        /*int c;
        while ((c = isr.read()) != -1){
            System.out.print((char) c);
        }*/

        //批量读取
        char[] buffer = new char[8 * 1024];
        int c;
        //批量读取，放入buffer这个字符数组，从第0个位置开始放，最多放buffer.length长度
        //返回的最终读取到的实际字符数组长度
        while ((c = isr.read(buffer, 0, buffer.length)) != -1){
            /*for (int i = 0; i < c; i ++){
                System.out.print(buffer[i]);
            }*/

            String str = new String(buffer, 0, c);
            System.out.println(str);

            osw.write(buffer, 0, c);
        }
        osw.flush();

        osw.close();
        out.close();
        isr.close();
        in.close();
    }
}
