package com.hellojava.LinkedList;

public class PrintLinkedList {
    public static void printLinkedList(Node head){
        System.out.print("Linked list");
        while(head!=null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
        System.out.println();
    }
}
