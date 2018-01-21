package com.hellojava.RemoveNodeWired;

public class RemoveNodeWired {
    public static void removeNodeWired(Node node){
        if(node==null){
            return;
        }
        Node next = node.next;
        if(next==null){
            throw new RuntimeException("can not remove last node");
        }
        node.value = next.value;
        node.next = next.next;
    }

    public static void print(Node head){
        System.out.print("Linked List:");
        while(head!=null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
        System.out.println();
    }
}
