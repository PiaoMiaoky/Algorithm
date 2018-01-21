package com.hellojava.mergedoublesortedLinkedList;

public class Main {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        head1.next.next.next.next = new Node(9);
        Node head2 = new Node(5);
        head2.next = new Node(7);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(9);
        head2.next.next.next.next = new Node(10);
        MergeDoubleSortedLinkedList.print(head1);
        MergeDoubleSortedLinkedList.print(head2);
        head1 = MergeDoubleSortedLinkedList.mergeDoubleSortedLinkedList(head1,head2);
        MergeDoubleSortedLinkedList.print(head1);
    }
}
