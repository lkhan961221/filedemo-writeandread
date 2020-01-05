package com.example.filedemocrud;

import java.io.*;

public class FileWRUtil {
    public static void WriteFile(String filePath,String str) throws IOException {
        WriteFile(new File(filePath),str);
    }

    public static void WriteFile(File file,String str) throws IOException {
        FileWriter fw = new FileWriter(file); //创建输出流对象
        fw.write(str);//向内存中写入一个字符串数据
        fw.flush(); //将数据从内存缓冲区写入文件
        fw.close(); //释放资源
    }

    public static void WriteFile(File file,String str,Boolean append) throws IOException {
        FileWriter fw = new FileWriter(file,append);
        fw.write(str);
        fw.flush();
        fw.close();
    }

    public static void WriteFile(String filePath,String str,Boolean append) throws IOException {
       WriteFile(new File(filePath),str,append);
    }

    public void FileWriterBuffer(FileWriter fw,String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str);
        bw.flush();
        bw.close();
    }

}
