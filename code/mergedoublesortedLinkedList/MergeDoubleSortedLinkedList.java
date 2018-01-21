package com.hellojava.mergedoublesortedLinkedList;

public class MergeDoubleSortedLinkedList {
    public static Node mergeDoubleSortedLinkedList(Node head1,Node head2){
        //如果为空直接返回
        if(head1==null||head2==null){
            return head1==null?head2:head1;
        }
        //
        Node head = head1.value<head2.value?head1:head2;
        Node node1 = head1;
        Node node2 = head2;
        Node next = null;//用来存储下一个结点,防止链断掉
        Node small = null;//当前两者中的小值
        while(node1!=null&&node2!=null){
            if(node1.value <= node2.value){
                small = node1;
                node1 = node1.next;
            }else{
                /**
                 * 1.首先让next指上去，防止链断掉
                 * 2.挂链
                 * 3.small始终指在当前最小
                 */
                next = node2.next;
                small.next = node2;
                node2.next = node1;
                small = node2;
                node2 = next;
            }
        }
        small.next = node1==null?node2:node1;
        return head;
    }
    public static void print(Node head){
        System.out.print("LinkedList:");
        while(head!=null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
        System.out.println();
    }
}
