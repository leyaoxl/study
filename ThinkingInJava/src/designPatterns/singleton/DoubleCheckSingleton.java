package designPatterns.singleton;

/**
 * 双重检查加锁单例模式
 */
class DoubleCheckSingleton {
    private static DoubleCheckSingleton uniqueSingleton;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (uniqueSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return uniqueSingleton;
    }
}

