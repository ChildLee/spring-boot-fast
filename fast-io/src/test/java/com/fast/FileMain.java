package com.fast;

import org.junit.Test;

import java.io.*;


public class FileMain {
    @Test
    public void inputStream() throws IOException {
        File file = new File("D:/a.txt");
        InputStream inputStream = new FileInputStream(file);
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder sb = new StringBuilder();
        while (null != (line = bufferedReader.readLine())) {
            sb.append(line);
        }
        bufferedReader.close();
        System.out.println(sb);
    }

    @Test
    public void fileReader() throws IOException {
        //FileReader构造函数默认实例化FileInputStream字节流
        FileReader fileReader = new FileReader("D:/a.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        StringBuilder sb = new StringBuilder();
        while (null != (line = reader.readLine())) {
            sb.append(line);
        }
        reader.close();
        System.out.println(sb);
    }

    @Test
    public void fileTest() {
        //创建FIle实例,表示文件对象
        File file = new File("D:/verifies/text.txt");
        File file1 = new File("D:/verifies/", "text.txt");
        File file2 = new File("D:/verifies/");
        File file3 = new File(file2, "text.txt");
        //相对路径
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

