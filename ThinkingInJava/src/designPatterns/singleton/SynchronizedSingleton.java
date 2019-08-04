package designPatterns.singleton;

/**
 * 内置锁单例模式
 * 直接加锁，但是只有在第一次执行此方法时才需要同步，后面直接获取不需要同步，同步会很累赘
 */
class SynchronizedSingleton {
    private static SynchronizedSingleton uniqueSingleton;

    private SynchronizedSingleton() {}

    public synchronized static SynchronizedSingleton getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new SynchronizedSingleton();
        }
        return uniqueSingleton;
    }
}
