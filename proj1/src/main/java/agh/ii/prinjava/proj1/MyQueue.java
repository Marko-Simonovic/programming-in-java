package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 * A collection offering the possibility to hold objects before using them.<br>
 * Similar to Stack, Queue provides almost the same services. Although, Queue follows
 * the FIFO (First In First Out) rule. The head of the queue is that element which would be
 * removed by a call to dequeue(). In a FIFO queue, all new elements are inserted at the tail of the queue.
 * @param <E> the type of Element held in the Queue.
 */
public interface MyQueue<E> {
    /**
     * Insert an object at the tail of the Queue.
     * @param x the object to be pushed in the Queue.
     */
    void enqueue(E x);

    /**
     * Remove the Object at the head of the Queue.
     * @return the Object to be removed from the Queue.
     */
    E dequeue();

    /**
     * Checks whether the Queue contains any object or not. Can be useful for conditioning blocks.
     * @return boolean, if true then the Queue is empty, if false then the Queue contains at least one object.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * @return the number of Element inside the Queue.
     */
    int numOfElems();

    /**
     * Look for the head of the Queue and return it.
     * @return the head of the Queue, will return <i>null</i> if empty.
     */
    E peek();

    /**
     * Create a Queue object without having to specify the exact class of the object that will be created.<br>
     * Useful because the range of returning type is much bigger and mix well with the Singleton pattern in order to
     * control the number of instance created.
     * @param <T> the type of the Object that will be created.
     * @return new Instance of Queue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
