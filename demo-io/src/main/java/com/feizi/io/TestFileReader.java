/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Desc 文件字符读取流
 * @Author feizi
 * @Date 2017/2/16 8:57
 * @Package_name com.feizi.io
 */
public class TestFileReader {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("E:\\idea_workspace\\thinking-in-java\\demo-io\\src\\main\\java\\com\\feizi\\io\\TestFileReader.java");

            int c = 0;
//            int ln = 0;
            while ((c = fr.read()) != -1){
                System.out.print((char) c);

                /*if(++ln >= 100){
                    System.out.println();
                    ln = 0;
                }*/
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件...");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("文件读取失败...");
            System.exit(-1);
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("文件读取失败...");
                System.exit(-1);
            }
        }
    }
}
