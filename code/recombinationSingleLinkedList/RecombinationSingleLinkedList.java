package com.hellojava.recombinationSingleLinkedList;

public class RecombinationSingleLinkedList {
    public static void relocation(Node head){
        if(head==null||head.next==null){
            return;
        }
        Node mid = head;//左半区最后一个结点
        Node right = head.next;//右半区的头结点
        while(right.next!=null&&right.next.next!=null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        MergeLR(head,right);
    }
    public static void MergeLR(Node left,Node right){
        Node next = null;
        while(left.next!=null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }


    public static void printLinkedList(Node head){
        System.out.print("LinkedList:");
        while(head!=null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
        System.out.println();
    }
}
