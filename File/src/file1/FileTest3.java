package file1;

import org.junit.Test;

import java.io.File;

/**
 * （三）判断的一些方法---在硬盘层面上判断，不是内存上的简单定义
 * public boolean isDirectory()---判断是否是文件目录
 * public boolean isFile()--------判断是否是文件
 * public boolean exists()--------判断是否存在
 * public boolean canRead()-------判断是否可读
 * public boolean canWrite()------判断是否可写
 * public boolean isHidden()------判断是否隐藏
 * @author zhaomin
 * @date 2020/2/12 19:32
 */
public class FileTest3 {
    @Test
    public void test(){
        File file=new File("hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println("++++++++++++++++++++++");
        File file2=new File("D:\\GitHub mine\\JavaReview\\File");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }
}
