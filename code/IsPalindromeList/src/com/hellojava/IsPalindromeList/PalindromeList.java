package com.hellojava.IsPalindromeList;

import java.util.Stack;

public class PalindromeList {
	/**
	 * �ⷨһ:1.ֱ�Ӵ����ұ�������,��ÿ����㶼������ջ����
	 * 		  2.���ٴγ�ջʱ�ж�ÿһ��Ԫ���Ƿ����������
	 * 		  
	 * 		����: ���ַ�������Ҫ������������	
	 * 
	 * 
	 */
	public static boolean isPalindromeList1(Node head) {
		Stack<Node> stack  = new Stack<Node>();
		Node cur = head;
		while(cur!=null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(head!=null) {
			if(head.value!=stack.pop().value) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	
	public static void printLinkedList(Node head) {
		System.out.print("LinkedList:");
		while(head!=null) {
			System.out.print(head.value+"\t");
			head = head.next;
		}
		System.out.println();
	}
	
	
	/**
	 * 
	 * �ⷨ��:1.��ʱ�����ж����������ֵ
	 * 		  2.ֻ��Ҫ�ж������һ�뼴��
	 * 		  3.���ǿ��԰������Ϊ����������
	 * 		  4.���ǽڵ������������ôֱ�Ӻ������м���Ǹ��ڵ�
	 * 		  5.�����Լ�������Ҫ����һ���õ������������ŷ���
	 * 			�Ǹ�����̫������
	 * 		  6.������������һ���û����ȫ���
	 * 		  7.�����ĺ͵�һ����������
	 * 
	 */
	public static boolean isPalindromeList2(Node head) {
		if(head==null||head.next==null) {
			return true;
		}
		Node right=head.next;
		Node cur = head;
		while(cur.next!=null&&cur.next.next!=null) {
			right = right.next;
			cur = cur.next.next;
		}
		
		Stack<Node> stack = new Stack<Node>();
		while(right!=null){ 
			stack.push(right);
			right = right.next;
		}
		
		while(!stack.isEmpty()) {
			if(head.value!=stack.pop().value) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	
	/*
	 * �ⷨ��:1.����Ҫջ�����������ݽṹ,ֻ��Ҫ����Node���͵�ֵ
	 * 	      2.����ռ临�Ӷ�O(1) ʱ�临�Ӷ�O(N)
	 * 		  3.���ȸı������Ұ����Ľṹ��ʹ�䷴ת�����ָ���м�ڵ�
	 * 		  4.����ͬʱ���м��ƶ��������һ�������ǻ���
	 * 		  5.���һ��Ҫ������ָ�Ϊԭ��������
	 * 	      6.�ָ�Ϊԭ�������ӣ�Ȼ�󷵻أ������
	 * 
	 * 
	 */
	public static boolean isPalindromeList3(Node head) {
		if(head==null||head.next==null) {
			return true;
		}
		
		Node n1 = head;
		Node n2 = head;
		while(n2.next!=null&&n2.next.next!=null) {
			/*
			 * ��ʱn1�ƶ������в�
			 * n2�ƶ����˽�β
			 */
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		
		/*
		 * n2ָ���Ҳ��ĵ�һ���ڵ�
		 */
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		/**
		 * �Ұ�����ת
		 */
		while(n2!=null) {
			n3 = n2.next;//n3������һ�����
			n2.next = n1;//��һ����ת�ӵ�
			n1 = n2;//�ƶ�n1
			n2 = n3;//�ƶ�n2
		}
		
		
		n3 = n1;//�������һ���ڵ�
		n2 = head;//��ߵĵ�һ���ڵ�
		boolean bool = true;
		/**
		 * ������
		 */
		while(n1!=null&&n2!=null) {
			if(n1.value!=n2.value) {
				bool = false;
				break;
			}
			n1 = n1.next;//���ҵ��в�
			n2 = n2.next;//�����в�
		}
		
		n1 = n3.next;
		n3.next = null;
		while(n1!=null) {//�ָ��б�
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return bool;
	}
}
