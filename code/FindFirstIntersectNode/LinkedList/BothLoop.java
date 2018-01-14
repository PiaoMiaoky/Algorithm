package com.hellojava.LinkedList;

public class BothLoop {
	/*判断两个有环链表是否相交，相交则返回第一个相交的结点
	*解法:1.首先已经得到了loop1和loop2
	*     2.如果loop1==loop2 开始考虑会不会在没到环之前已经相遇
	*     3.如果loop1！=loop2,那么在看loop1跑一圈会不会遇到loop2
	*	  4.如果遇到,那么loop1和loop2都可以是第一个相交结点
	*	  5.没遇到返回null
	*/
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node node1 = null;
        Node node2 = null;
        if (loop1 == loop2) {
            node1 = head1;
            node2 = head2;
            int n = 0;
            while (node1 != null) {
                n++;
                node1 = node1.next;
            }
            while (node2 != null) {
                n--;
                node2 = node2.next;
            }
            node1 = n > 0 ? head1 : head2;
            node2 = node1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                node1 = node1.next;
            }

            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        } else {
            node1 = loop1.next;
            while(node1!=loop1){
                if(node1==loop2){
                    return loop1;
                }
                node1 = node1.next;
            }
            return null;
        }

    }
}
