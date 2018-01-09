package com.hellojava.IsPalindromeList;

import java.io.Serializable;

public class Node implements Serializable{
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}
