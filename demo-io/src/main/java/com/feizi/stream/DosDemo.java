/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/12/30 16:39
 * @Package_name com.feizi.stream
 */
public class DosDemo {

    public static void main(String[] args) throws IOException{
        String fileName = "demo/dos.txt";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));

        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用UTF-8编码写出
        dos.writeUTF("中国");
        //采用utf-16be编码写出
        dos.writeChars("中国");

        dos.close();

        IOUtils.printHex(fileName);
    }
}
