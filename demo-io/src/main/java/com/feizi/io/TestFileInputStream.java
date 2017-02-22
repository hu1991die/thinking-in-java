/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Desc FileInputStream字节输入流
 * @Author feizi
 * @Date 2017/2/15 16:36
 * @Package_name com.feizi.io
 */
public class TestFileInputStream {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            in = new FileInputStream("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestFileInputStream.java");
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件...");
            System.exit(-1);
        }

        try {
            int b = 0;
            long num = 0;
            while ((b = in.read()) != -1){
                System.out.print((char) b);
                num++;
            }
            in.close();
            System.out.println();
            System.out.println("共读取了" + num + "个字节...");
        } catch (IOException e) {
            System.out.println("文件读取错误");
            System.exit(-1);
        }
    }
}
