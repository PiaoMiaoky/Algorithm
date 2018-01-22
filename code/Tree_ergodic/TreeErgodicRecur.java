package com.hellojava.Tree_ergodic;

public class TreeErgodicRecur {
    //递归遍历
    public static void preOrderRecur(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.value+"  ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if(head==null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+"  ");
        inOrderRecur(head.right);
    }


    public static void posOrderRecur(Node head){
        if(head==null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+"  ");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left  = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left =  new Node(6);
        head.right.right = new Node(7);
        System.out.print("前序遍历:");
        preOrderRecur(head);
        System.out.println();
        System.out.print("中序遍历");
        inOrderRecur(head);
        System.out.println();
        System.out.print("后序遍历:");
        posOrderRecur(head);
        System.out.println();

    }
}
