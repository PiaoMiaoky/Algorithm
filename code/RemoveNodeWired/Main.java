package com.hellojava.RemoveNodeWired;

public class Main {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(5);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(6);
        Node node = new Node(11);
        head1.next.next.next.next = new Node(3);
        head1.next.next.next.next.next = node;
        head1.next.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next.next = new Node(7);
        RemoveNodeWired.print(head1);
        RemoveNodeWired.removeNodeWired(node);
        RemoveNodeWired.print(head1);

    }
}
