package com.leyao.concurrent;

import java.util.concurrent.Exchanger;

public class Exchange {
    public static void main(String[] args) {
        helper();
    }

    private static void helper() {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + 123);
                int num = exchanger.exchange(123);
                System.out.println(Thread.currentThread().getName() + " : " + num);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + 456);
                int num = exchanger.exchange(456);
                System.out.println(Thread.currentThread().getName() + " : " + num);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
