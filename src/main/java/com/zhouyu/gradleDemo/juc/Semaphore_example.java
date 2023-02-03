package com.zhouyu.gradleDemo.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

//question: when t1.size=5,t2 need run
public class Semaphore_example {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new LinkedList<>();
        Semaphore semaphore = new Semaphore(1,true);

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");

            semaphoreAcquire(semaphore);

            semaphore.release();
            System.out.println("t2 end");
        }, "t2");
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            semaphoreAcquire(semaphore);

            t2.start();

            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("t1 add "+ i );
                if(list.size()==5){
                    try {
//                        semaphore.wait();
                        semaphore.release();
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("t1 end");
        }, "t1");


        t1.start();
    }

    static void semaphoreAcquire(Semaphore semaphore){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
