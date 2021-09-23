package agh.ii.prinjava.lab01.lst01_08;

/**
 * Implementation characteristics:
 * <ul>
 *     <li>Thread-safe</li>
 *     <li>Eager instantiation</li>
 * </ul>
 * <p>Here <b>EagerSingleton exists before an instance is created.</b><br>
 * Since it's a private static final method, it will <b>not be accessible from outside</b>,
 * will be <b>called at the beginning</b> and will be <b>unmutable</b>.<br>
 * In other words, it creates a single instance at the very beginning and that's it.<br><br>
 * <b>The main problem is that it creates an instance when launching the application
 * while it may not be used at all.</b></p>
 */
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
