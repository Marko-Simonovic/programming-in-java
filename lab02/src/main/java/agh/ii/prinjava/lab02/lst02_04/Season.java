package agh.ii.prinjava.lab02.lst02_04;

/**
 * An enum class is a class declared with abbreviated syntax that defines a small set of named class instances.
 * <p>A classic example of an enumerated type that defines a list of enumerated values corresponding
 * to the seasons of the year.<br><br>
 *
 * <u>Question 1 :</u><br>
 * Enum are enumerated ordered listing of items in a collection. It's a grouping of constants
 * that behave similarly to objects.<br><br>
 * <b>It is a compile-time error if an enum declaration has the modifier abstract or final.</b><br>
 * An enum class is implicitly final unless its declaration contains at least one enum
 * <b>constant that has a class body.</b><br>
 * A nested enum class is implicitly static.<br>
 * <b>An enum class has no instances other than those defined by its enum constants.
 * It is a compile-time error to attempt to explicitly instantiate an enum class</b><br><br>
 *
 * <u>Question 3 :</u><br>
 * The INSTANCE keyword represents a public static final fields of enum class,
 * and like all static fields they can be accessed by class name like "Season s1 = Season.INSTANCE"
 * An enum is already private final and static, the only thing that has global access is
 * its value but it's okay since it's a primitive type, we can change the value.<br>
 * Plus, the Enum instance is thread-safe.
 */
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
