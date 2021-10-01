package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayBasedImplTest {

    // Create an empty stack
    // HERE, we are choosing the reference we want to create
    // By doing this we have substituted the base interface by its implementation
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void pop() {
        final  int X = 1;
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
    void peek() {
        final int X=3;
        stackOfInts.push(X);
        final int numOfElemsFinal = stackOfInts.peek();
        assertEquals(X, numOfElemsFinal);
    }
}