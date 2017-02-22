/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.io;

import java.io.*;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/16 17:43
 * @Package_name com.feizi.io
 */
public class TestObjectIO {
    public static void main(String[] args) {
        T t = new T();
        t.k = 8;

        try {
            FileOutputStream fos = new FileOutputStream("F:\\javaio\\feizi\\hello.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("F:\\javaio\\feizi\\hello.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T tReaded = (T) ois.readObject();
            System.out.println(tReaded.i + " " + tReaded.j
                    + " " + tReaded.d + " " + tReaded.k + " " + tReaded.l
                    + " " + tReaded.b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class T implements Serializable{
    int i = 10;
    int j = 9;
    double d = 2.3;
    // 被transient关键字所修饰的成员变量在进行序列化的时候不予考虑，输出默认值
    // 最终输出结果：10 9 2.3 0
    transient int k = 15;
    transient String l = "feizi";
    transient boolean b = true;
}