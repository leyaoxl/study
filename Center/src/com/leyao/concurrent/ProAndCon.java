package com.leyao.concurrent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 条件队列实现生产消费者模型
 * 可以实现多生产者多消费者
 * wait、notify
 */
class Production {
    private static final int MAX_SIZE = 10;
    private volatile static int num = 1;

    private Queue<Integer> storage = new LinkedList<>();

    public synchronized void product() {
        if (storage.size() == MAX_SIZE) {
            try {
                wait();
                return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + "生产了" + num);
        storage.add(num++);
        notify();
    }

    public synchronized void consume() {
        if (storage.size() == 0) {
            try {
                wait();
                return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int i = storage.poll();
        System.out.println(Thread.currentThread().getName() + "消费了" + i);
        notify();
    }
}

class Producer implements Runnable {
    private Production production;
    public Producer(Production production) {
        this.production = production;
    }

    @Override
    public void run() {
        while (true) {
            try {
                production.product();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private Production production;
    public Consumer(Production production) {
        this.production = production;
    }

    @Override
    public void run() {
        while (true) {
            try {
                production.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ProAndCon {
    public static void main(String[] args) {
        Production production = new Production();

        Producer producer1 = new Producer(production);
        Producer producer2 = new Producer(production);
        Producer producer3 = new Producer(production);

        Consumer consumer = new Consumer(production);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(consumer).start();
    }
}