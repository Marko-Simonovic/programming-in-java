package agh.ii.prinjava.lab01.lst01_02;

import java.math.BigDecimal;
import java.util.List;

/**
 * <ul>
 *     <li>Inheritance (implementation/code inheritance, in C++ private inheritance)
 *         is a form of code reuse</li>
 *     <li>Subtyping (interface inheritance, in C++ <i>public inheritance</i>)
 *         refers to compatibility of interfaces, establishes an <i>IS-A</i> relationship</li>
 *  </ul>
 * <p>
 *  Note: Java (but also C++ and C#) consolidates both ideas, i.e., an <i>IS-A</i> relationship is established
 *        via class extension (but also interface implementation)
 * </p>
 *  <br>
 *  Question 4 : <br>
 *  Inheritance indicates that the current class will have the same attributes of the parent class.
 *  Then, the child class can <b>specialized</b> itself by adding attributes and methods.
 */
public class RichDadsKid extends RichDad {

    // Constructor
    public RichDadsKid(String name, String surname, BigDecimal inhFortune, List<String> inhContacts) {
        super(name, surname, inhFortune, inhContacts);
    }

    @Override
    protected void increaseWealth() {
        // ... we'll do it my way
    }

    // extension = new Methods that aren't in the parent-class
    public void newSkill1() {
    }

    public void newSkill2() {
    }
    // ...
}
