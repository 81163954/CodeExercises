package com.zhouyu.gradleDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class test {
    static volatile int n = 0;
//    static AtomicInteger n = new AtomicInteger(0);
//    static int n = 0;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread t1 = new Thread(() -> {

            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            LockSupport.park();

            System.out.println("t1 stop");
        });
        t1.start();
        LockSupport.unpark(t1);


        CountDownLatch countDownLatch = new CountDownLatch(2);


    }
}
