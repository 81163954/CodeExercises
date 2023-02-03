package com.zhouyu.gradleDemo.juc;

import java.util.LinkedList;

/**
 * Use Synchronized to implement
 * Improvement: 生产者消费者线程都会在一个阻塞队列中，假如容器满了，
 * 此时拿到锁的生产者t1会叫醒别的，假如又叫醒了一个生产者t2，t2刚开
 * 始执行又会wait，会产生无用的开销
 * @param <T>
 */
public class SynchronizedContainer<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count;

    public synchronized void put(T o){
        while(list.size() == MAX){//这里不能使用if，因为多个生产者线程可能同时在这个wait() 排队等待，会同时被唤醒
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        list.add(o);
        count++;
        this.notifyAll();
    }
    public synchronized T get(T o){
        while(list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        T t = list.removeFirst();
        count--;
        this.notifyAll();

        return t;
    }

    /**
     * 这个方法也要sync，因为外部的线程使用该同步容器，需要调getCount进行判断
     * @return
     */
    public int getCount(){
        return count;
    }

}
