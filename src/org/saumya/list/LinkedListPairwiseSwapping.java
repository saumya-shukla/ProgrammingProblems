package org.saumya.list;


public class LinkedListPairwiseSwapping {
    private Node first;
    private int n;

    public LinkedListPairwiseSwapping() {
        this.first = null;
        this.n = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedListPairwiseSwapping(int... elements) {
        this();
        for (int element : elements) {
            insertFirst(element);
        }
    }

    public String toString(Node temp) {
        StringBuilder sb = new StringBuilder("[");
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

    public void insertFirst(int element) {
        Node oldFirst = first;
        first = new Node();
        first.value = element;
        first.next = oldFirst;
        n++;
    }

    //swapping of node data without swapping links
    void pairWiseSwapData() {
        Node temp = first;

        while (temp != null && temp.next != null) {

            /* Swap the data */
            int x = temp.value;
            temp.value = temp.next.value;
            temp.next.value = x;
            temp = temp.next.next;
        }
    }

    Node pairWiseSwappingLinks(Node node) {

        if (node == null || node.next == null) {
            return null;
        }

        // Initialize previous and current pointers
        Node prev = node;
        Node curr = node.next;

        node = curr;

        while (true) {
            Node next = curr.next;
            curr.next = prev;
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }


            prev.next = next.next;
            prev = next;
            curr = prev.next;
        }
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        {
            LinkedListPairwiseSwapping list = new LinkedListPairwiseSwapping(1, 2, 3, 4, 5, 6);
            System.out.println("Linked list after insertion: " + list.toString(list.first));
            list.pairWiseSwapData();
            System.out.println("Linked list after pairwise swapping data :" + list.toString(list.first));
            Node st = list.pairWiseSwappingLinks(list.first);
            System.out.println("Linked list after pairwise  swapping links: ");
            list.printList(st);


        }

    }
}



