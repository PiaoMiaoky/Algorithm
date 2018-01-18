package com.hellojava.BSTtoDoubleLinkedList;

import static com.hellojava.BSTtoDoubleLinkedList.BSTtoDoubleLinkedList.hasBSTtoDoubleLinkedList;
import static com.hellojava.BSTtoDoubleLinkedList.BSTtoDoubleLinkedList.printBSTInOrder;
import static com.hellojava.BSTtoDoubleLinkedList.BSTtoDoubleLinkedList.printDoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = hasBSTtoDoubleLinkedList(head);
        printDoubleLinkedList(head);
    }
}
