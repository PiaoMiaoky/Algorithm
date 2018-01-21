package com.hellojava.insertNumNode;

public class InsertNumNode {
    public static Node insertNumNode(Node head,int num){
        Node node = new Node(num);
        if(head==null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while(cur!=head){
            if(pre.value<=num
                    &&cur.value>=num){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value<num?head:node;

    }
    public static void print(Node head){
        if (head == null){
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }
}
