package agh.ii.prinjava.lab01.lst01_03;

import java.util.List;

/**
 * There are different kinds of polymorphism. During the course we will cover:
 * <ul>
 *     <li>ad-hoc polymorphism (overloading of operators, functions, or - as in Java - methods)</li>
 *     <li>subtype/inclusion polymorphism (in this example)</li>
 *     <li>parametric polymorphism</li>
 * </ul>
 * <p>
 *     Question 5 : <br>
 *     There is 3 types of polymorphism as said before
 *     <ul>
 *         <li>ad-hoc (<b>=surcharge</b>) is when we define multiple times the same method
 *         but with different parameters given <br>(i.e. void area(), void area(int a), void area (int a,b))</li>
 *         <li>subtype polymorphism is when the defined method is override in different classes.
 *         Usually used with inheritance, polymorphism permits to adapt the method to the child classes
 *         (i.e. cat.sound(), dog.sound())</li>
 *         <li>parametric polymorphism uses Collections in Java and the fact that we can specify
 *         a specific wanted type of element</li>
 *     </ul>
 * </p>
 * <p>
 *     Question 6 : <br>
 *     It is important to not confuse inheritance and polymorphism. Inheritance represents a
 *     relation of 'A-IS', it includes the notion of parent and child. In other words, a class
 *     that inherits from another share some common attributes and methods. Thus, <b>mixed with
 *     polymorphism we can use Inheritance to redefine and adapt a method to the current class</b>.
 * </p>
 */
public class Main {
    /**
     * Subtype polymorphism - ability of a reference variable to take different forms
     */
    private static double totalArea(List<Shape> shapes) {
        double totArea = 0;


        // s is polymorphic - it can refer to instances of the whole family of types derived from 'Shape'
        // We use 'for each' Shape in the list 'shapes'
        for (Shape s : shapes) {
            totArea += s.area();
        }

        return totArea;
    }

    public static void main(String[] args) {
        // Here, everything is considered as filled
        double totArea = totalArea(List.of(
                new Circle(5),
                new Rectangle(2, 5),
                new Circle(10),
                new Rectangle(10, 20)));

        System.out.printf("totalArea = %.2f\n", totArea);
    }
}
