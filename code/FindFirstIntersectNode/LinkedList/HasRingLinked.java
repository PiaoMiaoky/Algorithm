package com.hellojava.LinkedList;

public class HasRingLinked {
    public static Node getLoopNode(Node head){
		
		//快慢指针解决问题
		/*
		*1.fast 指针一次两步    slow指针一次一步
		*2.如果出现相交结点
		*fast拉回到head
		*两个指针同时每次一步跑，相交时为入环的第一个结点
		*/
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }

        Node n1 = head.next;  //n1-->slow
        Node n2 = head.next.next; //n2-->fast
        while(n1!=n2){
            if(n1==null||n2==null){
                return null;
            }

            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = head;

        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


}
