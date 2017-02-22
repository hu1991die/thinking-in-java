/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.*;

/**
 * @Desc 处理流
 * @Author feizi
 * @Date 2017/2/16 14:33
 * @Package_name com.feizi.io
 */
public class TestDataStream {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());

            DataInputStream dis = new DataInputStream(bais);
            // 先写的先读
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());

            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
