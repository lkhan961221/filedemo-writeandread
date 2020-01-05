package com.example.filedemocrud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@SpringBootTest
public class FileTest {

    @Test
    void testGetName(){
        File file1=new File("D:\\test\\file");
        File file2=new File("D:\\test\\file\\001.txt");
        System.out.println(file1.getName());
        System.out.println(file2.getName());
    }

    @Test
    void testGetParent(){
        File file1=new File("D:\\test\\file");
        File file2=new File("D:\\test\\file\\001.txt");
        System.out.println(file1.getParent());
        System.out.println(file2.getParent());
    }

    @Test
    void testGetParentFile(){
        File file1=new File("D:\\test\\file");
        File file2=new File("D:\\test\\file\\001.txt");
        File parentFile1 = file1.getParentFile();
        System.out.println(parentFile1.getAbsolutePath());
        File parentFile2 = file2.getParentFile();
        System.out.println(parentFile2.getAbsolutePath());

    }

    @Test
    void testGetAbsolutePath(){
        File file1=new File("D:\\test\\file");
        File file2=new File("D:\\test\\file\\001.txt");
        File file3=new File("..\\file\\001.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file3.getAbsolutePath());
    }

    @Test
    void testDiffPathAndAbsolutePath(){
        File file1=new File("..\\file\\001.txt");
        File file2=new File("D:\\test\\file");
        System.out.println("-----默认相对路径：取得路径不同------");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println("-----默认绝对路径:取得路径相同------");
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
    }

    @Test
    void testIsAbsolute(){
        File file1=new File("..\\file\\001.txt");
        File file2=new File("D:\\test\\file");
        System.out.println(file1.isAbsolute());
        System.out.println(file2.isAbsolute());
    }

    @Test
    void testLastModified(){
        File file=new File("D:\\test\\file\\001.txt");
        long lastModified = file.lastModified();
        System.out.println(lastModified);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(lastModified));
    }

    @Test
    void testCreateTempFile() throws IOException {
        File tempFile1 = File.createTempFile("test1", "html", new File("D:\\test\\file"));
        File tempFile2= File.createTempFile("test2", "html");
        System.out.println(tempFile1.getAbsolutePath());
        System.out.println(tempFile2.getAbsolutePath());
    }
    @Test
    void testCreateNewFil() throws IOException {
        File file1 = new File("d:\\test\\file\\001.txt");
        File file2 = new File("d:\\test\\file\\001.html");
        File file3 = new File("d:\\test\\file\\t\\001.txt");
        System.out.println( file1.createNewFile());
        System.out.println( file2.createNewFile());
        System.out.println( file3.createNewFile());
    }

    @Test
    void testMkdir(){
        File file1 = new File("d:\\test\\file");
        File file2 = new File("d:\\test\\file\\test");
        File file3 = new File("d:\\test\\file\\test2\\t");
        File file4 = new File("d:\\test\\file\\test2\\t\\21");
        System.out.println(file1.mkdir());
        System.out.println(file2.mkdir());
        System.out.println(file3.mkdir());
        System.out.println(file4.mkdirs());
    }

    @Test
    void testDelete() throws IOException {
        File file1 = new File("d:\\test\\file\\001.txt");
        File file2 = new File("d:\\test\\file\\001.html");
        checkFileExist(file1);
        checkFileExist(file2);
        System.out.println("执行了file1.delete()");
        file1.delete();
        checkFileExist(file1);
        System.out.println("执行了 file2.deleteOnExit();");
        file2.deleteOnExit();
        checkFileExist(file2);
    }

    private void checkFileExist(File file){
        if (file.exists())
            System.out.println(file.getName()+"存在");
        else
            System.out.println(file.getName()+"不存在");
    }
}
