package com.hellojava.count0and1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class jumpTest {

    public static int jumpI(int target){
        int One = 1;
        int Two = 2;
        int result = 0;
        if(target==1||target==2){
            return target;
        }else{
            for(int i=3;i<=target;i++){
                result = One + Two;
                One = Two;
                Two = result;
            }
            return result;
        }

    }

    //递归实现理解起来容易，但栈太深的话，会出现异常
    public static int  jump(int target){
        if(target==0){
            return 0;
        }
        if(target==1||target==2){
            return target;
        }
        return jump(target-1)+jump(target-2);
    }
    public static void main(String[] args) {
        System.out.println("请输入台阶数:");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

         int a = jump(target);
         int b = jumpI(target);
        System.out.println("跳的方法"+a);
        System.out.println("跳的方法"+b);
    }
}
