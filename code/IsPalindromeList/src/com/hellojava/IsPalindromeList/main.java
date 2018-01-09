package com.hellojava.IsPalindromeList;
public class main {
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(3);
		head1.next.next.next.next = new Node(2);
		head1.next.next.next.next.next = new Node(1);
		PalindromeList.printLinkedList(head1);
		System.out.println(PalindromeList.isPalindromeList1(head1));
		System.out.println(PalindromeList.isPalindromeList2(head1));
		System.out.println(PalindromeList.isPalindromeList3(head1));
	}
}
