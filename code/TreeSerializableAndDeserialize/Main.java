package com.hellojava.TreeSerializableAndDeserialize;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(12);
        head.left = new Node(3);
        head.right = new Node(9);
        head.left.left = null;
        head.left.right = new Node(19);
        head.right.left = new Node(18);
        head.right.right = null;

        String str = SerializableAndDeserialize.SerialByPre(head);
        System.out.println(str);
        Node node = SerializableAndDeserialize.reconByPreString(str);
        SerializableAndDeserialize.prePrint(node);
        System.out.println();

        String str2 = SerializableAndDeserialize.SerialByLevel(head);
        System.out.println(str2);
        Node node1 = SerializableAndDeserialize.reconByLevelString(str2);
        SerializableAndDeserialize.prePrint(node1);
        System.out.println();
    }
}
