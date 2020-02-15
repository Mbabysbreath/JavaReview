package file1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhaomin
 * @date 2020/2/12 20:55
 */
public class Exer {
    @Test
    public void test() throws IOException {
        File file=new File("D:\\GitHub mine\\JavaReview\\File\\file1");
        File file1=new File(file.getParent(),"file2");
        file1.mkdirs();
        File file3=new File(file1,"file4.txt");
        boolean res=file3.createNewFile();
        if (res) {
            System.out.println("file4.txt创建成功");
        }
    }
    //判断指定目录下是否有后缀为.txt的文件，如果有就输出该文件的名称
    @Test
    public void test1(){
        File file=new File("D:\\GitHub mine\\JavaReview");
        String[] list = file.list();
        for (String str : list) {
            if(str.endsWith(".txt")){
                System.out.println(str);
            }
        }
    }

    //输出文件指定路径下所有的文件及子文件，不包括目录
    public void printSubFile(File file){

        File[] files = file.listFiles();
        for(File f:files){
            if (f.isDirectory()) {
                printSubFile(f);
            }else{
                System.out.println(f.getAbsoluteFile());
            }
        }
    }

    public static void main(String[] args) {
        Exer e=new Exer();
        File file=new File("D:\\GitHub mine\\JavaReview");
        e.printSubFile(file);
    }
}

