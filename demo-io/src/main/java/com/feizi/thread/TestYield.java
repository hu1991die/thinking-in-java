/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/12 17:42
 * @Package_name com.feizi.thread
 */
public class TestYield {
    public static void main(String[] args) {
        MyThread3 a = new MyThread3("A");
        MyThread3 b = new MyThread3("B");

        a.start();
        b.start();
    }
}

class MyThread3 extends Thread{
    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++){
            System.out.println(getName() + ": " + i);
            if(i % 2 == 0){
                yield();
            }
//            System.out.println("==================");
        }
    }
}
