package com.leyao.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static void main(String[] args) {
        helper();
    }

    private static void helper() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
