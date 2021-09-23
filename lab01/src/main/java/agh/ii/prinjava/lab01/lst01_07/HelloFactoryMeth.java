package agh.ii.prinjava.lab01.lst01_07;

/**
 * A factory method - a static method that returns new instances of the class
 *
 * <b>Note: this is just a simple example of a factory method.
 * More general solution (factory method pattern) in the next section (about interfaces)
 * <p> Factory methods, among other things, can:
 * <ul>
 *     <li>return an object of a subclass</li>
 *     <li>return a shared object, instead of unnecessarily constructing new ones</li>
 * </ul>
 * </p>
 * <p>
 *     <u>Question 3 :</u><br><br>
 *     If we compare constructors and factory methods we could say that :
 *     <ul>
 *         <li>Constructors don't have meaningful names since they are
 *         restricted to the standard name (the name of the class) while factory methods can.</li>
 *         <li>Static factory methods have a bigger range of returning types : they are not limited</li>
 *         <li>Static factory methods can control more efficiently the numbers of instance since
 *         it mix well with the <b>Singleton pattern</b></li>
 *         <li>If we want that all the instance get a default value for a field we can use
 *         a factory method. Otherwise it will make the code more rigid because we would have
 *         to also refractor the constructor so it adapts to the default value chosen.<br><br>
 *         For example :<br><br>
 *         public static User createWithDefaultCountry(String name, String email) {<br>
 *             return new User(name, email, "Argentina");
 *         }<br><br>
 *         With this example we will have a single method share by everyone that will create
 *         an 'User' instance with a default country field, here 'Argentina'.<br><br>
 *         User user = User.createWithDefaultCountry("John", "john@domain.com");</li>
 *     </ul>
 * </p>
 */
public class HelloFactoryMeth {
    private int x;

    /**
     * all constructors are private
     */
    private HelloFactoryMeth() {
        this(1);
    }

    private HelloFactoryMeth(int x) {
        this.x = x;
        System.out.println("HelloFactoryMethod(int) private constructor working...");
    }

    static HelloFactoryMeth create(int x) {
        System.out.println("HelloFactoryMethod.create(int) method working...");
        return new HelloFactoryMeth(x);
    }

    /**
     * Another (overloaded name) factory method
     */
    static HelloFactoryMeth create(String s) {
        System.out.println("HelloFactoryMethod.create(String) method working...");
        return new HelloFactoryMeth(s.length());
    }

    /**
     * Yet another factory method, this time with a different name
     */
    static HelloFactoryMeth buildFrom(HelloFactoryMeth s) {
        System.out.println("HelloFactoryMethod.buildFrom(HelloFactoryMeth) method working...");
        return new HelloFactoryMeth(s.x);
    }
}
