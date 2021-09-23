package agh.ii.prinjava.lab01.lst01_08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazySingletonTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestLazySingleton.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestLazySingleton.tearDown...");
    }

    @Test
    void TestgetInstance() {

        if (LazySingleton.getInstance() != LazySingleton.getInstance()) {
            System.out.println("Two instances of a sLazySingleton?");
        }
        else {
            System.out.println("There is only a single instance of LazySingleton");
        }
    }
}