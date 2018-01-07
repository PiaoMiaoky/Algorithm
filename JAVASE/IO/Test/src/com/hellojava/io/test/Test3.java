package com.hellojava.io.test;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙及目录|文件的名称
 * 1.listFiles()
 * 2.递归
 * static listRoots() 根路径
 *
 */
public class Test3 {
    public static void main(String[] args) {
        String path = "F:/TestFile";
        File parent = new File(path);
        //printName(parent);

        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
        for(File temp:roots){
            printName(temp);
        }
    }
    /**
     * 输出路径
     */
    public static void printName(File src){
        if(null==src||!src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());
        if(src.isDirectory()){
            for(File sub:src.listFiles()){
                printName(sub);
            }
        }
    }
}
