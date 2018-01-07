package com.hellojava.io.test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 操作目录
 * mkdir()  创建目录,不许确保父目录存在，如果不存在，创建失败
 * mkdirs() 创建目录，如果父目录链不存在时一同创建
 * list() 文件:目录字符串形式
 * listFiles()
 *
 */
public class Test02 {
    public static void test1(){
        //String path1 = "F:/TestFile/book1/test";
        String path2 = "F:/TestFile/book2/test/user1";
        //File src = new File(path1);
        File src = new File(path2);
        src.mkdirs();
        //src.mkdir();
    }
    public static void main(String[] args) {
        String path="F:/TestFile/book1";
        File src = new File(path);//文件夹
        if(src.isDirectory()){
            System.out.println("======子目录|文件名===");
            String[] subName = src.list();
            for(String temp:subName){
                System.out.print(temp+"  ");
            }
            System.out.println();
            System.out.println("======子目录|文件File对象=========");
            File[] subFiles = src.listFiles();
            for(File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }

            System.out.println("======子文件.java对象=========");
            //命令设计模式
            subFiles = src.listFiles(new FilenameFilter() {
                @Override
                /**
                 * dir 代表src
                 */
                public boolean accept(File dir, String name) {
                    System.out.println(dir.getAbsolutePath());
                    //过滤出是文件并且以.java结尾
                    return new File(dir,name).isFile()&&name.endsWith(".java");
                }
            });
            for(File temp:subFiles){
                System.out.println(temp.getAbsolutePath());
            }
        }



    }
}
