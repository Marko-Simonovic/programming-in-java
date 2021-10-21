package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 * Stack offers the possibility to hold objects in a stack of objects.<br>
 * Similar to Queue, Stack provides almost the same services.
 * Although, Stack follows the <b>LIFO (Last In First Out) rule</b>.<br><br>
 * The Stack here use the implementation of DLinkList, meaning it uses a doubly linked list but the semantic of
 * the Stack remains. User doesn't know anything about implementation because it is hid from him.
 * Type parameters:
 * <E> – the element that will compose the Stack.
 * @param <E>
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Removes the object on the top of the stack.<br>
     * The element removed correspond to the first element in the Doubly Linked List.<br><br>
     * @return the element to be removed: the top of the stack.
     */
    @Override
    public E pop() {
        return elems.removeFirst();
    }

    /**
     * Push an object at the top of the stack.<br>
     * The element pushed correspond to the first element in the Doubly Linked List.<br><br>
     * @param x the object to be pushed into the stack
     */
    @Override
    public void push(E x) {
        elems.addFirst(x);
    }

    /**
     * Count the numbers of element in a Stack.<br><br>
     * @return the size of the Stack.
     */
    @Override
    public int numOfElems() {
        return elems.getSize();
    }

    /**
     * Retrieves the top element of the Stack without deleting it.<br><br>
     * @return element E, the last value in the Stack, at the top.
     */
    @Override
    public E peek() {
        return elems.peek(0);
    }

    /**
     * Print the Stack in the form of a list with the front as the last value and the back/top as the first value.<br><br>
     * @return the String to be printed.
     */
    @Override
    public String toString() {
        return elems.toString();
    }
}
