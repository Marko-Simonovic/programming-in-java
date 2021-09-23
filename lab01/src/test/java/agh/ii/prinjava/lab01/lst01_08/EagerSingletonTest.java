package agh.ii.prinjava.lab01.lst01_08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EagerSingletonTest {

    @BeforeEach
    void setUp() {
        System.out.println("TestEagerSingleton.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestEagerSingleton.tearDown...");
    }

    @Test
    void TestGetInstance() { // it's the only public method so it needs to be tested
        if (EagerSingleton.getInstance() != EagerSingleton.getInstance()) {
            System.out.println("Two instances of an EagerSingleton?");
        }
        else{
            System.out.println("There is only a single instance");
        }
    }
}