package com.hellojava.sortLinkedList;

import com.hellojava.IsPalindromeList.Node;

public class SortLinkedList {
	/**
	 * 
	 * ������Ϊ�����ֵ���ͨ�ⷨ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
	 * 
	 * 
	 */
	public static Node listPartition1(Node head,int temp) {
		if(head==null) {
			return head;
		}
		int NodeCount = 0;
		Node cur = head;
		while(cur!=null) {
			NodeCount++;
			cur=cur.next;
		}
		
		//����ÿ��������������
		cur = head;
		Node[] arr = new Node[NodeCount];
		for(int i=0;i!=arr.length;i++) {
			arr[i] = cur;
			cur=cur.next;
		}
		
		
		sort(arr,temp);
		int i = 1;
		for(;i<arr.length;i++) {
			arr[i-1].next=arr[i];
		}
		arr[i-1].next=null;
		return arr[0];
	}
	
	/*
	 * ���������ų�������������
	 */
	public static void sort(Node[] arr,int temp) {
		int left = -1;
		int index = 0;
		int right = arr.length;
		while(index!=right) {
			if(arr[index].value<temp) {
				swap(arr,++left,index++);
			}else if(arr[index].value>temp) {
				swap(arr,--right,index);
			}else {
				index++;
			}
		}
	}
	
	//����
	public static void swap(Node[] arr,int i,int j) {
		Node temp  = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//���
	public static void printLinkedList(Node head) {
		System.out.print("LinkedList:");
		while(head!=null) {
			System.out.print(head.value+"\t");
			head = head.next;
		}
		System.out.println();
	}
}
