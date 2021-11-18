package agh.ii.prinjava.lab05.lst05_02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Main {

    /** Using iterators<br><br>
     * <b>It means that we create an object Iterator which will serve as an index.</b>
     * This object has two methods : hasNext() and Next()
     * <ul>
     *     <li><b>hasNext() :</b> checks if index < end and returns true or false</li>
     *     <li><b>next() :</b> gets the next element so we overwrite previous value</li>
     * </ul>
     */
    private static void demo1() {
        int itArrSize = 5;
        IterableArray<Integer> itArr = new IterableArray<>(itArrSize);
        for (int i = 0; i < itArrSize; i++) {
            itArr.set(i, 10 * i);
        }

        System.out.println(itArr);

        // (1) Iterator with the while loop
        var it1 = itArr.iterator();
        while (it1.hasNext()) {
            int e = it1.next();
            System.out.print(e + " ");
        }
        System.out.println("\n---");

        // (2) Iterator with the for loop
        for (var it = itArr.iterator(); it.hasNext(); ) {
            int e = it.next();
            System.out.print(e + " ");
        }
        System.out.println("\n---");

        // (3) Enhanced for-loop
        for (var e : itArr) {
            System.out.print(e + " ");
        }
        System.out.println("\n---");

        // (4) forEach method
        itArr.forEach(e -> System.out.print(e + " "));
    }

    public static void main(String[] args) {
        demo1();
    }
}
