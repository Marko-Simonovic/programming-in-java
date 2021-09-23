package agh.ii.prinjava.lab01.lst01_08;

/**
 * Implementation characteristics:
 * <ul>
 *     <li>Thread-safe</li>
 *     <li>Lazy instantiation</li>
 * </ul>
 * <p>
 *     Similar to the 'EagerSingleton' here the 'LazySingleton' <b>set the instance to null</b>.
 *     Therefore if the object is not mean to be used at the end, we won't end up creating it.
 *     Otherwise it works the same with the difference in the <b>'getMethod' which verify if an instance
 *     already exists</b>, if not it creates it.
 * </p>
 */
public final class LazySingleton {

    private static volatile LazySingleton instance = null; // volatile means multi-thread can use it at the same time

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            // Only one thread can use a synchronized block at a time.
            // It prevents accident if two threads create an instance at the same time.
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
