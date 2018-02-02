package com.hellojava.count0and1;

public class LongestIncreasingSubsequence {
    public static int length = 0;
    public static int[] getdp(int[] array){
        int[] dp  = new int[array.length];
        for(int i=0;i<array.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(array[j]<array[i]){
                   dp[i] =  Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    public static int[] generateLIS(int[] arr,int[] dp){
        int len = 0; //用来存储子序列的长度
        int index = 0;//用来存储此时的值的下标
        for(int i=0;i<dp.length;i++){
            if(dp[i]>len){
                len = dp[i];
                index = i;
            }
        }
        length = len;
        int[] abc = new int[len];
        abc[--len] = arr[index];
        for(int i=index;i>-1;i--){
            if(arr[i] < arr[index]&&dp[i]==dp[index]-1){
                abc[--len] = arr[i];
                index = i;
            }
        }
        return abc;
    }

    public static int[] list(int[] arr){
        if(arr==null||arr.length==0){
            return null;
        }
        int[] dp = getdp(arr);
        return generateLIS(arr,dp);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,13,11,1,9,10,1,1,9,5,5,7,8,14,3,5,1,14};
        int[] array = new int[arr.length];
        array = list(arr);
        int[]ss =  getdp(arr);
        System.out.println(length);
        for (int num: array
             ) {
            System.out.print(num+"  ");
        }
    }
}
