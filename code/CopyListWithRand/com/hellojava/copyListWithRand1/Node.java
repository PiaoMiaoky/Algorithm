package com.hellojava.copyListWithRand1;

import java.io.Serializable;

public class Node implements Serializable{
    public int value;
    public Node next;
    public Node rand;
    public Node(int data){
        this.value = data;
    }
}
