package agh.ii.prinjava.lab01.lst01_09;

import java.util.Objects;

/**
 * An example of a simple immutable class -- its instances cannot be "mutated"
 * Note: more about keyword {@code final} next time
 * <u>PART 4</u><br><br>
 * <b>Question 1 :</b>
 * <br>
 * <p>
 *     They are some rules that we need to follow in order to be sure we want create a correct
 *     immutable object.
 *     <ol>
 *         <li>We need first to make all the fields <b>private</b> and <b>final</b> so
 *         we are sure they won't be able to change.</li>
 *         <li>We <b>don't provide setter</b> because they aren't necessary, nothing will change.</li>
 *         <li>We make sure we don't override method (we can use final to do it).</li>
 *         <li>If we have references to mutable objects we need to make sure we don't provide methods
 *         to change them and that we don't share the references</li>
 *     </ol>
 * </p>
 */
final public class HelloImmutable { // <- this "final" makes the class closed for extension
    final private int i1; // <- this "final" makes this field a constant
    final private String s1; // as above

    public HelloImmutable(int i1, String s1) {
        this.i1 = i1;
        this.s1 = s1;
    }

    /**
     * Only accessors (getters), no mutators (setters)
     */
    public int getI1() {
        return i1;
    }

    public String getS1() {
        return s1;
    }

    /**
     * <b>Question 3 :</b><br>
     * Immutable objects have some advantages that can come really handy :
     * <ul>
     *     <li>It's a protection against null references error</li>
     *     <li>It provides Thread safety</li>
     *     <li>Absence of hidden side-effects since we can't change the content</li>
     *     <li>Gives a protection from inadvertent corruption of existing objects</li>
     * </ul>
     */
    @Override
    public String toString() {
        return "HelloImmutable{" +
                "i1=" + i1 +
                ", s1='" + s1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelloImmutable that = (HelloImmutable) o;
        return i1 == that.i1 && Objects.equals(s1, that.s1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, s1);
    }

    public static void sm1() {
        System.out.println("HelloImmutable.sm1()");
    }
}
