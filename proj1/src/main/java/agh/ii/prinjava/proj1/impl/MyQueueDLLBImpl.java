package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * A collection offering the possibility to hold objects before using them.<br>
 * Similar to Stack, Queue provides almost the same services. Although, Queue follows
 * the <b>FIFO (First In First Out) rule.</b><br><br>
 * The Queue here use <b>the implementation of DLinkList</b>, meaning it uses a doubly linked list
 * <b>but the semantic of the Queue remains</b>. User doesn't know anything about implementation because
 * it is hid from him.
 * @param <E> the element that will compose the Queue.
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>(); // This represents AGGREGATION and we should prioritize AGG over INHERITANCE

    /**
     * Put an element in the "back" of the Queue which means at the last position.<br><br>
     * @param x the object to be pushed in the Queue, at the back.
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * Removes the value in the "front" of the Queue which means the first that entered.<br><br>
     * @return the first element in the Queue, the front.
     */
    @Override
    public E dequeue() {
        return elems.removeFirst();
    }

    /**
     * Count the numbers of element in a Queue.<br><br>
     * @return the size of the Queue.
     */
    @Override
    public int numOfElems() {
        return elems.getSize();
    }

    /**
     * Peek function goal in a Queue is to retrieve the first element of the Queue without deleting it.<br><br>
     * @return element E, the first value in the queue, at the tail.
     */
    @Override
    public E peek() {
        return elems.peek(0);
    }

    /**
     * Print the Queue in the form of a list with the front as the first value and the back as the last value.<br><br>
     * @return the String to be printed.
     */
    @Override
    public String toString() {
       return elems.toString();
    }
}
