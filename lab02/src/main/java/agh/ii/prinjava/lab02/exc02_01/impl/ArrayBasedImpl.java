package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class ArrayBasedImpl implements StackOfInts {

    private int numOfElems = 0;
    private final Integer[] S = new Integer[7];

    /**
     * Remove the last element of the Array = Stack
     * @return int
     *              the last value of the array, which means of the stack
     */
    @Override
    public int pop() {
        if (isEmpty())
            System.out.println("stack empty, nothing to pop");
        return S[numOfElems--];
        //throw new IllegalStateException("To be implemented");
    }

    /**
     * Push a given value to the last position of the Array = Stack
     * @param x
     *             the value pushed at the last position
     */
    @Override
    public void push(int x) {
        S[++numOfElems] = x;
        //throw new IllegalStateException("To be implemented");
    }

    /**
     * Count the numbers of element in the Array
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
            System.out.println("Stack empty, no top");
        //throw new IllegalStateException("To be implemented");
        return S[numOfElems]; // the last entered value
    }

    public static void main(String[] args) {

        ArrayBasedImpl stack = new ArrayBasedImpl();
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