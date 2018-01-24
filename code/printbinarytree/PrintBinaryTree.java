package com.hellojava.com.hellojava.printbinarytree;

public class PrintBinaryTree {
    public static void printBinaryTree(Node head){
        System.out.println("Binary Tree:");
        printInorder(head,0,"H",17);
        System.out.println();
    }
    public static void printInorder(Node head,int height,String to,int len){
        if(head==null){
            return ;
        }
        printInorder(head.right,height+1,"v",17);

        String val = to+head.value+to;
        int lenM = val.length();
        int lenL = (len-lenM)/2;
        int lenR = len-lenL-lenM;
        val = printSpace(lenL)+val+ printSpace(lenR);
        System.out.println(printSpace(height*len)+ val);
        printInorder(head.left,height+1,"^",len);
    }

    public static String  printSpace(int len) {
        String ss = " ";
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < len; i++) {
            sbf.append(ss);
        }
        return sbf.toString();
    }
}
