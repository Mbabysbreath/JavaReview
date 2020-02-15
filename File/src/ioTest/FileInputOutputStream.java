package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/2/14 21:54
 * 测试FileInputStream和FileOutputStream的使用
 */
public class FileInputOutputStream {
    //用字节流对.txt文件进行复制
    @Test
    public void test(){
       // File file = new File("hello.txt");可省略
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("hello1.txt");
            byte[] buff=new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1) {
                String str=new String(buff,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //实现对图片的复制
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcfile = new File("1.jpg");
            File destfile = new File("2.jpg");
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buff=new byte[10];
            int len;
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void copFile(String src, String dest) {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcfile = new File(src);
            File destfile = new File(dest);
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buff=new byte[10];
            int len;
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        long start = System.currentTimeMillis();

        String srcPath = "D:\\比特书籍课件\\3.JavaWeb\\文件搜索.pdf";
        String destPath = "D:\\比特书籍课件\\3.JavaWeb\\文件搜索2.pdf";

        copFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间："+(end-start));
    }
}
