package com.hellojava.LinkedList;

public class IntersectNode {
    public static Node getIntersectNode(Node head1,Node head2){
		//链表有环问题
		/*
		*分解为三个子问题
		*	1.一个单链表有环，返回第一个到环的结点,否则返回null
		*	2.两个非环链表相交，返回第一个相交点，否则返回null
		*	3.两个有环链表，相交结点可能在没到环之前相交，也可能是在环上有两个
		*		相交点
		*/
        if(head1==null||head2==null){
            return null;
        }
        Node loop1 = HasRingLinked.getLoopNode(head1);
        Node loop2 = HasRingLinked.getLoopNode(head2);
        if(loop1==null&&loop2==null){
            return NoLoopLinkedList.noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return BothLoop.bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
}
