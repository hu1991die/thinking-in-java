/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/13 9:01
 * @Package_name com.feizi.thread
 */
public class TestPriority {
    public static void main(String[] args) {
        MyThread4 t4 = new MyThread4("t4");
        MyThread5 t5 = new MyThread5("t5");

        t5.setPriority(Thread.NORM_PRIORITY + 3);
        t4.start();
        t5.start();
    }
}

class MyThread4 extends Thread{
    public MyThread4(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println("t4:" + i);
        }
    }
}

class MyThread5 extends Thread{
    public MyThread5(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println("===========t5:" + i);
        }
    }
}
