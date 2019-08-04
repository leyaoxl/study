package chapter21;

public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        // start将执行Runnable中的run方法，并且与main不是同一线程，main先执行完，所以先展示
        t.start();
        System.out.println("Waiting for LiftOff!");
    }
}
