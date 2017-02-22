/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Desc 读写转换流1
 * @Author feizi
 * @Date 2017/2/16 13:18
 * @Package_name com.feizi.io
 */
public class TestTransForm1 {
    public static void main(String[] args) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\javaio\\feizi\\hello.txt"));
            osw.write("feizi at ssssssss 飞子");

            System.out.println(osw.getEncoding());
            osw.close();

            osw = new OutputStreamWriter(new FileOutputStream("F:\\javaio\\feizi\\hello.txt", true),"ISO8859_1");//latin-1
            osw.write("feizi at ssssssss 飞子");

            System.out.println(osw.getEncoding());
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
