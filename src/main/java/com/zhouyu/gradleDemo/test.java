package com.zhouyu.gradleDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

public class test {
    static volatile int n = 0;
//    static AtomicInteger n = new AtomicInteger(0);
//    static int n = 0;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread t1 = new Thread(() -> {

        });
        t1.start();


        MyContainer myContainer = new MyContainer();
        Thread thread = new Thread(()->{
            try {
                myContainer.put();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                myContainer.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        myContainer.callAll();
    }



}
class MyContainer{

    public synchronized void put() throws InterruptedException {
        this.wait();
        System.out.println("put end");
    }

    public synchronized void get() throws InterruptedException {
        this.wait();
        System.out.println("get end");
    }

    public synchronized void callAll(){
        this.notify(); //一个notify叫醒一个thread
        this.notify();
    }
}
