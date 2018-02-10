package org.saumya.stack;

/**
 * This interface defines the common methods of a Stack
 *
 * @author Shukla, Saumya
 */

interface IStack<T> {

    void push(T element);

    T pop();

    boolean isEmpty();

    //return top element of the stack
    T peek();


}
