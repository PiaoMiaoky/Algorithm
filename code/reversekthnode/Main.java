package com.hellojava.reversekthnode;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(13);
        Method1.print(head);
        head = Method2.reverseKnodes2(head,3);
        Method1.print(head);
    }
}
