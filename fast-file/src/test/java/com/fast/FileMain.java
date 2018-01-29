package com.fast;

import org.junit.Test;

import java.io.File;


public class FileMain {

    @Test
    public void Test1() {
        //创建FIle实例,
        File file = new File("D:/verifies/text.txt");
        File file1 = new File("D:/verifies/", "text.txt");
        File file2 = new File("D:/verifies/");
        File file3 = new File(file2, "text.txt");
        File file4 = new File("/a");
        File file5 = new File("a");
        //返回完整路径
        System.out.println(file.toString());        //D:\verifies\text.txt
        //返回完整路径
        System.out.println(file.getPath());         //D:\verifies\text.txt
        //返回当前文件(夹)名
        System.out.println(file.getName());         //text.txt
        //父级目录的字符串
        System.out.println(file.getParent());       //D:\verifies
        //父级目录的File实例
        System.out.println(file.getParentFile());   //D:\verifies
        //测试此抽象路径名是否为绝对路径名。
        System.out.println(file.isAbsolute());      //true
        System.out.println(file4.isAbsolute());     //false
        //返回抽象路径名的绝对路径名字符串。
        System.out.println(file4.getAbsolutePath());//D:\a
        System.out.println(file5.getAbsolutePath());//D:\WorkSpace\Backstage\spring-boot-fast\fast-file\a
    }
}

