/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.*;

/**
 * @Desc BufferedReader和BufferedWriter/PrintWriter
 * @Author feizi
 * @Date 2017/1/3 10:37
 * @Package_name com.feizi.stream
 */
public class BrAndBwOrPwDemo {

    public static void main(String[] args) throws IOException{
        String fileName1 = "F:\\javaio\\feizi\\stream.txt";
        String fileName2 = "F:\\javaio\\feizi\\stream5.txt";

        //对文件进行读写操作
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName1)));

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName2)));

        String line;
        while ((line = br.readLine()) != null){
            //一次读一行,并不能识别换行
            System.out.println(line);

            bw.write(line);
            //单独写出换行操作
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
