package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Provides a series of test in order to check the validity of the methods in MyQueueDLL.java.<br>
 * The serie of test also checks if the implementation using DLinkList is finally correct.
 * All the test starts from a simple Queue and each test one of the method present in the class.
 */
class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts = MyQueue.create();

    /**
     * Creates a Queue with 3 elements in it (1,2,3) before each test.
     * With 3 elements already presents we can quickly try to enqueue, dequeue, etc.
     */
    @BeforeEach
    void setUp() {
        System.out.println("TestMyQueue.setUp...");
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);

    }

    /**
     * Prints a message indicating the end of each test.
     */
    @AfterEach
    void tearDown() {
        System.out.println("TestMyQueue.tearDown...");
    }

    /**
     * The test purposes is to add a value at the end of the Queue.<br>
     * After that, we remove immediately the first elements one by one and use peek() method to see
     * if it was the element added just before.
     */
    @Test
    void TestEnqueue() {
        Integer elem;
        queueOfInts.enqueue(4);

        int size = queueOfInts.numOfElems();
        for (int i=1; i < size; i++) {
            elem = queueOfInts.dequeue(); // Will dequeue 3 times, only 4 will remain in the Queue
            //System.out.println(queueOfInts); // Not obligated to print
        }
        assertEquals(4, queueOfInts.peek());
        System.out.println(queueOfInts.peek());
    }

    /**
     * Checks if the removed element is the front element of the Queue.<br>
     * We also make sure the method doesn't work (as it should), when given an empty Queue.
     */
    @Test
    void TestDequeue() {
        assertEquals(1, queueOfInts.dequeue());
        assertEquals(2, queueOfInts.dequeue());
        assertEquals(3, queueOfInts.dequeue());

        assertThrows(ArrayIndexOutOfBoundsException.class, queueOfInts::dequeue);
        System.out.println(queueOfInts);
    }

    /**
     * Test the numbers of elements present in the Queue given (1,2,3).
     */
    @Test
    void TestNumberElems() {
        assertEquals(3, queueOfInts.numOfElems());
        System.out.println(queueOfInts.numOfElems());
    }

    /**
     * Checks if we correctly retrieve the front element in the Queue.<br>
     * It corresponds to the first element in a list too.
     */
    @Test
    void TestPeek() {
        assertEquals(1, queueOfInts.peek());
        assertEquals(queueOfInts.peek(), queueOfInts.dequeue());

        // Test if empty Queue
        Integer e;
        for (int i=0; i<2; i++){ e = queueOfInts.dequeue();}
        assertThrows(NullPointerException.class, queueOfInts::peek);

    }
}