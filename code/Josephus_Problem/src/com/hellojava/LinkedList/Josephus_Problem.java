package com.hellojava.LinkedList;

/**
 * 普通解法，但时间复杂度O(n*m)
 */
public class Josephus_Problem {
    public static Node josephusRing(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        /**
         * last 指针先放在head上
         * 循环让last指向链表的最后一个节点
        */
        Node last = head;
        while(last.next!=head){
            last = last.next;
        }
        int count = 0;
        while(head!=last){
            if(++count==m){
                last.next = head.next;
                count = 0;
            }else{
                last = last.next;
            }
            /**
             * head最终还是要指向last的下一个结点
             */
            head = last.next;
        }
        return head;
    }
    public static void printCircularList(Node head){
        if(head==null){
            return ;
        }
        System.out.print("Circular List:"+head.value+" ");
        Node cur = head.next;
        while(cur!=head){
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println("->"+head.value);
    }
}
