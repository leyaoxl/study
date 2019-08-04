package designPatterns.singleton;

/**
 * 静态变量初始化单例模式
 * 在静态初始化中创建单例，保证了线程安全性
 * JVM可以保证任何线程访问uniqueSingleton之前，一定会先创建此实例
 */
class FastSingleton {
    private static FastSingleton uniqueSingleton = new FastSingleton();

    private FastSingleton() {

    }
}