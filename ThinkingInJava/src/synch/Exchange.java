package synch;

import java.util.concurrent.Exchanger;

public class Exchange {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = exchanger.exchange(123);
                    System.out.println("线程1：" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = exchanger.exchange(456);
                    System.out.println("线程2：" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
