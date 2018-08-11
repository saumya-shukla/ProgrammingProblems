package org.saumya.list;
//rotation of a linked list
public class RotateLinkedList {


  public Node head;

    class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
    }

    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public Node rotateList(Node head,int k){
        Node current  = head;
        int count = 1;
        while (count < k && current !=  null)
        {
            current = current.next;
            count++;
        }
        Node kthNode = current;

        while (current.next != null)
            current = current.next;
        current.next = head;

        head = kthNode.next;

        kthNode.next = null;
        return head;
    }
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RotateLinkedList rl=new RotateLinkedList();
        for (int i = 60; i >= 10; i -= 10)
            rl.push(i);
        System.out.println("list before rotation");
        rl.printList();
        System.out.println(rl.head.data);
        rl.head = rl.rotateList(rl.head,4);
        System.out.println("list after rotation"+ rl.head.data);
        rl.printList();
    }
}
