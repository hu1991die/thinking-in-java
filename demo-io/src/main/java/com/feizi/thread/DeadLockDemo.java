/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc 死锁，多个线程之间互相持有对方的锁
 * @Author feizi
 * @Date 2017/2/17 14:33
 * @Package_name com.feizi.thread
 */
public class DeadLockDemo implements Runnable{
    private boolean flag = false;
    private static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo mt1 = new DeadLockDemo();
        DeadLockDemo mt2 = new DeadLockDemo();
        mt1.flag = true;
        mt2.flag = false;

        new Thread(mt1).start();
        new Thread(mt2).start();
    }

    public void run() {
        System.out.println("flag: " + flag);
        if (flag){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("=======true======");
                }
            }
        }else if(!flag){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("========false=========");
                }
            }
        }
    }
}

