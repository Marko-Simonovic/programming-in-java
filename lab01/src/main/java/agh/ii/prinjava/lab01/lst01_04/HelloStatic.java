package agh.ii.prinjava.lab01.lst01_04;

/**
 * <u>Part 2</u>
 * <ul>
 *     <li>A static variable (can be seen in Java as a class variable) is shared by all objects of the class</li>
 *     <li>Static variables are initialized when class is loaded (so <i>only once</i> per class,
 *         before any object of that class is created)</li>
 *     <li>static constants = static final variables; they are quite common
 *         (in contrast to mutable static variables)</li>
 * </ul>
 * <ul>
 *     <li>A common use for static methods is a factory method - a static method that returns new instances of the class
 *         (presented in the next section)</li>
 *     <li>Static methods are methods that do not operate on objects (they do not receive an implicit first argument), i.e.
 *     <ul>
 *         <li>{@code o1.staticMet(arg1, arg2) = C1.staticMet(arg1, arg2)} (possible but considered as bad style!)</li>
 *         <li>{@code o1.instanceMet(arg1, arg2) = C1.staticMet(o1, arg1, arg2)} (conceptually only, does not compile)</li>
 *     </ul>
 *     where C1 is the class in which {@code staticMet} and {@code instanceMet} are defined
 *     </li>
 * </ul>
 * <p>
 *     <b>Question 1</b> : <br>
 *     <ul>
 *         <li><b>static variable</b> acts like a <b>global variable</b>. They are <b>accessible
 *         before the object exists</b></li>
 *         <li><b>static constants</b> help reduce the usage of memory. By using static
 *         Java don't allocate more memory, there <b>will be only one copy of the constant
 *         shared by everyone</b>.</li>
 *         <li><b>static method</b> can only call other static methods and can access static data
 *         only. It cannot be refered with "super" or "this".<b>They belongs more to the class
 *         than an instance itself.</b></li>
 *         <p>  +</p>
 *         <li>static class are used as a nested class (i.e. inside of another class).</li>
 *     </ul>
 * </p>
 */
public class HelloStatic {
    private int instanceVar;
    /**
     * may be initialized this way (or in a constructor, e.g., {@linkplain  #HelloStatic(double)})
     */
    private final double INSTANCE_CONST_1 = 3.141593;
    private final double INSTANCE_CONST_2;

    private static int staticVar;

    /**
     * <b>Question 2</b> : <br>
     * Most static variables are declared public since they must be available to all the users of the class
     */
    public static final double STATIC_CONST = 1.57079; // must be initialised

    /**
     * Implicit {@code this} specified explicitly (<i>extremely untypical</i>, for hacking purposes only!)
     */
    public void instanceMethod1(HelloStatic this) {
        System.out.println("instanceVar = " + this.instanceVar + "instanceVar2 = " + this.INSTANCE_CONST_2);
        System.out.println("staticVar = " + staticVar + "staticConst = " + STATIC_CONST); // access to the static part
    }

    /**
     * Normal instance method
     */
    public void instanceMethod2() {
        System.out.println("instanceVar = " + instanceVar + "instanceVar2 = " + INSTANCE_CONST_2);
    }

    /**
     * No access to the non-static part from the static context
     * <p>
     * <b>Question 3</b> :<br>
     * A static method cannot access a class’s instance variables and instance methods,
     * because a static method can be called even when no objects of the class have been instantiated.
     * For the same reason, the this reference cannot be used in a static method.
     * The this reference must refer to a specific object of the class, and when a static method
     * is called, there might not be any objects of its class in memory
     * </p>
     */
    static void staticMethod(HelloStatic hs) {

        // (1) Non-static field 'instanceVar' cannot be referenced from a static context
        // System.out.println("instanceVar = " + instanceVar);

        // Non-static method 'instanceMethod2()' cannot be referenced from a static context
        // instanceMethod2();

        // But since 'hs' is the method parameter, the following is possible
        System.out.println("hs.instanceVar = " + hs.instanceVar);
        hs.instanceMethod2();
    }

    /**
     * Instance constants can be initialized in the constructor (compare to {@link #INSTANCE_CONST_1})
     */
    public HelloStatic(double instanceConst2) {
        this.INSTANCE_CONST_2 = instanceConst2;

        staticVar++; // OK
        instanceVar = staticVar; // OK
    }
}
