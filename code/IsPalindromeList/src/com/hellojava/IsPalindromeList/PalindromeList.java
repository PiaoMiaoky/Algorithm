package com.hellojava.IsPalindromeList;

import java.util.Stack;

public class PalindromeList {
	/**
	 * 解法一:1.直接从左到右遍历链表,把每个结点都进行入栈操作
	 * 		  2.当再次出栈时判断每一个元素是否与链表相等
	 * 		  
	 * 		不足: 此种方法的需要遍历整个链表	
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
	 * 解法二:1.此时不用判断整个链表的值
	 * 		  2.只需要判断链表的一半即可
	 * 		  3.我们可以把链表分为左右两部分
	 * 		  4.若是节点个数是奇数那么直接忽略最中间的那个节点
	 * 		  5.本来自己想着是要遍历一遍拿到个数，但最后才发现
	 * 			那个还是太复杂了
	 * 		  6.题中这个规律我还是没有完全理解
	 * 		  7.其他的和第一个方法相似
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
	 * 解法三:1.不需要栈和其他的数据结构,只需要几个Node类型的值
	 * 	      2.额外空间复杂度O(1) 时间复杂度O(N)
	 * 		  3.首先改变链表右半区的结构，使其反转，最后指向中间节点
	 * 		  4.左右同时向中间移动，如果都一样，就是回文
	 * 		  5.最后一定要把链表恢复为原来的样子
	 * 	      6.恢复为原来的样子，然后返回，检查结果
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
			 * 此时n1移动到了中部
			 * n2移动到了结尾
			 */
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		
		/*
		 * n2指向右部的第一个节点
		 */
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		/**
		 * 右半区反转
		 */
		while(n2!=null) {
			n3 = n2.next;//n3保存下一个结点
			n2.next = n1;//下一个反转接点
			n1 = n2;//移动n1
			n2 = n3;//移动n2
		}
		
		
		n3 = n1;//保存最后一个节点
		n2 = head;//左边的第一个节点
		boolean bool = true;
		/**
		 * 检查回文
		 */
		while(n1!=null&&n2!=null) {
			if(n1.value!=n2.value) {
				bool = false;
				break;
			}
			n1 = n1.next;//从右到中部
			n2 = n2.next;//从左到中部
		}
		
		n1 = n3.next;
		n3.next = null;
		while(n1!=null) {//恢复列表
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return bool;
	}
}
