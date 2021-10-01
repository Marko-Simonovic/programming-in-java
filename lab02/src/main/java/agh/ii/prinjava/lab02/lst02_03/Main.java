package agh.ii.prinjava.lab02.lst02_03;

// Cannot inherit from final 'FinalClass'
// class TryingToExtendFinalClass extends FinalClass {}

/**
 * <b>Question 2 :</b><br>
 * Constants are useful in Java because they give the possibility to a lot of things.
 * They can create objects closer to the reality, some objects just doesn't change over time.
 * Constants permits to create object that won't change which protects data by the way.
 * With constants we can clearly manipulate our data without worrying.<br><br>
 *
 * <b>Question 3 :</b><br>
 * <ul>
 *     <li>local variables = you cannot change the value</li>
 *     <li>instance variables = you can assign a value one time (usually in the constructor)</li>
 *     <li>static constants = fixed value for every instance of the class</li>
 *     <li>methods = you cannot override</li>
 *     <li>classes = you cannot extend it, doesn't have any child</li>
 * </ul>
 *
 * <b>Question 4 :</b><br>
 *  No. It must also contain no get methods that would return a reference to a
 *  mutable data field object.<br>
 *  But if all the data fields in a class are private and primitive type (=cant change value),
 *  and the class contains no set methods, the class immutable<br><br>
 *
 *  <b>Question 5 :</b><br>
 *  The class (see code) is not immutable because it is not composed of primitive type.
 *  There is an array of Int which means we could access to the value by using
 *  the reference of the object.
 */
public class Main {
    public static void main(String[] args) {
        FinalClass fc = new FinalClass(10);
        System.out.println("fc.x = " + fc.getX());
    }
}
