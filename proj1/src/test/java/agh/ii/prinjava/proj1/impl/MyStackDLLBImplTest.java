package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides a series of test in order to check the validity of the methods in MyStackDLL.java.<br>
 * The serie of test also checks if the implementation using DLinkList is finally correct.
 * All the test starts from a simple Stack and each test one of the method present in the class.
 */
class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    /**
     * The setUp provides a simple Stack composed of 3 elements (3,2,1) from top to bottom.<br>
     * The stack provided helps to test quickly the methods pop(), push(), etc
     */
    @BeforeEach
    void setUp() {
        System.out.println("TestMyStack.setUp...");
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);
        System.out.println(stackOfInts);
    }

    /**
     * Indicates the end of each test
     */
    @AfterEach
    void tearDown() {
        System.out.println("TestMyStack.tearDown...");
    }

    /**
     * The test purposes is to add a value at the top of the Stack.<br>
     * After that, we remove immediately the first elements to see if it was the one added before.
     */
    @Test
    void TestPush() {
        stackOfInts.push(4);
        assertEquals(4, stackOfInts.pop());
    }

    /**
     * Checks if the removed element is the top element of the Stack.<br>
     * We also make sure the method doesn't work (as it should), when given an empty Stack.
     */
    @Test
    void TestPop() {
        assertEquals(3, stackOfInts.pop());
        assertEquals(2, stackOfInts.pop());
        assertEquals(1, stackOfInts.pop());

        assertThrows(ArrayIndexOutOfBoundsException.class, stackOfInts::pop);
    }

    /**
     * Test the numbers of elements present in the Stack given (3,2,1).
     */
    @Test
    void TestNumberElems() {
        assertEquals(3, stackOfInts.numOfElems());
    }

    /**
     * Checks if we correctly retrieve the top element in the Stack.<br>
     * It corresponds to the first element in a list too.
     */
    @Test
    void TestPeek() {
        assertEquals(3, stackOfInts.peek());
        assertEquals(stackOfInts.peek(), stackOfInts.pop()); // If we do it the other way the stack will change before calling peek()

        Integer e;
        for (int i=0; i<2; i++) { e = stackOfInts.pop();}
        assertThrows(NullPointerException.class, stackOfInts::peek);
    }
}