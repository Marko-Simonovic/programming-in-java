package agh.ii.prinjava.lab06.lst01_04;

import java.util.function.Function;

import static java.lang.Math.PI;

@FunctionalInterface
interface Function1<T, R> {
    R apply(T x);

    /**
     * Returns a composed function that first applies the "fst" function to its input, and then applies
     * this function to the result.
     */
    default <V> Function1<V, R> compose(Function1<? super V, ? extends T> fst) {
        return (V x) -> this.apply(fst.apply(x));   // take V in parameter and returns of type R
    }

    /**
     * Returns a composed function that first applies this function to its input, and then applies
     * the "snd" function to the result
     */
    default <V> Function1<T, V> andThen(Function1<? super R, ? extends V> snd) {
        return (T x) -> snd.apply(this.apply(x));
    }
}

/**
 * Auxiliary classes
 */
class A {
}

class B extends A {
}

class C extends B {
}

/**
 * Function composition is an act or mechanism to combine simple functions to build more complicated ones.
 * Like the usual composition of functions in mathematics, the result of each function is passed as the argument
 * of the next, and the result of the last one is the result of the whole.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Function_composition_(computer_science)">Function composition</a>
 */
public class Main {
    private static <T, R, U> Function1<T, R> compose0(Function1<U, R> f1, Function1<T, U> f2) {
        return new Function1<T, R>() {
            @Override
            public R apply(T arg) {
                return f1.apply(f2.apply(arg));
            }
        };
        // or
        // return arg -> f1.apply(f2.apply(arg));
    }

    // PAY ATTENTION TO THE 'COMPOSE' WHICH SPECIFY THE FUNCTION USED AS ARGUMENTS
    private static <T, R, U> Function1<T, R> compose(Function1<U, R> f1, Function1<T, U> f2) { // R just specify Return type
        return arg -> f1.apply(f2.apply(arg)); // the result of each function is passed as the argument.
    }

    /**
     * Explicit use of an anonymous class that implements the functional interface {@link Function1}
     */
    private static void demo1() {
        System.out.println("demo1...");

        System.out.println("f1(x) = x + 1");
        System.out.println("f2(x) = 2x\n");

        Function1<Integer, Integer> f1 = new Function1<Integer, Integer>() {
            @Override // parametric polymorphism, it was previously T argument
            public Integer apply(Integer x) {
                return x + 1;
            }
        };

        Function1<Integer, Integer> f2 = new Function1<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return 2 * x;
            }
        };

        Function1<Integer, Integer> f3 = compose0(f1, f2);
        Function1<Integer, Integer> f4 = compose0(f2, f1);

        // ---- HERE IT WILL PASS x0 AS THE ARGUMENT OF THE FUNCTION
        // WHICH MEANS f1 AND f2 WILL GET x0 AS PARAMETER AS IT IS COMPOSED
        // THEREFORE IT WILL CALL = 2*x0 then (2*x0) + 1 which gives f3
        int x0 = 2;
        System.out.println("(f1 . f2)(" + x0 + ") = f3(" + x0 + ") = " + f3.apply(x0));
        System.out.println("(f2 . f1)(" + x0 + ") = f4(" + x0 + ") = " + f4.apply(x0));
    }

    /**
     * The same as {@link #demo1} but with the use of lambdas (and "var")
     */
    private static void demo2() {
        System.out.println("\ndemo2...");
        Function1<Integer, Integer> f1 = x -> x + 1;
        Function1<Integer, Integer> f2 = x -> 2 * x;

        Function1<Integer, Integer> f3 = compose(f1, f2);
        var f4 = compose(f2, f1);

        int x0 = 2;
        System.out.println("(f1 . f2)(" + x0 + ") = f3(" + x0 + ") = " + f3.apply(x0));
        System.out.println("(f2 . f1)(" + x0 + ") = f4(" + x0 + ") = " + f4.apply(x0));
    }

    /**
     * The same as {@link #demo2} but with the use of {@link Function1#compose}
     */
    private static void demo3() {
        System.out.println("\ndemo3...");
        Function1<Integer, Integer> f1 = x -> x + 1;
        Function1<Integer, Integer> f2 = x -> 2 * x;

        int x0 = 2;
        System.out.println("(f1 . f2)(" + x0 + ") = f3(" + x0 + ") = " + f1.compose(f2).apply(x0));
        System.out.println("(f2 . f1)(" + x0 + ") = f4(" + x0 + ") = " + f2.compose(f1).apply(x0));
    }

    /**
     * The same as {@link #demo3} but with the use of {@link Function1#andThen}
     */
    private static void demo4() {
        System.out.println("\ndemo4...");
        Function1<Integer, Integer> f1 = x -> x + 1;
        Function1<Integer, Integer> f2 = x -> 2 * x;

        // Apply the function at the first element AND THEN apply it to the second with the result of first
        int x0 = 2;
        System.out.println("(f2 andThen f1)(" + x0 + ") = " + f2.andThen(f1).apply(x0));
        System.out.println("(f1 andThen f2)(" + x0 + ") = " + f1.andThen(f2).apply(x0));
    }

    /**
     * The same as {@link #demo3} and {@link #demo4} but with the use of {@link Function}
     */
    private static void demo5() {
        System.out.println("\ndemo5...");
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> f2 = x -> 2 * x;

        int x0 = 2;
        System.out.println("(f1 . f2)(" + x0 + ") = " + f1.compose(f2).apply(x0));
        System.out.println("(f2 . f1)(" + x0 + ") = " + f2.compose(f1).apply(x0));

        System.out.println("\n(f2 andThen f1)(" + x0 + ") = " + f2.andThen(f1).apply(x0));
        System.out.println("(f1 andThen f2)(" + x0 + ") = " + f1.andThen(f2).apply(x0));
    }

    /**
     * Functions are:
     * <ul>
     *     <li>contravariant in their argument types</li>
     *     <li>covariant co-variant in their return types</li>
     * </ul>
     */
    private static void demo6() {
        System.out.println("\ndemo6...");
        //Function<? super B, ? extends B> f01 = (A x) -> new A(); // Bad return type in lambda expression:
        //Function<? super B, ? extends B> f02 = (C x) -> new B(); // Cannot infer functional interface type


        // the ? means any type THAT extends B or is B for example
        // contravariant in their arg type means "opposite in the hierarchy" Circle ----> Shape
        // covariant in the return type means "follow hierarchy" : Shape <--- Circle
        // ||||||||||||||||||||||||||||||||
        // Parameter : B --> OK because B is super of B, but A is also OK because A superior to B
        // Return : B --> OK because B is subclass of B, but C is also OK because C subclass of B
        Function<? super B, ? extends B> f1 = (B x) -> new B();
        //f1.apply(new A()); // required: capture of ? super B, provided: A
        A r1 = f1.apply(new B());
        B r2 = f1.apply(new C());
        //C r3 = f1.apply(new C());


        // Parameter : A --> OK because A is super of B
        // Return : B --> OK because B is subclass of B, but C is also OK because C subclass of B
        Function<? super B, ? extends B> f2 = (A x) -> new B();
        A r4 = f2.apply(new B());
        B r5 = f2.apply(new C());

        // Parameter : B --> OK because B is super of B
        // Return : C --> OK because C is subclass of B
        Function<? super B, ? extends B> f3 = (B x) -> new C();
        A r6 = f3.apply(new B());
        B r7 = f3.apply(new C());

        // Parameter : A --> OK because A is super of B
        // Return : C --> OK because C is subclass of B
        Function<? super B, ? extends B> f4 = (A x) -> new C();
        A r8 = f3.apply(new B());
        B r9 = f3.apply(new C());
    }

    private static void examples() {
        System.out.println("Examples based on exercice 1...");
        // Question 1
        System.out.print("f(x) = 2x and g(x) = x^2 --> f°g = ");

        Function1<Integer, Integer> f1 = x -> 2 * x;
        Function1<Integer, Integer> g1 = y -> y * y;
        int x0 = 2;
        System.out.println(f1.compose(g1).apply(x0));

        // Question 2
        System.out.print("f(x) = sin(x) and g(x) = (1-x)/(1+x^2) --> f°g = ");

        Function1<Integer, Double> f2 = x -> Math.sin(x);   // so we make a division that gives us a double
        Function1<Integer, Integer> g2 = y ->  (1-y) / (1+y*y);
        x0 = -1;
        System.out.println(f2.compose(g2).apply(x0));   //  Warning : (double) != (Double). Similar to (int) and (Integer)

        // Question 3
        System.out.print("f(x) = 1-sin(x)/1+2x^2 and g(x) = cos(x) --> f°g = ");
        Function1<Double, Double> f3 = x -> (1-Math.sin(x)) / (1+2*x*x);
        Function1<Double, Double> g3 = y -> Math.cos(y);    // or Math::cos
        double x1 = PI/2;
        System.out.println(f3.compose(g3).apply(x1));   // cos(pi/2) = 0 --> 1-sin(0) = 0 but that's with radian and not PI
    }
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        examples();
    }
}


