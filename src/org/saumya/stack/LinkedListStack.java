package org.saumya.stack;

/**
 * This class implements the Stack using Linked List
 *
 * @author Shukla, Saumya
 */
public class LinkedListStack<T> implements IStack<T> {

    private Node first;
    private int n;

    public LinkedListStack() {
        this.first = null;
        this.n = 0;
    }

    private class Node {
        private T value;
        private Node next;

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(T element) {
        Node oldFirst = first;
        first = new Node();
        first.value = element;
        first.next = oldFirst;
        n++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.value);
            if (temp.next != null) {
                sb.append(",");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public T pop() {
        Node temp = first;
        first = first.next;
        return temp.value;
    }

    @Override
    public T peek() {
        if (first == null) {
            System.out.println(" Stack Underflow");
        }
        return first.value;
    }


    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
        st.push(3);
        st.push(5);
        st.push(6);
        st.push(7);
        st.toString();
        System.out.println(" " + st.toString());
        System.out.println("Element at peek :" + st.peek());
        System.out.println("Element popped from stack :" + st.pop());

    }
}


