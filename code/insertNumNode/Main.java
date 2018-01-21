package com.hellojava.insertNumNode;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next.next = head;
        InsertNumNode.print(head);
        head=InsertNumNode.insertNumNode(head,20);
        InsertNumNode.print(head);
    }
}
