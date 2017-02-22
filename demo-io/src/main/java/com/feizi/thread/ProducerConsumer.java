/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.thread;

/**
 * @Desc 生产者消费者问题
 * wait和sleep的最大区别在于：
 * wait的时候，先前持有的那把锁不再归当前线程所有，已经交出去了，其他线程
 * 此时仍然可以拿到这把锁，而当前线程只有当再次唤醒的时候才去继续寻找那把锁
 * 而sleep的时候，休眠的时候仍然抱有那把锁，其他对象在此休眠期间无法持有
 * 该锁，只有等待当前线程释放锁之后才能获取
 * notify方法的作用：唤醒一个现在正在wait状态的线程
 * notifyAll方法的作用：唤醒其他所有正在wait等待状态的线程
 * @Author feizi
 * @Date 2017/2/15 9:28
 * @Package_name com.feizi.thread
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        //创建一个篮子
        SyncStack syncStack = new SyncStack();
        Producer producer = new Producer(syncStack);
        Consumer consumer = new Consumer(syncStack);

        for (int i = 0; i < 5; i++){
            // 多个生产者和多个消费者
            new Thread(producer).start();
            new Thread(consumer).start();
        }
    }
}

/**
 * @Desc 馒头类
 * @Author feizi
 * @Date 2017/2/15 9:34
 * @param
 * @return
 */
class WoTou {
    int id;
    WoTou(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoTou: " + id;
    }
}

/**
 * @Desc 装馒头的篮子
 * @Author feizi
 * @Date 2017/2/15 9:47
 * @param
 * @return
 */
class SyncStack{
    // 第几个馒头
    int index = 0;
    // 篮子默认装6个馒头
    WoTou[] arrWt = new WoTou[6];

    public synchronized void push(WoTou wt) {
        while (index == arrWt.length){
            //线程控制的另外一种方法,锁定在当前对象上的线程停止住
            // 拿到对象锁的这个线程在执行的过程之中，遇到一个事件不得不阻塞住,
            // 这个对象必须是加锁的，加了synchronized关键字
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //生产满了之后，叫醒消费者去消费（生产特别快的时候）
        this.notifyAll();
        arrWt[index] = wt;
        index++;
    }

    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //消费完了，叫醒生产者继续生产(消费特别快的时候)
        this.notifyAll();
        index--;
        return arrWt[index];
    }
}

/**
 * @Desc 生产者
 * @Author feizi
 * @Date 2017/2/15 9:46
 * @param
 * @return
 */
class Producer implements Runnable{
    SyncStack syncStack = null;

    public Producer(SyncStack syncStack) {
        this.syncStack = syncStack;
    }

    public void run() {
        //每个人最多生成20个馒头
        for (int i = 0; i < 20; i++){
            WoTou wt = new WoTou(i);
            syncStack.push(wt);

            System.out.println("生产了: " + wt);

            try {
                // 每生产一个，休眠一小会儿,这样的话可以让其他线程有执行的机会
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * @Desc 消费者
 * @Author feizi
 * @Date 2017/2/15 9:50
 * @param
 * @return
 */
class Consumer implements Runnable{
    SyncStack syncStack = null;

    public Consumer(SyncStack syncStack) {
        this.syncStack = syncStack;
    }

    public void run() {
        //每个人最大消费20个馒头
        for (int i = 0; i < 20; i++){
            WoTou wt = syncStack.pop();

            System.out.println("=====消费了：" + wt);

            try {
                // 每消费一个，休眠一小会儿
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}