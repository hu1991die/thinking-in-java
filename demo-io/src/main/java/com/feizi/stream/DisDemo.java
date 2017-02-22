/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/12/30 17:02
 * @Package_name com.feizi.stream
 */
public class DisDemo {
    public static void main(String[] args) throws IOException{

        System.out.println((10 << 24) + (10 << 16) + (10 << 8) + (10 << 0));

        String fileName = "demo/dos.txt";
        IOUtils.printHex(fileName);

        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));

        int i = dis.readInt();
        System.out.println(i);

        i = dis.readInt();
        System.out.println(i);

        long j = dis.readLong();
        System.out.println(j);

        double k = dis.readDouble();
        System.out.println(k);

        String str = dis.readUTF();
        System.out.println(str);

        //关闭流
        dis.close();


        /*int b = 0;
        int j = 1;
        while ((b = dis.read()) != -1){
            if(b <= 0xf){
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b & 0xff) + "  ");

            if(j++ % 10 == 0){
                System.out.println();
            }
        }*/
    }
}
