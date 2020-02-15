package file1;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用：常用方法
 * （二）File类的重命名功能:
 * ----使用前提：file1的文件真实存在，file2指明的文件路径及名称不存在
 * public boolan renameTo(File dest):把文件重命名为指定的文件路径
 * 比如：file1.renameTo(fiel2)为例：
 *
 * @author ZhaoMin
 * @date 2019/12/12 13:28
 */
public class FileTest2 {
    @Test
    public void test1(){
        File file1=new File("hello.txt");
        File file2=new File("D:\\GitHub mine\\JavaReview\\hi.txt");
        boolean renameTo=file1.renameTo(file2);
        System.out.println(renameTo);
    }
}
