package agh.ii.prinjava.lab01.lst01_03;

public class Rectangle extends Shape {
    private double w;
    private double h;

    @Override // The original area method is defined in the abstract class 'Shape'
    public double area() {
        return w * h;
    }

    @Override
    public double perimeter() {
        return 2 * (w + h);
    }

    /**
     * Overloaded constructor (ad-hoc polymorphism, compile-time)
     */
    public Rectangle(double w, double h, boolean filled) {
        super(filled); // -> Shape(boolean filled)
        this.w = w;
        this.h = h;
    }

    /**
     * Overloaded constructor (ad-hoc polymorphism, compile-time)<br>
     * Here, we will call this method when knowing the Rectangle shape is filled. This is why we give
     * only 2 arguments
     */
    public Rectangle(double w, double h) {
        this(w, h, true); // -> Rectangle(double w, double h, boolean filled)
    }
}
