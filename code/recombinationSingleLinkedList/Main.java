package com.hellojava.recombinationSingleLinkedList;

public class Main {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        RecombinationSingleLinkedList.printLinkedList(head1);
        RecombinationSingleLinkedList.relocation(head1);
        RecombinationSingleLinkedList.printLinkedList(head1);
    }
}
