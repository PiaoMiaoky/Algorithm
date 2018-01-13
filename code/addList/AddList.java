package com.hellojava.addList;

import java.util.Stack;

public class AddList {
    public static Node addList1(Node head1,Node head2){
        /**
         * 普通解法1.让两个链表的结点的值分别入两个栈
         *        2.同时出栈，并且让两数相加
         *        3.首先把pre放在node上
         *        4.创建一个结点，结点的值为n%10个,挂上去;
         *        5.最后两栈为空，如果ca等于1,那么在建一个结点加上去
         */
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(head1!=null){
            s1.push(head1.value);
            head1=head1.next;
        }

        while(head2!=null){
            s2.push(head2.value);
            head2=head2.next;
        }

        int ca = 0;//进位
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node pre = null;//存放node的前置结点
        Node node = null;//存放new的结点

        while(!s1.isEmpty()||!s2.isEmpty()){
            n1 = s1.isEmpty()?0:s1.pop();
            n2 = s2.isEmpty()?0:s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
        }

        if(ca==1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }


    public static Node addList2(Node head1,Node head2){
        //逆序两个链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);


        int ca = 0;//存储进位
        int n1 = 0;
        int n2 = 0;
        int n  = 0;
        Node c1 = head1; //用于遍历链表1
        Node c2 = head2;//用于遍历链表2
        Node node = null;
        Node pre = null;

        while(c1!=null||c2!=null){
            n1 = c1!=null?c1.value:0;
            n2 = c2!=null?c2.value:0;
            n = n1 +n2 +ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
            c1 = c1!=null?c1.next:null;
            c2 = c2!=null?c2.next:null;
        }

        if(ca==1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;

    }


    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void print(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
