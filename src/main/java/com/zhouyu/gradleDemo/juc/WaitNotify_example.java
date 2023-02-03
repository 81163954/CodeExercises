package com.zhouyu.gradleDemo.juc;

public class WaitNotify_example {
    final static Object o = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o){
                for (int i = 0; i < 26; i++) {
                    o.notify();
                    System.out.println((char)(i+65));
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o){
                for (int i = 1; i <= 26; i++) {
                    o.notify();
                    System.out.println(i);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
