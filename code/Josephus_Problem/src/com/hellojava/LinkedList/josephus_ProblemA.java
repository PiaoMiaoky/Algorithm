package com.hellojava.LinkedList;

/**
 * 进阶解法：并不用每次遍历删掉结点，只要确定出来最终存活的结点就可
 * 1.假设报A的是编号B的结点
 *      A   1   2   i   i+1     i+2
 *      B   1   2   i   i+1     i+2
 *      B = (A - 1)%i+1
 * 2.编号s的结点被删除，环的节点数变为i-1
 *      环大小为i的每个结点编号    s-2     s-1     s   s+1     s+2
 *      删掉s后，环大小为i-1编号   i-2     i-1     --   1       2
 *      环大小为i的结点记为old    环大小为i-1的结点记为new
 *      old = (new + s- 1)%i +1
 *  3.
 */
public class josephus_ProblemA {
    public static Node josephusRingA(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        /**遍历链表
         * 统计节点个数O(n)
         */

        Node cur = head.next;
        int temp = 1;
        while(cur!=head){
            temp++;
            cur  = cur.next;
        }
        /**
         * 递归n层，O(N)
         */
        temp = getLive(temp,m);
        /**
         * 最终根据编号，遍历链表找到结点O(N)
         */
        while(--temp!=0){
            head = head.next;
        }
        head.next=head;
        return head;
    }
    public static int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+m-1)%i +1;
    }

}
