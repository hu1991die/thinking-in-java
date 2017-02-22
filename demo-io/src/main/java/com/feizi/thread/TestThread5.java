/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/13 9:30
 * @Package_name com.feizi.thread
 */
public class TestThread5 {
    public static void main(String[] args) {
        Runner5 r = new Runner5();
        Thread t = new Thread(r);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 50; i++){
            System.out.println("主线程：" + i);
        }
    }
}

class Runner5 implements Runnable{

    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("SubThread: " + i);
        }
    }
}
