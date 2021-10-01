package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
        System.out.println("TestLinkedList.setUp...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestLinkedList.tearDown...");
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void pop() {
        final int X = 1;
        stackOfInts.push(X);
        final int numOfElemsInit = stackOfInts.numOfElems();
        stackOfInts.pop();
        final int numOfElemsFinal = stackOfInts.numOfElems();
        assertEquals(numOfElemsInit - 1, numOfElemsFinal );
    }

    @Test
    void push() {
        final  int X = 2;
        final int numOfElemsInit = stackOfInts.numOfElems();
        stackOfInts.push(X);
        final int numOfElemsFinal = stackOfInts.numOfElems();
        assertEquals(numOfElemsInit + 1, numOfElemsFinal );
        assertEquals(X, stackOfInts.peek() );
    }

    @Test
    void numOfElems() {
    }

    @Test
    void peek() {
        final int X=3;
        stackOfInts.push(X);
        final int numOfElemsInit = stackOfInts.numOfElems();
        final int numOfElems = stackOfInts.peek();
        final int numOfElemsFinal = stackOfInts.numOfElems();
        assertEquals(numOfElemsInit, numOfElemsFinal );
        assertEquals(X, numOfElems );
    }
}