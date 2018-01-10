package com.hellojava.sortLinkedList;

import com.hellojava.IsPalindromeList.Node;

public class Main {
	public static void main(String[] args) {
		Node head1 = new Node(0);
		head1.next = new Node(1);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(5);
		head1.next.next.next.next = new Node(4);
		head1.next.next.next.next.next = new Node(6);
		SortLinkedList.printLinkedList(head1);
		SortLinkedList.listPartition1(head1, 5);
		SortLinkedList.printLinkedList(head1);
	}
}
