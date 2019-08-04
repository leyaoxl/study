package com.leyao.concurrent;

import java.util.concurrent.CountDownLatch;

public class Latch {
    public static void main(String[] args) {
        helper();
    }

    private static void helper() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}