package synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoThread {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void helper() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
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
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
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
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        helper();
    }
}
