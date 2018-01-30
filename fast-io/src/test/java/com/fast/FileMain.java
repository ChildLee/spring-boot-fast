package com.fast;

import org.junit.Test;

import java.io.*;


public class FileMain {

    @Test
    public void outputStream() throws IOException {
        //写入数据
        File file = new File("D:/a.txt");
        String data = "我跟你说个锤子!";
        //定义字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);//true表示追加数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);//字节输出流缓存
        bufferedOutputStream.write(data.getBytes());
        bufferedOutputStream.flush();
//        bufferedOutputStream.close();
        //字节转字符
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);//字符输入流缓存
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();
        //定义字符输出流
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter buffered = new BufferedWriter(fileWriter);//字符输入流缓存
        buffered.write(data);
        buffered.flush();
        buffered.close();


    }

    @Test
    public void inputStream() throws IOException {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 99999; i++) {
            //读取数据
            File file = new File("D:/a.txt");
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[8192];
            int flag = 0;
            StringBuilder sb = new StringBuilder();
            while ((flag = bufferedInputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, flag));
            }
        }
        System.out.println(System.currentTimeMillis() - a);
//        System.out.println(sb);
    }

    @Test
    public void inputStreamReader() throws IOException {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 99999; i++) {
            File file = new File("D:/a.txt");
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder sb = new StringBuilder();
            while (null != (line = bufferedReader.readLine())) {
                sb.append(line);
            }
            bufferedReader.close();
        }
        System.out.println(System.currentTimeMillis() - a);
//        System.out.println(sb);
    }

    @Test
    public void fileReader() throws IOException {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 99999; i++) {
            File file = new File("D:/a.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringBuilder sb = new StringBuilder();
            while (null != (line = bufferedReader.readLine())) {
                sb.append(line);
            }
            bufferedReader.close();
        }
        System.out.println(System.currentTimeMillis() - a);
//        System.out.println(sb);
    }

    @Test
    public void byteArrayInputStream() throws IOException {
        File file = new File("D:/a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[8192];
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while ((flag = fileInputStream.read(bytes)) != -1) {
            outStream.write(bytes);
        }
        byte[] data = outStream.toByteArray(); // 取内存中保存的数据
        String result = new String(data, "UTF-8");
        System.out.println(result);
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

