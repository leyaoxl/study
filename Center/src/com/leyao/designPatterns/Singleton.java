package com.leyao.designPatterns;

/**
 * 懒汉式-线程不安全
 */
class Singleton1 {
    private static Singleton1 uniqueSingleton;
    private Singleton1() {}
    public static Singleton1 getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton1();
        }
        return uniqueSingleton;
    }
}

/**
 * 饿汉式-线程安全
 */
class Singleton2 {
    private static Singleton2 uniqueSingleton = new Singleton2();
    private Singleton2() {}
    public static Singleton2 getInstance() {
        return uniqueSingleton;
    }
}

/**
 * 懒汉式-线程安全
 */
class Singleton3 {
    private static Singleton3 uniqueSingleton;
    private Singleton3() {}
    public synchronized static Singleton3 getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton3();
        }
        return uniqueSingleton;
    }
}

/**
 * 双重检查
 */
class Singleton4 {
    private volatile static Singleton4 uniqueSingleton;
    private Singleton4() {}
    public static Singleton4 getInstance() {
        if (uniqueSingleton == null) {
            synchronized (Singleton4.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new Singleton4();
                }
            }
        }
        return uniqueSingleton;
    }
}

/**
 * 私有静态内部类
 */
class Singleton5 {
    private Singleton5() {}
    private static class SingletonFactory {
        private static Singleton5 uniqueSingleton = new Singleton5();
    }
    public static Singleton5 getInstance() {
        return SingletonFactory.uniqueSingleton;
    }
}

public class Singleton {
    public static void main(String[] args) {

    }
}
