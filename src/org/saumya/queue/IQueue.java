package org.saumya.queue;
/**
 * This interface defines the common methods of a Queue
 *
 * @author Shukla, Saumya
 */

public interface IQueue<T> {

    boolean isEmpty();

    void enqueue(T element);
    T dequeue();
    T getFront();
    T getRear();
}
