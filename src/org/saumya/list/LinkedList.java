package org.saumya.list;

/**
 * This class implements the Linked List
 *
 * @author Shukla, Saumya
 */
public class LinkedList<T> implements List<T> {

    private Node first;
    private int n;

    public LinkedList() {
        this.first = null;
        this.n = 0;
    }

    public LinkedList(T... elements) {
        this();
        for (T element : elements) {
            insertEnd(element);
        }
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
    public void insertFirst(T element) {
        Node oldFirst = first;
        first = new Node();
        first.value = element;
        first.next = oldFirst;
        n++;
    }

    @Override
    public void insertEnd(T element) {
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
    public void insertAtIndex(T element, int index) {
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

    private void insertAfterNode(Node previous, T element) {
        if (previous == null) {
            throw new IllegalArgumentException("Previous node cannot be null");
        } else {
            Node newNode = new Node(element, null);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        n++;
    }

    @Override
    public int indexOf(T element) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.value.equals(element)) {
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

    public void reverse() {
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }

    @Override
    public List<T> intersect(List<T> list2) {
        List result = new LinkedList();
        for (int i = 0; i < list2.size(); i++) {
            T x = list2.get(i);
            if (this.indexOf(x) != -1) {
                result.insertEnd(x);
            }
        }
        return result;
    }

    @Override
    public T get(int index) {
        if (index > n) {
            throw new IllegalArgumentException("Index " + index + " is greater than the size of the list");
        }

        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    @Override
    public int detectLoop() {
        Node n1 = first, n2 = first;
        while (n1 != null && n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
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

        list.reverse();
        System.out.println("Reversed linked list :" + list.toString());

        if (list.detectLoop() == 0) {
            System.out.println("No loop found");
        } else {
            System.out.println("Loop exists!!");
        }
        list2.insertEnd(20);
        list2.insertEnd(1);
        list2.insertEnd(5);
        list2.insertEnd(3);
        list2.insertEnd(2);
        System.out.println(" " + list2.toString());
        List result = list.intersect(list2);
        System.out.println(" Intersected nodes " + result.toString());
    }
}
