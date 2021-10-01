package agh.ii.prinjava.lab02.exc02_01;

// Here the interface shows the services provided by StackOfInts, its methods
// but without explaining how they work because they are not necessary.

/**
 * Stack of integers - Abstract Data Type (ADT)
 */
public interface StackOfInts {
    /**
     * Method that pop the last value of the Stack.
     * @return int
     *              the LAST value that came in
     */
    int pop();

    /**
     * Method that push a value into the Stack.
     * @param x
     *              the value that is being put in the stack
     */
    void push(int x);

    /**
     * Method that checks if the stack is empty, in order to know how to proceed further.
     * @return boolean
     *                  the state of the Stack, true for empty and false for not empty
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * This method count the numbers of Elements in the Stack.
     * @return int
     *              the size of the Stack
     */
    int numOfElems();

    /**
     * Method that gives the top element without returning it
     * @return int
     *              the top element of the stack
     */
    int peek();
}
