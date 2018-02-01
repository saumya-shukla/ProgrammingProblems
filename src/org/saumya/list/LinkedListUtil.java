package org.saumya.list;

/**
 * This class implements the Linked List Utilities
 *
 * @author Shukla, Saumya
 */

public class LinkedListUtil<T> {

    private Node first;
    private int n;

    public LinkedListUtil() {
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

    public void insertFirst(T element) {
        Node oldFirst = first;
        first = new Node();
        first.value = element;
        first.next = oldFirst;
        n++;
    }

    public boolean search(int x) {

        Node current = first;    //Initialize current
        while (current != null) {
            if (current.value.equals(x))
                return true;    //data found
            current = current.next;
        }
        return false;
    }

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

    public boolean isPalindrome(LinkedListUtil list2) {
        int start = 0;
        int end = size() - 1;
        while (start < end) {
            if (!list2.get(start).equals(list2.get(end))) {
                return false;

            }
            start++;
            end--;

        }
        return true;
    }

    public T getMiddle() {

        Node ptr1 = first;
        Node ptr2 = first;
        if (first != null) {
            while (ptr2 != null && ptr2.next != null) {
                ptr2 = ptr2.next.next;
                ptr1 = ptr1.next;
            }


        }
        return ptr1.value;
    }

    public boolean isLengthEven() {
        Node ptr1 = first;
        while (ptr1 != null && ptr1.next != null) {
            ptr1 = ptr1.next.next;
        }
        return ptr1 == null;
    }


    public int size() {
        return n;
    }

    public static void main(String[] args) {

        LinkedListUtil<Integer> list = new LinkedListUtil();
        LinkedListUtil<String> list2 = new LinkedListUtil<String>();
        list.insertFirst(20);
        list.insertFirst(12);
        list.insertFirst(5);
        list.insertFirst(2);
        System.out.println("Linked List after insertion:" + list.toString());

        System.out.println("Linked List contains element 5 " + list.search(5));
        System.out.println("Linked List contains element 9 " + list.search(9));

        System.out.println(" Middle element of the linked list is :" + list.getMiddle());

        System.out.println("Length of linked list is even :" + list.isLengthEven());

        list2.insertFirst("R");
        list2.insertFirst("A");
        list2.insertFirst("D");
        list2.insertFirst("A");
        list2.insertFirst("R");
        System.out.println("Linked List after insertion:" + list2.toString());
        System.out.println("Linked List is a palindrome:" + list2.isPalindrome(list2));


    }
}
