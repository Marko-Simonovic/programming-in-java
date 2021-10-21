package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    Pair<Integer, String> pairOfIntStr;

    @BeforeEach
    void setUp() {
        System.out.println("PairTest.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("PairTest.tearDown...");
    }

    @Test
    void t1() {
        assertTrue(true);
    }

    @Test
    void testClone() {
        try {
            pairOfIntStr = new Pair<>(12, "Marko");
            Pair pairOfIntStrCopy = pairOfIntStr.clone();
            if (pairOfIntStrCopy.equals(pairOfIntStr)) {
                System.out.println("Equals");
            }
            else {
                System.out.println("Not equals");
            }
        }
        catch (Exception e) {
            System.out.println("Exception was catched !");
        }
    }
}