package agh.ii.prinjava.lab02.lst02_10;

/**
 * <b>A functional interface (aka. <i>Single Abstract Method</i> interface) is an interface
 * that has exactly ONE abstract method (aside from the methods of Object),
 * and thus represents a single function contract.</b>
 */
@FunctionalInterface
interface I1 {
    void m1(); // exactly one abstract method => this is an abstract interface
}
