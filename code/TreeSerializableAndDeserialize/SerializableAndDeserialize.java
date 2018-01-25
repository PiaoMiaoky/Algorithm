package com.hellojava.TreeSerializableAndDeserialize;

import java.util.LinkedList;
import java.util.Queue;

public class SerializableAndDeserialize {


    //树的前序遍历实现树的序列化
    public static String SerialByPre(Node head){
        if(head==null){
            return "#!";
        }
        String str = head.value+"!";
        str += SerialByPre(head.left);
        str += SerialByPre(head.right);
        return str;
    }

    //树的前序遍历实现树的反序列化
    public static Node reconByPreString(String str){
        String[] array = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i=0;i<array.length;i++){
            queue.offer(array[i]);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String str = queue.poll();
        if(str.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(str));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    public static void prePrint(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.value+">");
        prePrint(head.left);
        prePrint(head.right);
    }




    public static String SerialByLevel(Node head){
        if(head==null){
            return "#!";
        }
        String str = head.value+"!";
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            if(head.left!=null){
                str +=head.left.value+"!";
                queue.offer(head.left);
            }else{
                str +="#!";
            }
            if(head.right!=null){
                str +=head.right.value+"!";
                queue.offer(head.right);
            }else{
                str +="#!";
            }
        }
        return str;
    }



    public static Node reconByLevelString(String str){
        String[] array  = str.split("!");
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node head = generateByString(array[index++]);
        if(head!=null){
            queue.offer(head);
        }
        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateByString(array[index++]);
            node.right = generateByString(array[index++]);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return head;
    }
    public static Node generateByString(String str){
        if(str.equals("#")){
            return null;
        }
         return new Node(Integer.valueOf(str));
    }
}
