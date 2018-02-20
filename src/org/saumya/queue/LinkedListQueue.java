package org.saumya.queue;

import java.util.NoSuchElementException;

/**
 * This class implements the  Queue using LinkedList
 *
 * @author Shukla, Saumya
 */


public class LinkedListQueue<T> implements IQueue<T>{

    private QNode front,rear;
    public LinkedListQueue(){
        this.front = this.rear = null;
    }


    class QNode
    {
        T data;
        QNode next;


        public QNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        if(this.front==null) {
            return true;
        }
        return false;
    }

    public void enqueue(T data){

       QNode temp = new QNode(data);
        if (rear == null)
        {
            front = rear = temp;
            return;
        }
       rear.next=temp;
       rear=temp;


    }

    public T dequeue(){
        if (this.front == null)
         throw new NoSuchElementException("Queue is empty");
        QNode temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        System.out.println("Item dequeued from queue is :"+temp.data);
        return temp.data;

    }

    public T getFront(){
        return front.data;

    }
    public T getRear(){
        return rear.data;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        QNode temp = front;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) {
                sb.append(",");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(" " + q.toString());
        q.dequeue();
        q.dequeue();
        System.out.println(" " + q.toString());
        System.out.println("Item at front of the queue:" + q.getFront());
        System.out.println("Item at rear of the queue:" + q.getRear());


    }

}
