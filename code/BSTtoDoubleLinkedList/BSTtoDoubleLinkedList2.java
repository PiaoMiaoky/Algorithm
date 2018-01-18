package com.hellojava.BSTtoDoubleLinkedList;

public class BSTtoDoubleLinkedList2 {
    public static Node hasBSTtoDoubleLinkedList2(Node head){
        if(head==null){
            return null;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }


    public static Node process(Node head){
        if(head==null){
            return null;
        }
        Node leftE = process(head.left);
        Node rightE = process(head.right);
        Node leftS = leftE!=null?leftE.right:null;
        Node rightS = rightE!=null?rightE.right:null;
        if(leftE!=null&&rightE!=null){
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        }else if(leftE!=null){
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            return head;
        }else if(rightE!=null){
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        }else{
            head.right = head;
            return head;
        }
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
