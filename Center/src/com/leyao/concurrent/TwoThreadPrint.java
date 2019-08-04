package com.leyao.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThreadPrint {
    public static void main(String[] args) {
        printTwoThread();
    }

    private static void printTwoThread() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
               for (int i = 1; i < 100; i = i + 2) {
                   System.out.println(i);
                   condition1.await();
                   condition2.signal();
               }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 2; i < 101; i = i + 2) {
                    System.out.println(i);
                    condition1.signal();
                    condition2.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
