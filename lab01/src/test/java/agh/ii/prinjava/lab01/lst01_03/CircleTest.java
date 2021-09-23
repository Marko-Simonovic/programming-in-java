package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestCircle.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestCalc.tearDown...");
    }

    @Test
    void area() {
    }

    // Unit test that compare two numbers : one expected and the actual.
    // It's used to see if the method does correctly the operation.
    @Test
    void perimeter() {
        // if
        Circle circle = new Circle(4, true);

        // then
        assertEquals(2 * Math.PI * 4, circle.perimeter());
    }
}