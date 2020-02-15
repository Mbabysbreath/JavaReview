package ioTest;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * 一、流的分类
 1.按照数据单位分类---字节流、字符流
 2.按照数据流的流向---输入流、输出流
 3.按流的角色划分-----节点流、处理流
 * 二、流的体系结构
 * 抽象基类          节点流（或文件流）                              缓冲流（处理流的一种）
  InputStream       FileInputStream(read(bye[] buff))            BufferedInputSteram(read(bye[] buff))
  OutputStream      FileOutputStream(write(byte[] buf,0,len))    BufferedOutputStream(write(byte[] buf,0,len))
  Reader            FileReader (read(char[] buff))               BufferedReader (read(char[] buff)/readLine())
  Writer            FileWriter (write(char[] buf,0,len))          BufferedWriter (write(char[] buf,0,len))

 * @author zhaomin
 * @date 2020/2/13 18:00
 */
public class FileReaderWriterTest {
    public static void main(String[] args) throws IOException {
        File file = new File("File\\hello.txt");
        FileReader fr=new FileReader(file);
        int data=fr.read();
        while (data != -1) {
            System.out.print((char) data);
            data=fr.read();
        }
        int i=65;
        char c=(char)i;
        System.out.println(9);
        System.out.println(c);
    }
    /*将File模块下的hello.txt文件内容读到程序中，并输出到控制台*/
    //说明：
    //1.read()方法：返回读入的一个字符的整型（int）a--97，如果达到文件末尾，返回-1
    //2.为了保证资源一定可以关闭，使用try-catch-finally来处理
    //3.读入的文件一定要存在，否则就会报FileNotFoundException
    @Test
    public void test(){
        FileReader fr= null;
        try {
            //1.创建一个File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read()方法：返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while((data=fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if(fr!=null){

                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    //read(char[] buf)---返回每次读取到的字符数
    @Test
    public void testFileReader1(){
        FileReader fr= null;
        try {
            //1.创建一个File对象，指明要操作的文件
            File file=new File("hello.txt");
            //2.要创建具体的流，流的实例化
            fr = new FileReader(file);
            //3.读入数据操作:方式一
            char[] buf=new char[5];
            int len;
            while((len=fr.read(buf))!=-1){
               /* for(int i=0;i<len;i++) {
                    System.out.print(buf[i]);
                }*/
                //3.读入数据操作:方式二
                String str=new String(buf,0,len);
                System.out.print(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*从内存中写出数据到硬盘文件里
     * 1.在创建File对象时，如果没有当前对象，流就会给我们创建一个对象
     * 2.如果FileReader(fw,false)/(fw)----对原有文件内容进行覆盖
     *   如果FileReader(fw,true)      ----对原有文件内容进行追加
     *    */
    @Test
    public void testFileWriter() {

        FileWriter fw = null;
        try {
            //1.先创建一个File类的对象，指明要写出的文件
            File file = new File("hello1.txt");
            //2.提供具体的流，FileWriter
          //  fw = new FileWriter(file,false);
            fw = new FileWriter(file,true);
            //3.进行数据的写出
            fw.write("你好\n");
            fw.write("王哟博");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    对文件进行复制。先读进来，再进行写出
    1.字符流只能对文本文件进行操作，对于图片这种字节型的文件，就要字节流来处理
    //下次--P12--FileInputStream
     */
    @Test
    public void fileReadWrite(){
        FileReader fr = null;
        FileWriter fw= null;
        try {
            //1.创建源文件和目标文件
//            File srcFile=new File("hello.txt");
//            File decFile=new File("hello1.txt");
            File srcFile=new File("D:\\比特书籍课件\\3.JavaWeb\\文件搜索项目文档.pdf");
            File decFile=new File("hello1.pdf");
            //2.提供具体的流
            fr = new FileReader(srcFile);
            fw = new FileWriter(decFile,true);

            //3.对数据进行操作
            char[] buff=new char[5];
            int len;
            while((len=fr.read(buff))!=-1){
//                String str=new String(buff,0,len);
//                fw.write(str);
                fw.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
