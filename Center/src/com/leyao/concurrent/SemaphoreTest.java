package com.leyao.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        helper();
    }

    private static void helper() {
        Semaphore semaphore = new Semaphore(10);
        int i = 0;
        while (i < 100) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取许可");
                    Thread.sleep(1000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放许可");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            i++;
        }
    }
}
