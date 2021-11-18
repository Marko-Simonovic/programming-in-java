package agh.ii.prinjava.lab06.lst01_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

/**
 * <i>Functional interfaces</i> - <b>often representing abstract concepts like functions, actions, or predicates -
 * provide target types for lambda expressions and method references.</b> Each functional interface
 * has a single abstract method, called the <i>functional method</i> for that functional interface, to which <b>the lambda
 * expression's parameter and return types are matched or adapted.</b>
 * Functional interfaces can provide a target type in multiple contexts, such as assignment context, method invocation,
 * or cast context.
 *
 * <p>There are nine basic functional interfaces:
 * <ol>
 *     <li>{@link Consumer} : function that consumes a value without returning any value (printing value, writing, etc)</li>
 *     <li>{@link BiConsumer} : ___ two value ___</li>
 *     <li>{@link Supplier} : function that supplies/return a value of some sorts.</li>
 *     <li>{@link Function} : function (method) that takes a single parameter and returns a single value.
 *                            Only method we have to implement in the interface is the foo() method.</li>
 *     <li>{@link BiFunction} : ___ two value ___</li>
 *     <li>{@link Predicate} : simple function that takes a single value as parameter, and returns true or false.<br>
 *                             For example : Predicate predicate = (value) -> value != null;</li>
 *     <li>{@link BiPredicate} : ___ two value ___</li>
 *     <li>{@link UnaryOperator} : represent an operation that takes a single parameter and returns same type. It can modifies that object, and returns it again</li>
 *     <li>{@link BinaryOperator} : ___ two value ___</li>
 * </ol>
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html">java.util.function</a>
 */
public class Main {
    /**
     * {@link Consumer} represents an operation that accepts a single input argument and returns no result.
     * Unlike most other functional interfaces, Consumer is expected to operate via side effects
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Consumer.html">Consumer</a>
     */
    private static void demo1() {
        System.out.println("demo1...");
        Consumer<String> c1 = s -> System.out.println(s);
        c1.accept("Bonjour"); // -> Bonjour

        // an example related to Java Collection Framework
        List<Integer> l1 = List.of(1, 2, 3, 4, 5);
        l1.forEach(t -> System.out.println(t));
        System.out.println("---");

        l1.forEach(System.out::println); // the same with a method reference
        System.out.println("---");

        //or, more explicitly
        Consumer<Integer> c2 = t -> System.out.println(t); // We could have put the parentheses (t) ->...
        l1.forEach(c2);
    }

    /**
     * {@link BiConsumer} represents an operation that accepts two input arguments and returns no result.
     * This is the two-arity specialization of {@link Consumer}. Unlike most other functional interfaces,
     * BiConsumer is expected to operate via side effects
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BiConsumer.html">BiConsumer</a>
     */
    private static void demo2() {
        System.out.println("\ndemo2...");
        BiConsumer<String, Integer> c1 = (t, u) -> System.out.println(t + " " + u);
        c1.accept("Fahrenheit", 451);

        // An example related to the Java Collection Framework
        Map<ThreeColours, String> title2Actors = Map.of(
                ThreeColours.BLUE, "Juliette Binoche",
                ThreeColours.WHITE, "Zbigniew Zamachowski",
                ThreeColours.RED, "Irene Jacob");

        title2Actors.forEach((t, s) -> System.out.println("The leading actor of " + t + " is " + s));
        System.out.println("---");

        //or, more explicitly
        BiConsumer<ThreeColours, String> c2 = (t, s) -> System.out.println("The leading actor of " + t + " is " + s);
        title2Actors.forEach(c2);
    }

    /**
     * {@link Supplier} represents a supplier of results. There is no requirement that a new or distinct
     * result be returned each time the supplier is invoked.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Supplier.html">Supplier</a>
     */
    private static void demo3() {
        System.out.println("\ndemo3...");
        Supplier<Integer> s1 = () -> 42;
        System.out.println("Supplier s1 always gives: " + s1.get());

        Supplier<Integer> s2 = () -> ThreadLocalRandom.current().nextInt(0, 100);
        System.out.println("The random number form [0,100): " + s2.get());
    }

    /**
     * {@link Function} - represents a function that accepts one argument and produces a result
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Function.html">Function</a>
     */
    private static void demo4() {
        System.out.println("\ndemo4...");
        Function<String, Integer> f1 = s -> s.length();
        String s = "abc";
        System.out.println("The length of " + s + " is " + f1.apply(s));
    }

    /**
     * {@link BiFunction} - represents a function that accepts two arguments and produces a result.
     * This is the two-arity specialization of {@link Function}
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BiFunction.html">BiFunction</a>
     */
    private static void demo5() {
        System.out.println("\ndemo5...");
        BiFunction<Integer, Integer, String> bf = (i1, i2) -> i1 + " " + i2;
        int i1 = 111;
        int i2 = 222;
        System.out.println("The concatenation of " + i1 + " and " + i2 + " gives " + bf.apply(111, 222));
    }

    /**
     * {@link Predicate} - represents a predicate (boolean-valued function) of one argument
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Predicate.html">Predicate</a>
     */
    private static void demo6() {
        System.out.println("\ndemo6...");
        // Example of what it means when developed
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                if (i % 2 == 0) return true;
                else return false;
            }
        };
        Predicate<Integer> isOdd = i -> i % 2 == 1;
        System.out.println("Is 42 even? " + isEven.test(42));
        System.out.println("Is 451 odd? " + isOdd.test(451));
    }

    /**
     * {@link BiPredicate} - represents a predicate (boolean-valued function) of two arguments.
     * This is the two-arity specialization of {@link Predicate}
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BiPredicate.html">BiPredicate</a>
     */
    private static void demo7() {
        System.out.println("\ndemo7...");
        BiPredicate<String, String> bp = (s1, s2) -> s1.length() == s2.length();
        // Developed version !
        BiPredicate<String, String> bp2 = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                if (s.length() == s2.length()) return true;
                else return false;
            }
        };
        System.out.println("Are lengths of abc and efg equal? " + bp.test("abc", "efg"));
    }

    /**
     * {@link UnaryOperator} - represents an operation on a single operand that produces a result of the same typ as
     * its operand. This is a specialization of {@link Function } for the case where the operand and result
     * are of the same type
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/UnaryOperator.html">UnaryOperator</a>
     */
    private static void demo8() {
        System.out.println("\ndemo8...");
        UnaryOperator<Integer> uOp1 = i -> 2 * i;
        Integer v = uOp1.apply(5);
        System.out.println("uOp1(5) = " + v);

        UnaryOperator<String> uOp2 = s -> new StringBuilder(s).reverse().toString();
        String s1 = "TENET";
        System.out.println(s1 + " read backwards: " + uOp2.apply(s1));
    }

    /**
     * {@link BinaryOperator} - represents an operation upon two operands of the same type, producing a result of
     * the same type as the operands. This is a specialization of {@link BiFunction} for the case where the operands
     * and the result are all of the same type.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BinaryOperator.html">BinaryOperator</a>
     */
    private static void demo9() {
        System.out.println("\ndemo9...");
        BinaryOperator<Integer> plus = (a, b) -> a + b;
        System.out.println("5 + 10 = " + plus.apply(5, 10));
    }

    private static void examples() {
        System.out.println("\n\nExamples Exercice 2...");

        // Function example
        Function<Integer, String> foo = (x) -> x.toString();
        Integer a1 = 12;
        System.out.println("--->Function<Integer, String> gives : " + foo.apply(a1));

        // BiFunction example
        BiFunction<Integer, String, Integer> foo2 = (x, y) -> x + Integer.parseInt(y);
        int a2 = 12;
        String b2 = "27";
        System.out.println("--->BI Function<Integer, String, Integer> gives : " + foo2.apply(a2, b2));

        // Consumer & BiConsumer example
        Consumer<String> consumer = (str) -> System.out.println(str);
        List<String> list = List.of("Consumer", "will", "permit", "to print", "any <String> element", "for example");
        System.out.println("--->Consumer<String> gives : ");
        list.forEach(consumer);

        // Supplier example
        Supplier<List<String>> supplier = () -> List.of("List", "of", "Strings");   // we could have not specify <String>
        System.out.print("--->Supplier<List> gives : ");
        // if we used just get() we would have had the List as an element and not its values
        supplier.get().forEach(System.out::print);

        // Predicate example
        Predicate<String> predicate = (str) -> str.equals("Needs to be equal");
        System.out.println("\n--->Predicate<String> gives : " + predicate.test("allo"));
        // OR WORKS BETTER LIKE THIS, NO WARNINGS
        Predicate<String> predicate1 = Predicate.isEqual("Needs to be equal");  // this is the targetReference
        System.out.println("--->Predicate<String> with isEqual gives : " + predicate1.test("allo"));

        // UnaryOperator example
        UnaryOperator<List<Integer>> unaryOperator = listUO -> {
            // WARNING LIST IS AN INTERFACE IT CANNOT BE INSTANTIATED BUT ARRAYLIST CAN
            List<Integer> result = new ArrayList<>();
            listUO.forEach(x -> result.add(x + 5));     // forEach takes a Consumer == no return, only operate on param
            return result;
        };

        System.out.println("--->UnaryOperator<List<Integer>> gives : " + unaryOperator.apply(List.of(1,2,3,4,5)));
        // There are more functional interfaces, but I think I understood how they work.
    }

    /**
     * Since a primitive type can’t be a generic type argument, there are versions of
     * the Function interface for the most used primitive types double, int, long,
     * and their combinations in argument and return types.<br><br>
     * Functional Interface
     * <pre>public interface ArgumentsProcessor<X>
     * {
     *      X process(X arg1, X arg2);
     * }</pre>
     * This interface can be used for any type i.e. <b>ArgumentsProcessor(Integer>,
     * ArgumentsProcessor(String> or ArgumentsProcessor(Employee></b>.
     */
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        demo7();
        demo8();
        demo9();
        examples();
    }
}

enum ThreeColours {BLUE, WHITE, RED}
