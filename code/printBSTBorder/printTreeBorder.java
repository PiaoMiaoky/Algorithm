package com.hellojava.printBSTBorder;

public class printTreeBorder {
    public static Node[][] printEdg1(Node head){
        if(head==null){
            return null;
        }
        //得到树的高度
        int height = getHeight(head,0);
        System.out.println(height);
        //把树每一层的最左和最右存入数组
        Node[][] edgeMap  = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        //打印每一层的最左结点
        for (int i=0;i<edgeMap.length;i++){
            System.out.print(edgeMap[i][0].value+"  ");
        }
        //打印每一层不是最左也不是最右的结点
        printnoLRNode(head,0,edgeMap);
        //打印每一层最右且不是最左的结点
        printnoLisRNode(edgeMap);
        System.out.println();
        return edgeMap;

    }
    public static int getHeight(Node head,int l){
        if(head==null){
            return l;
        }
        return Math.max(getHeight(head.left,l+1),getHeight(head.right,l+1));
    }
    public static void setEdgeMap(Node head,int l,Node[][] edgeMap){
        if(head==null){
            return ;
        }
        edgeMap[l][0] = edgeMap[l][0]==null? head:edgeMap[l][0];
        edgeMap[l][1] = head;
        setEdgeMap(head.left,l+1,edgeMap);
        setEdgeMap(head.right,l+1,edgeMap);
    }
    public static void printnoLRNode(Node head,int l,Node[][] edgeMap){
        if(head==null){
            return;
        }
        if(head!=edgeMap[l][0]&&head!=edgeMap[l][1]){
            System.out.print(head.value+"  ");
        }
        printnoLRNode(head.left,l+1,edgeMap);
        printnoLRNode(head.right,l+1,edgeMap);
    }

    public static void printnoLisRNode(Node[][] edgeMap){
        for(int i=edgeMap.length-1;i!=-1;i--){
            if(edgeMap[i][1]!=edgeMap[i][0]){
                System.out.print(edgeMap[i][1].value+"  ");
            }
        }
    }

    public static void printEdge2(Node head){
        if(head==null){
            return ;
        }
        System.out.print(head.value+"  ");
        if(head.left!=null&&head.right!=null){
            printLeftEdge(head.left,true);
            printRightEdge(head.right,true);
        }else{
            printEdge2(head.left!=null?head.left:head.right);
        }
        System.out.println();
    }

    //打印左子树及其左边界的叶子结点
    public static void printLeftEdge(Node head,boolean print){
        if(head==null){
            return;
        }
        if(print||(head.left==null&&head.right==null)){
            System.out.print(head.value+"  ");
        }
        printLeftEdge(head.left,print);
        printLeftEdge(head.right,print&&head.left==null?true:false);
    }

    //打印右子树及其右边界的叶子结点
    public static void printRightEdge(Node head,boolean print){
        if(head==null){
            return;
        }
        printRightEdge(head.right,print);
        printRightEdge(head.left,print&&head.right==null?true:false);
        if (print || (head.left == null && head.right == null)) {
            System.out.print(head.value+"  ");
        }
    }
}
