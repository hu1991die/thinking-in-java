/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc 文件输出字节流
 * @Author feizi
 * @Date 2017/2/15 17:24
 * @Package_name com.feizi.io
 */
public class TestFileOutputStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestFileOutputStream.java");
            out = new FileOutputStream("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestFileOutputStream_01.java");

            while ((b = in.read()) != -1){
                out.write(b);
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("文件复制错误");
            System.exit(-1);
        }
        System.out.println("文件已复制");
    }
}
