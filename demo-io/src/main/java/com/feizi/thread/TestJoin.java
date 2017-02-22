/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/12 13:57
 * @Package_name com.feizi.thread
 */
public class TestJoin {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2("thread2");
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 10; i++){
            System.out.println("i am main thread");
        }
    }
}

class MyThread2 extends Thread{
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println("i am" + getName());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
