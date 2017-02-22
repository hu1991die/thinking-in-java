/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Desc 缓冲流
 * @Author feizi
 * @Date 2017/2/16 10:54
 * @Package_name com.feizi.io
 */
public class TestBufferStream1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestBufferStream1.java");
            BufferedInputStream bis = new BufferedInputStream(fis);

            int c = 0;
            System.out.println((char) bis.read());
            System.out.println((char) bis.read());

            bis.mark(100);
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++){
                System.out.print((char) c + " ");
            }
            System.out.println();
            bis.reset();
            for (int i = 0; i <= 10 && (c = bis.read()) != -1; i++){
                System.out.print((char) c + " ");
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到指定文件...");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取文件失败...");
            System.exit(-1);
        }
    }
}
