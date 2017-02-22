/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/14 15:36
 * @Package_name com.feizi.thread
 */
public class Interview implements Runnable{
    int b = 100;

    public synchronized void m1() throws Exception {
        b = 1000;
        Thread.sleep(5000);
        System.out.println("b = " + b);
    }

    public synchronized void m2() throws Exception{
        Thread.sleep(3000);
        b = 2000;
    }

    public synchronized void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Interview it = new Interview();
        Thread t = new Thread(it);
        t.start();

        it.m2();
        System.out.println(it.b);
    }
}
