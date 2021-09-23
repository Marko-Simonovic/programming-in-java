package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestRectangle.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestRectangle.tearDown");

    }

    @Test
    void perimeter() {
        Rectangle rectangle = new Rectangle(2, 3, true);

        assertEquals(10, rectangle.perimeter());
    }
}