package agh.ii.prinjava.lab02.lst02_05;

/**
 * A <i>nested class</i> (<a href="https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">see</a>)
 * is any class whose declaration occurs within the body of another class or interface declaration.
 * A nested class may be:
 * <ol>
 *     <li>a static member class</li>
 *     <li>an inner class, which may be:</li>
 *     <ul>
 *         <li>a non-static member class (often referred to as <i>inner class</i>)= within the
 *         class and outside of a method</li>
 *         <li>a local class = a static class was created within the method</li>
 *         <li>an anonymous class = class created for implementing an interface
 *              or extending class. The java compiler decides its name</li>
 *     </ul>
 * </ol>
 * <p> A <i>local class</i> - a nested class whose declaration is contained by a block;
 * typically, in the body of a method
 * (<a href="https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html">see</a>)
 * <p> An <i>anonymous class</i> - an inner class with no name
 * (<a href="https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html">see</a>)
 *
 * <p>Note: nested/inner classes introduce strong coupling<br><br>
 *
 * <u>Question 3 : </u>
 * <ul>
 *     <li>An inner class can be used outside of its outerclass. Since it's an element of
 *     the Outer Class, it can be private, public and such. Therefore the inner class
 *     is accessible by others and can be used.</li>
 *     <li>Even in Inner class we have access to the modifiers.</li>
 * </ul>
 */

class OuterClass { // <- Top level class

    private int x; // this is private (!)
    private int y; // as above
    private int z; // as above

    private static int s; // private, static

    /**
     * InnerClass (non-static member class) can be seen as a "member" of OuterClass,
     * hence it has access to the OuterClass private part.
     */
    class InnerClass {
        int x;
        String z;

        void m1IC() {
            System.out.println("InnerClass.m1IC...");

            OuterClass.this.x = 3;
            InnerClass.this.x = 1; // or just this.x = 1;

            y = 10; // y from the OuterClass, i.e. it corresponds to OuterClass.this.y = 10;
            x = 1; // x from the InnerClass, i.e. it corresponds to this.x = 1; or InnerClass.this.x = 1;

            z = "abc"; // or his.z = "abc"; or InnerClass.this.z = "abc";
            OuterClass.this.z = 4;
        }
    }

    /**
     * static member class, we don't need to have an instance of the OuterClass
     */
    static class StaticNestedClass {
        /**
         * OuterClass.this is not accessible here!
         */
        void m1SNC() {
            System.out.println("StaticNestedClass.m1SNC...");
            // OuterClass.this.x = 1; // Error: OuterClass.this cannot be referenced from a static context
            OuterClass.s = 5; // OK, since "s" is static
        }
    }

    /**
     * Note: a variable is considered an <i>effective final</i> if it's not modified
     * after initialization in the local block
     */
    void localClassDemo() {
        final int lv1 = 10; // (explicitly) final local variable
        int lv2 = 20; // effectively final (since Java 8)

        int lv3 = 20; // <- (!)
        lv3 = 30; // <- (!) Not effectively final local variable

        //new LocalClass().m1LC1(); // Error, see (*)
        class LocalClass {
            void m1LC1() {
                System.out.println("lv1 = " + lv1 + ", lv2 = " + lv2);

                //Variable 'lv3' is accessed from within inner class, needs to be final or effectively final
                //System.out.println("lv3 = " + lv3);
            }
        }
        new LocalClass().m1LC1(); // (*) OK, LocalClass is now known
    }

    // A local class is contained by a block, NOT necessarily in the body of a method
    {
        System.out.println("Entering the inner (initialisation) block...");

        // A local class in an inner (initialisation) block
        class LocalClassInABlock {
            void sayHello() {
                System.out.println("Hello from LocalClassInABlock!");
            }
        }
        new LocalClassInABlock().sayHello();

        System.out.println("Leaving the inner (initialisation) block...");
    }

    // { LocalClassInABlock lcinb; /* <- Cannot resolve symbol 'LocalClassInABlock' */ }
}
