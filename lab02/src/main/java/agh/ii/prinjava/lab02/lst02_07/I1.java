package agh.ii.prinjava.lab02.lst02_07;

/**
 * <ul>
 *     <li>Modifier 'abstract' is redundant for interfaces</li>
 *     <li>Modifier 'abstract' is redundant for interface methods</li>
 *     <li>Modifier 'public' is redundant for interface methods</li>
 * </ul>
 * We should try to use interfaces whenever possible but if we see we need to
 * extends a class then we can try to go for an abstract class.<br><br>
 *
 * <u>Question 2 :</u>
 * <ul>
 *     <li>Main difference is methods of a Java interface are implicitly abstract and
 *     cannot have implementations.
 *     A Java abstract class can have instance methods that implements a default behavior.</li>
 *     <li><b>Variables declared in a Java interface is by default final.
 *     An abstract class may contain non-final variables</b></li>
 *     <li>Members of a Java interface are public by default. A Java abstract class
 *     can have the usual flavors of class members like private, protected, etc..</li>
 *     <li>A Java class can implement multiple interfaces but it can extend only one abstract class</li>
 *     <li>Interface is absolutely abstract and cannot be instantiated;
 *     A Java abstract class also cannot be instantiated,
 *     <b>but can be invoked if a main() exists</b></li>
 * </ul><br>
 *
 * <u>Question 4 :</u>
 * <br>The only correct definition of an abstract class are : <br>
 * "abstract class D { protected void m1(); }<br>
 * "abstract class E { abstract void m1(); }<br><br>
 *
 * <u>Question 5 :</u>
 * <br>The only correct definition of an Interface is :<br>
 * "interface D { void m1(); }"<br>
 * We dont put the brackets after m1() because we NEVER define the method in the interface.<br><br>
 *
 * <u>Question 6 :</u>
 * Since B is a child of D which is a child of C, the output is "b is an instanceof C".<br>
 * NOTE : it's usually considered to be bad design to have a super super class.
 */
abstract interface I1 {
    public abstract void m1();
}
