package com.hellojava.main;

/**
 * 反转单链表和双向链表
 */
public class ReverseList {
    //反转
    public static Node reverseNodeList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    //反转双向链表
    public static DoubleNode reverseDoubleNodeList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static void printDoubleNodeList(DoubleNode head){
        System.out.print("Double Linked List:");
        DoubleNode end =null;
        while(head!=null) {
            System.out.print(head.value + "\t");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while(end!= null) {
            System.out.print(end.value + "\t");
            end = end.last;
        }
        System.out.println();
    }

    public static void printNodeList(Node head){
        System.out.print(" Linked List:");
        while(head!=null){
            System.out.print(head.value+"\t");
            head=head.next;
        }
        System.out.println();
    }
}
