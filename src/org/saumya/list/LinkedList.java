package org.saumya.list;

/**
 * This class implements the Linked List
 *
 * @author Shukla, Saumya
 */
public class LinkedList implements List {

    private Node first;
    private int n;

    public LinkedList() {
        this.first = null;
        this.n = 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void insertFirst(int element) {
        Node oldFirst = first;
        first = new Node();
        first.value = element;
        first.next = oldFirst;
        n++;
    }

    @Override
    public void insertEnd(int element) {
        Node newNode = new Node(element, null);
        newNode.next = null;

        if (first == null) {
            first = new Node(element, null);
        } else {
            Node last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        n++;
    }

    @Override
    public void insertAtIndex(int element, int index) {
        if (index > n) {
            throw new IllegalArgumentException("List size is " + size() + ", could not insert at index: " + index);
        }

        // 1,2,3 insert at 2nd index 4 -> 1,2,4,3
        Node temp = first;
        int current = 1;
        while (current < index) {
            temp = temp.next;
            current++;
        }

        Node oldNext = temp.next;
        temp.next = new Node(element, oldNext);
        n++;
    }

    private void insertAfterNode(Node previous, int element) {
        if (previous == null) {
            throw new IllegalArgumentException("Previous node cannot be null");
        } else {
            Node newNode = new Node(element, null);
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    @Override
    public int indexOf(int element) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.value == element) {
                return index;
            } else {
                temp = temp.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public void delete(int index) {
        if (index > n) {
            throw new IllegalArgumentException("List size is " + size() + ", could not insert at index: " + index);
        }

        Node previousNode = first;
        int current = 1;
        while (current < index) {
            previousNode = previousNode.next;
            current++;
        }

        Node nodeToDelete = previousNode.next;
        previousNode.next = nodeToDelete.next;
        n--;
        nodeToDelete = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node temp = first;
        while (temp != null) {
            sb.append(" " + temp.value);
            temp = temp.next;
        }
        sb.append("}");
        return sb.toString();
    }

    private class Node {
        private Integer value;
        private Node next;

        public Node() {
        }

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        List list = new LinkedList();
        System.out.println("Initial size: " + list.size());

        list.insertEnd(10);
        list.insertEnd(20);
        System.out.println("After inserting 10 and 20 at end: " + list.toString());

        list.insertFirst(5);
        list.insertFirst(9);
        System.out.println("After inserting 9 and 5 at beginning: " + list.toString());

        list.insertAtIndex(6, 1);
        System.out.println("After inserting 6 at index 1: " + list.toString());

        System.out.println("Index of 5 in list: " + list.indexOf(5));
        System.out.println("Index of 20 in list: " + list.indexOf(20));

        list.delete(1);
        System.out.println("After deleting element at index 1: " + list.toString());
        System.out.println("Size of list: " + list.size());
    }
}
