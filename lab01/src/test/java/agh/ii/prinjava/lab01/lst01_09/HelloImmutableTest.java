package agh.ii.prinjava.lab01.lst01_09;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloImmutableTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestHelloImmutable.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestHelloImmutable.tearDown...");
    }

    @Test
    void FinalHelloImmutable(){
        HelloImmutable final_hi1 = new HelloImmutable(1, "original");
        HelloImmutable final_hi2 = new HelloImmutable(2, "hi it's the remix");

        System.out.println(final_hi1);
        System.out.println(final_hi2);

        assertNotEquals(final_hi1, final_hi2); // it is not Equal
        final_hi1 = final_hi2; // something changes here???

        if (final_hi1.equals(final_hi2)) {
            System.out.println("egale");
        }
        else {
            System.out.println("pas egale");
        }
        System.out.println(final_hi1);
    }

    @Test
    void getI1() {
    }

    @Test
    void getS1() {
    }

    @Test
    void testToString() {
    }
}