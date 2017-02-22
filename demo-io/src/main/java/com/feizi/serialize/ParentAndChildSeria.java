/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.serialize;

import java.io.*;

/**
 * @Desc 序列化中 子类和父类构造函数的调用问题
 * @Author feizi
 * @Date 2017/1/3 16:24
 * @Package_name com.feizi.serialize
 */
public class ParentAndChildSeria {

    public static void main(String[] args) throws Exception{

        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo-io/obj5.ser"));

        Foo2 foo2 = new Foo2();
        oos.writeObject(foo2);

        oos.flush();
        oos.close();*/

        //反序列化操作是否会递归调用父类的构造函数
        /*ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo-io/obj5.ser"));

        Foo2 foo2 = (Foo2) ois.readObject();
        ois.close();

        System.out.println(foo2);*/

        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo-io/obj5.ser"));

        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);

        oos.flush();
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo-io/obj5.ser"));

        Bar2 bar2 = (Bar2) ois.readObject();
        ois.close();

        System.out.println(bar2);
    }
}

/**
 * @Desc 父类实现了序列化接口，那么其子类
 * 都可以进行序列化操作
 * @Author feizi
 * @Date 2017/1/3 16:26
 * @param 
 * @return 
 */
class Foo implements Serializable{
    public Foo(){
        System.out.println("foo...");
    }
}

class Foo1 extends Foo{
    public Foo1() {
        System.out.println("foo1...");
    }
}

class Foo2 extends Foo1{
    public Foo2() {
        System.out.println("foo2...");
    }
}

class Bar{
    public Bar() {
        System.out.println("bar...");
    }
}

/*class Bar1 extends Bar implements Serializable{
    public Bar1() {
        System.out.println("bar1...");
    }
}*/

class Bar1 extends Bar{
    public Bar1() {
        System.out.println("bar1...");
    }
}

class Bar2 extends Bar1 implements Serializable{
    public Bar2() {
        System.out.println("bar2...");
    }
}