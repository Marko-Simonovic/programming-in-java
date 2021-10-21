package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Provides a series of test in order to check the validity of the methods in DLinkList.java.<br>
 * All the test starts from a simple DLinkList and each test one of the method present in the class.
 */
class DLinkListTest {
    DLinkList<Integer> dLinkList = new DLinkList<>();

    /**
     * Creates a list with 3 elements in it (6,5,4) before each test.<br>
     * With 3 elements already presents we can quickly try to add, remove, etc.
     */
    @BeforeEach
    void setUp() {
        System.out.println("TestDLinkList.setUp...");
        dLinkList.addFirst(4);
        dLinkList.addFirst(5);
        dLinkList.addFirst(6);
    }

    /**
     * Prints a message indicating the end of each test.
     */
    @AfterEach
    void tearDown() {
    System.out.println("TestDLinkList.tearDown...");
    }

    /**
     * The test purposes is to add a value to an already given list to check if it adds the value at the beginning.<br>
     * After that we remove immediately the first element to see if it was the one added just before.
     */
    @Test
    void TestAddFirst() {
        dLinkList.addFirst(7);
        System.out.println(dLinkList);
        assertEquals(7, dLinkList.removeFirst()); // We make sure it passes the test because a Sys.out will always pass
    }

    /**
     * The test purposes is to add a value at the end of a list.<br>
     * After that, we remove immediately the first element to see if it was the one added just before.
     */
    @Test
    void TestAddLast() {
        dLinkList.addLast(7);
        System.out.println(dLinkList);
        assertEquals(7, dLinkList.removeLast());
    }

    /**
     * Checks if the removed element is the first element in the Doubly Linked List.<br>
     * The test checks if the value returned by the function is indeed the first value of the list.
     * We also make sure the method doesn't work (as it should), when given an empty list.
     */
    @Test
    void TestRemoveFirst() {
        System.out.println("Removing First...");
        System.out.println(dLinkList);

        assertEquals(6, dLinkList.removeFirst());
        assertEquals(5, dLinkList.removeFirst());
        assertEquals(4, dLinkList.removeFirst());

        assertThrows(ArrayIndexOutOfBoundsException.class, dLinkList::removeFirst);
        System.out.println(dLinkList);
    }


    /**
     * Checks if the removed element is the last element in the Doubly Linked List.<br>
     * The test checks if the value returned by the function is indeed the last value of the list.
     * We also make sure the method doesn't work (as it should), when given an empty list.
     */
    @Test
    void TestRemoveLast() {
        System.out.println(dLinkList);

        assertEquals(4 , dLinkList.removeLast());
        assertEquals(5, dLinkList.removeLast());
        assertEquals(6, dLinkList.removeLast());

        // We want to check that the program stop correctly when we do something illegal.
        // Here we force the function to throw the OutOfBounds Exception in order to pass the test.
        assertThrows(ArrayIndexOutOfBoundsException.class, dLinkList::removeLast); // replace () -> dLL.removeLast();
        System.out.println(dLinkList);
    }


    /**
     * Test if the function GetSize return the correct size of the list.<br>
     * The test begin with a list of 3 elements (6,5,4) from which we will add 7 after, changing the size to 4.
     */
    @Test
    void TestGetSize() {
        assertEquals(3, dLinkList.getSize());
        dLinkList.addLast(7);
        assertEquals(4, dLinkList.getSize());
    }

    /**
     * Checks if we can retrieve an element at different positions in the list.
     */
    @Test
    void TestPeek() {
        assertEquals(6, dLinkList.peek(0));
        assertEquals(4, dLinkList.peek(dLinkList.getSize()));
        dLinkList.addLast(7);
        assertEquals(7, dLinkList.peek(dLinkList.getSize()));
    }
}