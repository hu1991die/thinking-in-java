/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc
 * @Author feizi
 * @Date 2017/2/13 9:19
 * @Package_name com.feizi.thread
 */
public class TestThread4 {
    public static void main(String[] args) {
        Runner4 r = new Runner4();
        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 100; i++){
            System.out.println("in thread main i =" + i);
        }
        System.out.println("Thread main is over.");
        r.shutDown();
    }
}

class Runner4 implements Runnable{
    private boolean flag = true;

    public void run() {
        int i = 0;
        while (flag == true){
            System.out.println(" " + i++);
        }
    }

    public void shutDown(){
        flag = false;
    }
}
