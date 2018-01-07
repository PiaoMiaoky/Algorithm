import java.util.Scanner;

public class ReversePartLinkedList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static Node reversePrat(Node head,int from,int to){
        //初始化变量
        //用于统计当前节点是第几个
        int len = 0;
        //指向需要反转的第一个节点
        Node head1 = head;
        //指向需要反转的结点的第一个结点的前一个节点和需要反转的最后一个节点的下一个结点
        Node fPre = null;
        Node tPos = null;

        while(head1!=null){
            len++;
            fPre = from-1==len?head1:fPre;
            tPos = to+1==len?head1:tPos;
            head1=head1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        head1 = fPre==null?head:fPre.next;
        Node head2 = head1.next;
        head1.next = tPos;
        Node next = null;
        while(head2!=tPos){
            next = head2.next;
            head2.next = head1;
            head1 = head2;
            head2 = next;
        }
        if(fPre!=null){
            fPre.next=head1;
            return head;
        }
        return head1;
    }

    public static void print(Node head){
        System.out.print("LinkedList:");
        while(head!=null){
            System.out.print(head.value+"\t");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.print("请输入需要反转的范围:");
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        ReversePartLinkedList.print(head);
        head = ReversePartLinkedList.reversePrat(head,from,to);
        ReversePartLinkedList.print(head);
    }
}
