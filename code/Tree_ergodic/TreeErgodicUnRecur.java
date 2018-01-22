package com.hellojava.Tree_ergodic;

import java.util.Stack;

public class TreeErgodicUnRecur {
    public static void preOrderUncur(Node head){
        System.out.print("前序遍历:");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+"  ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }

        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head){
        System.out.print("中序遍历:");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value+"  ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }


    public static void posOrderUnRecur1(Node head){
        System.out.print("后序遍历:");
        if(head!=null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.print(s2.pop().value+"  ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(Node head){
        //head是最近一次弹出并打印
        System.out.print("后序遍历:");
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node c = null;
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null&&head != c.left&&head!=c.right){
                    stack.push(c.left);
                }else if(c.right != null&&head != c.right){
                    stack.push(c.right);
                }else{
                    System.out.print(stack.pop().value+"  ");
                    head = c ;
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left  = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left =  new Node(6);
        head.right.right = new Node(7);
        preOrderUncur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }
}
