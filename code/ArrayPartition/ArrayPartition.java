package com.hellojava.ArrayPartition;

import java.util.Collections;

public class ArrayPartition {
	/*
	 * 给定一个有序重复数组,调整使其左边为有序无重复，右边无要求
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
	 * 给定一个数组arr,其中可能含有0，1，2，实现arr的排序
	 * 1.把arr分为三个区域
	 * 2.左区arr[0..left] 都是0	left初值为-1
	 *   中区arr[left+1..index]都是1 index初值为0
	 *   右区arr[right..N-1] 都是2  right初值为N
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
		 * 只要index!=right准确说当index等于right时，
		 * 证明已经排序完成
		 * 1.三种情况进行交换
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
