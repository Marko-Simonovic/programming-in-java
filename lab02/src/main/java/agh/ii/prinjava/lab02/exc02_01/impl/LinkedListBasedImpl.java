package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

import java.util.EmptyStackException;

public class LinkedListBasedImpl implements StackOfInts {
    private int numOfElems = 0;
    private Node top;


    /**
     * Remove the last element of the List = Stack
     * @return int
     *              the last value of the List, which means of the stack
     */
    @Override
    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();

        int result = top.elem;
        top = top.next;
        numOfElems--;
        //throw new IllegalStateException("To be implemented");

        return result;
    }

    /**
     * Push a given value to the last position of the List = Stack
     * @param x
     *             the value pushed at the last position
     */
    @Override
    public void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        numOfElems++;

        //throw new IllegalStateException("To be implemented");
    }


    /**
     * Count the numbers of element in the List
     * @return int
     *               the size of the stack
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Gives the value on the top of the Stack without removing it
     * @return int
     *              the value of the top element
     */
    @Override
    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return top.elem;
        //throw new IllegalStateException("To be implemented");
    }

    /**
     * Nested class representing the Node of a List, useful to move in the List
     */
    private static class Node {
        int elem; // data
        Node next; // reference variable to the next Node

        public Node(int elem) {
            this.elem = elem;
        }
    }

    /**
     * Creates an instance of the LinkedListBasedImpl class and add value to the stack, then
     * prints them and remove 2 of them.
     * @param args
     */
    public static void main(String[] args) {

        LinkedListBasedImpl stack = new LinkedListBasedImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Size of stack is: " + stack.numOfElems());

        stack.pop();
        stack.pop();

        System.out.println("Top element of stack after 2 pop is: " + stack.peek());

    }
}
