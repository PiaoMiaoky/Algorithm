package com.hellojava.com.hellojava.printbinarytree;

public class test {
    public static void print(Node head){
        System.out.println("Tree:");
        printInorder1(head,0,"H",17);
        System.out.println();
    }


    public static void printInorder1(Node head,int height,String to,int len){
        if(head==null){
            return ;
        }

        printInorder1(head.right,height+1,"v",len);
        String val = to+head.value+to;
        int lenM = val.length();
        int lenL = (len-lenM)/2;
        int lenR = len-lenL-lenM;
        val = space(lenL)+val +space(lenR);
        System.out.println(space(height*len)+val);
        printInorder1(head.left,height+1,"^",len);
    }

    public static String space(int num){
        String str = " ";
        StringBuffer sbf = new StringBuffer("");
        for (int i=0;i<num;i++){
            sbf.append(str);
        }
        return sbf.toString();
    }
}
