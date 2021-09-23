package agh.ii.prinjava.lab01.lst01_04;

/**
 * Use
 * <ul>
 *     <li>{@code ClassName.methodName(arguments)} to invoke a static method</li>
 *     <li>{@code ClassName.staticVariable} to access a static variable (or constant)</li>
 * </ul>
 *  This improves readability because this makes static methods and data easy to spot
 */
public class Main {
    /**
     * <b>Question 4 :</b><br>
     * A simple example of a static method is the 'Main' method.
     * The reason the main method is static is because you don't need an object to call it.
     * If the main method were not static, then you would have needed an object to call the main method.
     * Yes, the main method may access non-static variables, but only indirectly through actual instances.
     * <br><br>
     * <b>WARNING</b>
     * We often say "non-static variables cannot be used in a static method" while in fact we mean that
     * non-static members of the same class can't be directly accessed.<br>
     * <p>
     *     public class A{<br>
     *        int a = 10;<br>
     *        public static void main (String[] args){<br>
     *          System.out.print(a); // <b>WON'T COMPILE</b><br>
     *        }<br>
     *     }<br>
     * <b>BUT IF WE INSTANTIATE A, we will be able to access the variable A.a because
     * we are sure the object exists before calling the method.</b>
     * </p>
     */
    public static void main(String[] args) {
        HelloStatic hsInst = new HelloStatic(1.54);

        System.out.println("HelloStatic.staticConst = " + HelloStatic.STATIC_CONST); // OK
        HelloStatic.staticMethod(hsInst); // OK

        // Bad style - static member 'HelloStatic.staticMethod(HelloStatic)' accessed via instance reference
        // hsInst.staticMethod(hsInst);

        // Note that 'void instanceMethod1(HelloStatic this)'; this is passed implicitly as always for instance methods
        hsInst.instanceMethod1();
        hsInst.instanceMethod2();

        // hsInst.instanceMethod1(hsInst);
    }
}
