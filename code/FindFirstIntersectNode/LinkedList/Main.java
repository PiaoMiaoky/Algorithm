package com.hellojava.LinkedList;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        Node cr = head.next.next.next;
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next.next = cr;
        System.out.print(HasRingLinked.getLoopNode(head).value);

        Node head1 = new Node(1);
        head1.next = new Node(5);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(3);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(7);
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(7);
        System.out.println(NoLoopLinkedList.noLoop(head1,head2));

    }
}
