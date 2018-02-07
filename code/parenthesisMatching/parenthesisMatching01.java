package com.hellojava.count0and1;

import java.util.Scanner;
import java.util.Stack;

public class parenthesisMatching01 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("字符串:");
        String str =  sc.next();
        char[] ch  = str.toCharArray();
        int len = ch.length;

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int i=0,j=0;
        while(i<len){
            if(ch[i]=='('||ch[i]=='['||ch[i]=='{'){
                stack1.push(ch[i]);
            }
            i++;
        }
        while (i<len){
            if(ch[j]==')'||ch[j]==']'||ch[j]=='}'){
                stack2.push(ch[j]);
            }
            j++;
        }
        if(stack1.size()!=stack2.size()){
            System.out.println("NO");
        }else{
            while(!stack1.isEmpty()&&!stack2.isEmpty()){
                stack1.pop();
                stack2.pop();
            }
            System.out.println("Yes");
        }
    }
}
