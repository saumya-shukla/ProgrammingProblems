package org.saumya.queue;

import java.util.NoSuchElementException;

/**
 * This class implements the  Queue using Arrays
 *
 * @author Shukla, Saumya
 */

public class ArrayQueue<T> implements IQueue<T> {

    private T[] array;
    private int front, rear, size;
    private int maxCapacity;

    public ArrayQueue() {
        this.maxCapacity = 2;
        this.array = (T[]) new Object[maxCapacity];
        this.size = 0;
        this.rear =  - 1;
        this.front = -1;
    }

    private void resize(int newSize) {
        assert newSize >= size;
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
        this.maxCapacity = newSize;
    }


    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(T element) {


            if (size + 1 == maxCapacity)
                resize(2 * maxCapacity);

        rear = (rear + 1) % maxCapacity;
        array[rear] = element;
        size = size + 1;
        System.out.println(element + " enqueued to queue");
    }

    public T dequeue() {
        if (isEmpty()) {
         throw new NoSuchElementException("Queue is Empty");
        }

        T item = array[front];
        front = (front + 1) % maxCapacity;
        size = size - 1;

        return item;
    }

    public T getFront() {
        if (isEmpty())
            System.out.println("Queue is Empty");

        return array[front];
    }

    // Method to get rear of queue
    public T getRear() {
        if (isEmpty())
            System.out.println("Queue is empty");

        return array[rear];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(" " + queue.toString());
        queue.dequeue();

        System.out.println("Item at the rear end: " + queue.getRear());
        System.out.println("Item at the front end: " + queue.getFront());
    }

}






