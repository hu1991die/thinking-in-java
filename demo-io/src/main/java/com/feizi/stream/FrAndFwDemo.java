/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Desc 字符流之文件读写流
 * 使用文件读写流进行文件的拷贝操作
 * @Author feizi
 * @Date 2017/1/3 10:09
 * @Package_name com.feizi.stream
 */
public class FrAndFwDemo {

    public static void main(String[] args) throws IOException{
        String fileName1 = "F:/javaio/feizi/streamutf8.txt";
        String fileName2 = "F:/javaio/feizi/streamutf82.txt";

        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);

        char[] buffer = new char[8 * 1024];
        int c;
        while ((c = fr.read(buffer, 0, buffer.length)) != -1){
            fw.write(buffer, 0, c);
        }
        fw.flush();

        fw.close();
        fr.close();
    }
}
