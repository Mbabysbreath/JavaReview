package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取，写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区 8192字节
 * @author zhaomin
 * @date 2020/2/15 11:40
 */
public class BufferedTest {
    /**
     * 实现非文本文件的复制
     */
    @Test
    public void bufferedTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File src=new File("1.jpg");
            File dest = new File("3.jpg");
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
               // bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源，先关闭外层的流，再关闭内存的流
            //关闭外层流的同时，内层流也会自定关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现文本文件的复制
     *
     */
    @Test
    public void bufferTest2(){
        BufferedReader bfr = null;
        BufferedWriter bwr = null;
        try {
            File src = new File("hello1.txt");
            File dest = new File("hello2.txt");

            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(dest);

            bfr = new BufferedReader(fr);
            bwr = new BufferedWriter(fw);
               /*第一种读取数据的方式*/
//            char[] buff=new char[10];
//            int len;
//            while((len=bfr.read(buff))!=-1){
//                bwr.write(buff, 0, len);
//            }
            /*第二种String:readLine()一次读取一行，默认不读取换行*/
            String data;
            while ((data = bfr.readLine()) != null) {
               // 第一种方法：readLine()不加换行
                //bwr.write(data);
                //第二种：手动加换行
                //bwr.write(data+'\n');
                //第二种方法：newLine()加换行
                bwr.write(data);
                bwr.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bwr != null) {
                try {
                    bwr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bfr != null) {

                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //实现文件复制的方法
    public void copyFileBuffered(String src, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcPath=new File(src);
            File destPath = new File(dest);
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                // bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源，先关闭外层的流，再关闭内存的流
            //关闭外层流的同时，内层流也会自定关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start=System.currentTimeMillis();

        String srcPath = "D:\\比特书籍课件\\3.JavaWeb\\文件搜索.pdf";
        String destPath = "D:\\比特书籍课件\\3.JavaWeb\\文件搜索1.pdf";
        copyFileBuffered(srcPath, destPath);

        long end=System.currentTimeMillis();
        System.out.println("复制操作花费时间："+(end-start));
    }
}
