/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.serialize;

import java.io.*;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/1/3 14:57
 * @Package_name com.feizi.serialize
 */
public class StudentSeriaDemo {

    public static void main(String[] args) throws IOException{
        String file = "demo-io/obj.ser";

        //1、对象的序列化
        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));

        Student student = new Student("10001", "张三", 20);
        oos.writeObject(student);

        oos.flush();
        oos.close();*/

        //2、对象的反序列化
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));

        try {
            Student student = (Student) ois.readObject();
            ois.close();

            System.out.println(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
