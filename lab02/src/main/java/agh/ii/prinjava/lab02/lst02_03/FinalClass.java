package agh.ii.prinjava.lab02.lst02_03;

/**
 * A class that is declared final cannot be subclassed/changed, we want the class
 * to be as it is without any possibility to change. Because a final class never
 * has any subclasses, the methods of a final class are never overridden.<br>
 * <p>This is useful when creating an immutable class like the String class
 * <br>
 */
final class FinalClass {
    private int x;

    public FinalClass(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
