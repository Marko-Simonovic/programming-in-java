package agh.ii.prinjava.lab01.lst01_09;

/**
 * Consider: immutable objects vs. immutable classes
 *
 * <p>An immutable object is an object whose internal state remains constant
 * after it has been entirely created.
 *
 * <p>Note: immutable data/objects can be shared without risk (such objects are thread safe)!
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html">
 * A Strategy for Defining Immutable Objects</a>
 * <p>
 *     <b>Question 2 :</b><br>
 *     Having an immutable class means that all fields are private, unmodifiable but also that we don't
 *     have getters that returns a mutable object.<br>
 *     Immutable objects are object whose content can't be changed once created.<br>
 *     It is impossible to have an immutable class that contains an immutable object because by
 *     reference we can access to it, change it's value in the class of the object and thus breaking
 *     the rules of an immutable class.
 * </p>
 */

public class Main {

    /**
     * An immutable class/object demo
     */
    private static void demo1() {
        // hi is immutable/read-only
        HelloImmutable hi = new HelloImmutable(1, "abc");
        System.out.println("hi = " + hi); // toString called implicitly
        HelloImmutable.sm1();

        System.out.println("hi.i1 = " + hi.getI1() + ", hi.s1 = " + hi.getS1());
    }

    /**
     * Java Record demo
     */
    private static void demo2() {
        HelloJavaRecord hjr = new HelloJavaRecord(1, "abc");
        System.out.println("hjr = " + hjr); // toString called implicitly
        HelloJavaRecord.sm1();

        // Note the naming convention used by the code generator (no "get" prefix!)
        System.out.println("hjr.i1 = " + hjr.i1() + ", hi.s1 = " + hjr.s1());
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}
