package com.hellojava.ArrayPartition;

public class main {
	public static void main(String[] args) {
		int[] arr= {1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
		ArrayPartition.print(arr);
		ArrayPartition.leftUnique(arr);
		ArrayPartition.print(arr);
		
		int[] array= {0,1,2,1,2,0,1,0,2,1,2,1,0,1,2,1};
		ArrayPartition.print(array);
		ArrayPartition.sort(array);
		ArrayPartition.print(array);
	}
}
