package com.hellojava.test;

import com.hellojava.main.DoubleNode;
import com.hellojava.main.Node;
import com.hellojava.main.ReverseList;

public class Test1 {
    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next=new Node(9);
        ReverseList.printNodeList(head1);
        head1 = ReverseList.reverseNodeList(head1);
        ReverseList.printNodeList(head1);

        DoubleNode head2= new DoubleNode(2);
        head2.next = new DoubleNode(4);
        head2.next.last=head2;
        head2.next.next = new DoubleNode(6);
        head2.next.next.last=head2.next;
        head2.next.next.next = new DoubleNode(8);
        head2.next.next.next.last=head2.next.next;
        ReverseList.printDoubleNodeList(head2);
        ReverseList.printDoubleNodeList(ReverseList.reverseDoubleNodeList(head2));
    }
}
