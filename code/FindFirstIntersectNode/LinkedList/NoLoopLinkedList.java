package com.hellojava.LinkedList;

public class NoLoopLinkedList {
    public static Node noLoop(Node head1,Node head2){
		
		//返回两个无环单链表的相交结点
		/*
		*1.遍历链表，得到链表长度和最后一个结点
		*2.如果最后一个节点不相等，返回null
		*3.判断链表长短，长的先走长度之差的步数
		*4.两个一起走,走到两者相等的时候返回node1
		*
		*
		*/
        while(head1==null||head2==null){
            return null;
        }

        Node node1 = head1;
        Node node2 = head2;

        int n = 0;
        while(node1!=null){
            n++;
            node1 = node1.next;
        }

        while(node2!=null){
            n--;
            node2 = node2.next;
        }
        if(node1!=node2){
            return null;
        }
        node1 = n>0?head1:head2;
        node2 = node1 ==head1?head2:head1;
        n = Math.abs(n);

        while(n!=0){
            n--;
            node1 = node1.next;
        }

        while(node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
