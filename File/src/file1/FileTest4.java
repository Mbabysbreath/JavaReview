package file1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (四)真正在硬盘上创建的方法和删除的方法
 * @author zhaomin
 * @date 2020/2/12 19:45
 */
public class FileTest4 {
    /**
     * 创建文件或目录的方法
     * public boolean createNewFile():创建文件，若文件已经存在，则不创建，返回false
     * public boolean mkdir();创建文件目录，如果此文件目录已经存在，就不创建了
     *                        如果此文件目录的上层不存在，则不创建
     * public boolean mkdirs():创建文件目录，如果上层目录不存在，一并创建
     *
     * 删除磁盘中的文件或文件目录
     * public boolean delete():删除文件或文件夹
     * 注意：删除目录时，目录下不能有文件
     * 注意事项：java中的删除不走回收站
     */
    @Test
    public void test() throws IOException {
        /*文件的创建*/
        File file = new File("java.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功");
        }else{
            System.out.println("文件已存在");
            file.delete();
            System.out.println("文件删除成功");
        }
    }
    @Test
    public void test1(){
        /*文件目录的创建*/
        File file=new File("D:\\GitHub mine\\JavaReview\\File\\dir");
        boolean dir=file.mkdir();
        if (dir) {
            System.out.println("目录创建成功");
        }
        //file.delete();
        File file1 = new File("D:\\GitHub mine\\JavaReview\\FFile\\file1");
        boolean res=file1.mkdirs();
        if (res) {
            System.out.println("目录及上层创建成功");

        }
        file1.delete();
        if (file1.exists()) {
            System.out.println("shibai");
        }
    }


}
