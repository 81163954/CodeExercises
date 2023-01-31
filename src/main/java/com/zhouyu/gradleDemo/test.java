package com.zhouyu.gradleDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    public static void main(String[] args) {
        TimeUnit seconds = TimeUnit.SECONDS;
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
