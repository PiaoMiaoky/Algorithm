package com.hellojava.bignum;

import java.util.Scanner;
import java.util.Stack;

public class Bignum {
    //将阿拉伯数字转换为中文数字(九位数字以内)
    public static int receiveRandom(){
        System.out.print("请输入一个正数字，不超过九位:");
        Scanner sc = new Scanner(System.in);
        int value =0;
        try{
            value =  sc.nextInt();
        if(value>999999999) {
            System.out.println("小朋友你怕是有点调皮");
            return 0;
        }
        }catch (Exception e){
            System.out.println("不管了，反正你输入的有问题");
        }

        return value;
    }

    public static Stack<Character> reverice(int value){
        int temp = 0;
        char[] ch1 = {'十','百','千','万','亿'};
        char[] ch2 = {'零','一','二','三','四','五','六','七','八','九','十'};
        Stack<Character> stack = new Stack<>();
        while(value!=0){
            for(int i=0;i<10;i++){
                if(value%10==i){
                    stack.push(ch2[i]);
                }
            }
            value = value/10;
            if(value>0) {
                ++temp;
                if(temp==1||temp==5){
                    stack.push(ch1[0]);
                }
                if(temp==2||temp==6){
                    stack.push(ch1[1]);
                }
                if(temp==3||temp==7){
                    stack.push(ch1[2]);
                }
                if(temp==4){
                    stack.push(ch1[3]);
                }
                if(temp==8){
                    stack.push(ch1[4]);
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
       int value =   receiveRandom();
       Stack<Character> stack =  reverice(value);
       String str = "";
       while(!stack.isEmpty()){
           str += stack.pop();
       }
        System.out.println(str);
    }

}
