package com.leyao.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {
    public static void main(String[] args) {
        helper();
    }

    private static void helper() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    blockingQueue.put(i);
                    System.out.println("生产者生产了：" + i);
                    Thread.sleep(1000);
                    i++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    int i = blockingQueue.take();
                    System.out.println("消费者消费了：" + i);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
