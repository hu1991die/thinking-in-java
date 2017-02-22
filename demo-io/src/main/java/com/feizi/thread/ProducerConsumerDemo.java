/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;


/**
 * @Desc 生产者和消费者经典问题
 * @Author feizi
 * @Date 2017/2/17 14:58
 * @Package_name com.feizi.thread
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BoxStack bs = new BoxStack();

        Producer1 p = new Producer1(bs);
        Consumer1 c = new Consumer1(bs);

        new Thread(p).start();
        new Thread(c).start();
    }
}

/**
 * @Desc 馒头类
 * @Author feizi
 * @Date 2017/2/17 14:59
 * @param
 * @return
 */
class ManTou{
    int id;

    public ManTou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ManTou: " + id;
    }
}

/**
 * @Desc 馒头箱子
 * @Author feizi
 * @Date 2017/2/17 15:00
 * @param
 * @return
 */
class BoxStack{
    int index = 0;
    ManTou[] mtArr = new ManTou[6];

    public synchronized void push(ManTou mt){
        while (index == mtArr.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();
        mtArr[index] = mt;
        index++;
    }

    public synchronized ManTou pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return mtArr[index];
    }
}

/**
 * @Desc 生产者
 * @Author feizi
 * @Date 2017/2/17 15:46
 * @param
 * @return
 */
class Producer1 implements Runnable{

    BoxStack bs = null;

    public Producer1(BoxStack bs) {
        this.bs = bs;
    }

    public void run() {
        ManTou mt = null;
        for (int i = 0; i < 20; i++){
            mt = new ManTou(i);
            bs.push(mt);

            System.out.println("生产了：" + mt);

            try {
                //每生产一个馒头，休息一会儿
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * @Desc 消费者
 * @Author feizi
 * @Date 2017/2/17 15:46
 * @param
 * @return
 */
class Consumer1 implements Runnable{
    BoxStack bs = null;

    public Consumer1(BoxStack bs) {
        this.bs = bs;
    }

    public void run() {
        ManTou mt = null;
        for (int i = 0; i < 20; i++){
            mt = bs.pop();
            System.out.println("消费了：" + mt);

            try {
                //每消费一个馒头，休息一会儿
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


