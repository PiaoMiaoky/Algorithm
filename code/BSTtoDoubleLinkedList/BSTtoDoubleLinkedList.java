package com.hellojava.BSTtoDoubleLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtoDoubleLinkedList {
    /**
     * 解法一:用队列收集二叉树中序遍历结果的方法
     *      1.时间复杂度O(n)
     *      2.空间复杂度O(N)
     *      3.利用二叉树的中序遍历
     * @param head
     * @return
     */
    public static Node hasBSTtoDoubleLinkedList(Node head){
        Queue<Node> queue = new LinkedList<Node>();
        inOrderToQueue(head,queue);
        if(queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node pre = head;
        head.left = null;
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }
    public static void inOrderToQueue(Node head,Queue<Node> queue){
        if(head==null){
            return;
        }
        inOrderToQueue(head.left,queue);
        queue.offer(head);
        inOrderToQueue(head.right,queue);
    }


    public static void printDoubleLinkedList(Node head){
        System.out.print("Double Linked Lsit:");
        Node end = null;
        while(head!=null){
            System.out.print(head.value+" ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while(end!=null){
            System.out.print(end.value+" ");
            end = end.left;
        }
        System.out.println();
    }

    public static void printBSTInOrder(Node head){
        System.out.print("BST in-order:");
        if(head!=null){
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head){
        if(head==null){
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value+" ");
        inOrderPrint(head.right);
    }


}
