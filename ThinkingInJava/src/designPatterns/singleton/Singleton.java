package designPatterns.singleton;

/**
 * 经典单例模式
 * 没有考虑线程安全问题
 */
public class Singleton {
    private static Singleton uniqueSington;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueSington == null) {
            uniqueSington = new Singleton();
        }
        return uniqueSington;
    }
}