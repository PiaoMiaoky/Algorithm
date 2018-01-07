package com.hellojava.io.test;

import java.io.File;
import java.io.IOException;

public class Test01 {
    //判断信息
    public static void test2(){
        //String path="111.txt";
        //String path="F:/picutre/123/111.txt";
        String path="F:/picutre/123/111.txt";
        File src = new File(path);
        //是否存在
        System.out.println("文件是否存在:"+src.exists());
        //是否可读可写 canWrite() canRead()
        System.out.println("文件是否可写"+src.canWrite());

        //isFile()
        //isDirectory()
        if(src.isFile()){
            System.out.println("文件");
        }else{
            System.out.println("文件夹");
        }

        System.out.println("是否为绝对路径:"+src.isAbsolute());
        //只可读取文件的字节数，不能就返回文件夹的字节数
        System.out.println("长度:"+src.length());
    }


    public static void test3() throws IOException{
        //creatNewFile() 不存在的创建新文件
        String path="F:/picutre/123/20.jpg";
        File src = new File(path);
        if(!src.exists()){
            boolean flag = src.createNewFile();
            System.out.println(flag?"创建成功":"失败");
        }
    }

    public static void test1(){
        File src = new File("F:/hellojava/2.txt");
        //返回名称
        System.out.println(src.getName());
        //相对返回相对，绝对返回绝对
        System.out.println(src.getPath());
        //返回绝对路径
        System.out.println(src.getAbsolutePath());
        //返回上一级目录，如果是相对，返回空
        System.out.println(src.getParent());
    }
    public static void main(String[] args) {
        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件操作失败");
        }
    }
}
