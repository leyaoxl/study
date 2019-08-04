package synch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {
    public static void main(String[] args) {
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (i < 100) {
                    try {
                        System.out.print("生产者生产了： " + i);
                        System.out.println();
                        i++;
                        blockingQueue.put(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("消费者消费了： " + blockingQueue.take());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        producer.start();
        customer.start();
    }
}