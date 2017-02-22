/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.*;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/16 11:31
 * @Package_name com.feizi.io
 */
public class TestBufferStream2 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestBufferStream2.java"));
            BufferedReader br = new BufferedReader(new FileReader("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestBufferStream2.java"));

            String s = null;
            for (int i = 1; i <= 100; i++){
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败...");
            System.exit(-1);
        }
    }
}
