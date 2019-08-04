package alibaba;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AliTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (char i = 'a'; i < 'd'; i++) {
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
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int j = 1; j < 4; j++) {
                        System.out.println(j);
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
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
