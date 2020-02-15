package file1;

import org.junit.Test;

import java.io.File;

/**
 * 1.File类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 * 并未涉及到写入或读取文件内容的操作，如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 * @author ZhaoMin
 * @date 2019/12/12 11:32
 */
public class FileTest {
    /*
   1. 如何创建File类的实例---此时不会真正创建文件，内存层面的对象，不是硬盘上的真正的文件
        File(String filePath)
        File(String parent,String child)//指明上一层目录，和即将创建的文件或目录
        File(File parent,String child)//在文件类型下
   2.相对路径：相较于某个路径下，指明的路径
      绝对路径：包含盘符在内的文件或文件目录

   3.路径分隔符
    windows和DOS:\\
    unix:/
     */
    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module(如果是Junit())/项目(如果是main()
        System.out.println(file1);

        //构造器2 D:\Java_HP\test1
        File file2=new File("D:\\Java_HP","test1");//test1文件夹的上一层目录是D:\Java_HP
        System.out.println(file2);

        //构造器3 D:\Java_HP\test1\hi.txt
        File file3=new File(file2,"hi.txt");//hi.txt文件在fiel2的目录下即test1
        System.out.println(file3);
    }

}
