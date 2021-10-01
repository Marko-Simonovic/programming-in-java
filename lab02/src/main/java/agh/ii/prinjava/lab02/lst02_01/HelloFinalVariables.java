package agh.ii.prinjava.lab02.lst02_01;

/**
 * The word "final" is a Java keyword for declaring a constant
 * <ul>
 *     <li>A final local variable - a constant declared inside a method</li>
 *     <li>A final instance variable - a constant declared inside a class
 *         (must be initialized by the end of every constructor)</li>
 *     <li>A final class variable - a constant declared as static inside a class</li>
 * </ul>
 * <p>
 *     A variable can be declared final. A final variable may only be assigned to
 *     once. It is a compile-time error if a final variable is assigned to unless
 *     it is definitely unassigned immediately prior to the assignment
 * </p>
 * <p>
 *     Once a final variable has been assigned, it always contains the same value.
 *     If a final variable holds a reference to an object, then the state of the
 *     object may be changed by operations on the object, but the variable will
 *     always refer to the same object. This applies also to arrays, because arrays
 *     are objects; <b>if a final variable holds a reference to an array,
 *     then the components of the array may be changed by operations on the array,
 *     but the variable will always refer to the same array.</b>
 * </p>
 */
class HelloFinalVariables {
    private final int x = 1; // A final instance variable
    public final static double PI_2 = 1.570796; // A final static/class variable, unique reference shared

    public static void m1() {
        final int fv1 = 1; // <- a final local variable (=only exist in the method), initialized at the time of declaration
        final int fv2; // <- a final local variable, no initialisation, only declaration

        System.out.println("Inside m1()...");
        int v1 = 100;
        fv2 = 42; // <- fv2 is final
        System.out.printf("Inside m1(), fv1 = %d, fv2 = %d\n", fv1, fv2);

        v1++; // OK, v1 is not final
        // fv1++; // fv1 cannot be modified because it is final
        // fv2++; // as above
    }
}
