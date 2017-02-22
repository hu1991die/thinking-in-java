/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/13 9:38
 * @Package_name com.feizi.thread
 */
public class TestThread6 {
    public static void main(String[] args) {
        Runner6 r = new Runner6();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 50; i++){
            System.out.println("MainThread: " + i);
        }
    }
}

class Runner6 implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName() + "=======" + Thread.currentThread().isAlive());
        for (int i = 0; i < 50; i++){
            System.out.println("SubThread: " + i);
        }
        System.out.println(Thread.currentThread().getName() + "=======" + Thread.currentThread().isAlive());
    }
}
