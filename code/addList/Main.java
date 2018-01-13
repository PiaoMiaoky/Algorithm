package com.hellojava.addList;
public class Main {
    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(8);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(7);
        System.out.print(1);
        AddList.print(head1);

        Node head2 = new Node(4);
        head2.next = new Node(2);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(1);
        System.out.print(2);
        AddList.print(head2);
        //head1 = AddList.addList1(head1,head2);
        //AddList.print(head1);

        head1 = AddList.addList2(head1,head2);
        AddList.print(head1);
    }
}
