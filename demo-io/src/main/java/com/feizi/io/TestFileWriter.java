/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Desc 文件字符写出流
 * @Author feizi
 * @Date 2017/2/16 9:07
 * @Package_name com.feizi.io
 */
public class TestFileWriter {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestFileWriter_01.java");
            for (int c = 0; c <= 50000; c++){
                fw.write(c);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入错误...");
            System.exit(-1);
        }
    }
}
