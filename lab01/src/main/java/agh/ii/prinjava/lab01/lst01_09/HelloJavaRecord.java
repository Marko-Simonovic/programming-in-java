package agh.ii.prinjava.lab01.lst01_09;

/**
 * A Java Record is a special kind of Java class which has a concise syntax for defining immutable
 * data-only classes. HelloJavaRecord corresponds to {@link HelloImmutable}
 *
 * <p>A record declaration specifies in a header a description of its contents.
 * The following class members are created automatically:
 * <ul>
 *     <li>the appropriate accessors
 *         (note a different naming convention not {@code  getVal()} but {@code val()})</li>
 *     <li>constructor</li>
 *     <li>equals method</li>
 *     <li>hashCode method</li>
 *     <li>toString method</li>
 * </ul>
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/16/language/records.html">Record Classes</a>
 * <br><br>
 * Note : Java Record is a useful class to <b>hold information/data</b><br>
 * <p>
 * <b>Question 4 : </b><br>
 * We generally use Java Record when we want to automatically have a <b>Equals</b> method or
 * a <b>toString</b> method, they are ofc some others methods available.
 * </p>
 *
 */
public record HelloJavaRecord(int i1, String s1) {
    public static void sm1() {
        System.out.println("HelloImmutable.sm1()");
    }
}
// To resume Java Record class is a short and simple way to write a class with all
// final attribute and getters/equals/etc...