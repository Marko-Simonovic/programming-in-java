package agh.ii.prinjava.lab04.lst04_03;

/**
 * Generic class with a generic method
 * A raw type is the name of a generic class or interface without any type arguments. It's when we don't specify the type like List()
 */
class C3<T> { // This "T"...
    private T x;

    <T> T sm1(T x) { // <- ... has nothing to do with this "T"
        return x;
    }
}
