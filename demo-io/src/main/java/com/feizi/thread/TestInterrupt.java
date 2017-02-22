/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;


import java.util.Date;

/**
 * @Desc 测试线程中断
 * @Author feizi
 * @Date 2017/2/12 13:36
 * @Package_name com.feizi.thread
 */
public class TestInterrupt {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("===" + new Date() + "====");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
