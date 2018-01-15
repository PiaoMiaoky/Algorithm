package com.hellojava.reversekthnode;

import java.util.Stack;

public class Method1 {
    /**
     * 解法一:利用一个栈结构，时间复杂度O(n),空间复杂度O(k)
     *      1.若K<2，直接返回，因为没有意义
     *      2.用一个栈结构，只要栈内元素个数等于k,说明此时应该进行一次反转
     *      3.
     *
     *
     */
    public static Node reverseNodes1(Node head,int k){
        if(k<2){
            return head;
        }

        Stack<Node> stack = new Stack<Node>();
        Node newhead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur!=null){
            next = cur.next;
            stack.push(cur);
            if(stack.size()==k){
                pre = resign1(stack,pre,next);
                newhead = newhead==head?cur:newhead;
            }
            cur = next;
        }
        return newhead;
    }

    public static Node resign1(Stack<Node> stack,Node left,Node right){
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
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
