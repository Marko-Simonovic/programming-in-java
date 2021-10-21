package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * A collection representing a Stack of object of type E.<br>
 * Stacks follow the rule LIFO (Last In First Out). When created, Stacks doesn't contain any object and they are
 * added by the methods it provides : pop, push.
 * @param <E> the type of Element in this Stack
 */
public interface MyStack<E> {
    /**
     * Remove the object at the top of the stack and returns its position.
     * @return the object which was on top of the stack (cf: LIFO).
     */
    E pop();

    /**
     * Insert an object at the top of the stack.
     * @param x the object to be pushed into the stack
     */
    void push(E x);

    /**
     * Checks whether the stack contains any object or not. Can be useful for conditioning blocks.
     * @return boolean, if true then the stack is empty, if false then the stack contains at least one object.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * @return the number of Element inside the stack.
     */
    int numOfElems();

    /**
     * Retrieve the top element of the Stack and return it without deleting it.
     * @return the top/last element of the Stack.
     */
    E peek();

    /**
     * Create a Stack object without having to specify the exact class of the object that will be created.<br>
     * Useful because the range of returning type is much bigger and mix well with the Singleton pattern in order
     * to control the number of instance created.
     * @param <T> the type of the Object that will be created.
     * @return new Instance of class.
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
