
import com.hellojava.LinkedList.Josephus_Problem;
import com.hellojava.LinkedList.Node;
import com.hellojava.LinkedList.josephus_ProblemA;

public class main {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1;
        Josephus_Problem.printCircularList(head1);
        head1 = Josephus_Problem.josephusRing(head1,3);
        Josephus_Problem.printCircularList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);
        head2.next.next.next.next.next.next = head2;
        Josephus_Problem.printCircularList(head2);
        head2 = josephus_ProblemA.josephusRingA(head2, 3);
        Josephus_Problem.printCircularList(head2);

    }
}
