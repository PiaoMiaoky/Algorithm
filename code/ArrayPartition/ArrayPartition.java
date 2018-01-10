package com.hellojava.ArrayPartition;

import java.util.Collections;

public class ArrayPartition {
	/*
	 * ����һ�������ظ�����,����ʹ�����Ϊ�������ظ����ұ���Ҫ��
	 */
	public static void leftUnique(int[] arr) {
		if(arr==null||arr.length<2) {
			return;
		}
		int u = 0;
		int i = 1;
		while(i!=arr.length) {
			if(arr[i++]!=arr[u]) {
				swap(arr, ++u, i-1);
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/*
	 * ����һ������arr,���п��ܺ���0��1��2��ʵ��arr������
	 * 1.��arr��Ϊ��������
	 * 2.����arr[0..left] ����0	left��ֵΪ-1
	 *   ����arr[left+1..index]����1 index��ֵΪ0
	 *   ����arr[right..N-1] ����2  right��ֵΪN
	 * 
	 */
	public static void sort(int[] arr) {
		if(arr==null||arr.length<2) {
			return ;
		}
		
		int left = -1;
		int index = 0;
		int right = arr.length;
		/*
		 * ֻҪindex!=right׼ȷ˵��index����rightʱ��
		 * ֤���Ѿ��������
		 * 1.����������н���
		 * 	arr[0..left][left+1..index][right..N-1]
		 */
		while(index<right) {
			if(arr[index]==0) {
				swap(arr,++left,index++);
			}else if(arr[index]==2) {
				swap(arr,index,--right);
			}else {
				index++;
			}
		}
	}
	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
