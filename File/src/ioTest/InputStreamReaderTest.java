package ioTest;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader---将一个字节的输入流转为字符的输入流
 * OutputStreamWriter--将字符的输出流转换为字节的输出流
 * 2.作用：
 * 提提供字节流与字符流之间的转换
 * 3.解码：字节、字节数组---》字符、字符数组InputStreamReader
 *   编码：字符、字符数组---》字节、字节数组OutputStreamWriter
 * 4.字符集
 * ASCII--美国标准信息交换码--用一个字节的7位可以表示
 * ISO8859-1--拉丁码表，欧洲码表
 * GB2312---中国的中文编码表，最多两个字节编码
 * GBK:--中国的中文编码表升级，融合更多的中文文字符号，最多两个字节编码
 * 区分两个字节连一块时，到底是分别代表一个字符，还是连一起代表一个字符：
 *  看每个字节的最高位，0--单独代表一个字符，
 *                   1--连起来代表一个字符
 * Unicode字符集（不是真正的编码方案）--国际标准码，融合了目前人类是哪个的所有字符，为每个字符分配唯一的字符码，所有的文字都用两个字节（16位）来表示
 *  问题：遇到和GBK一样的问题，但如果还是用最高位来判断，那就会造成可用数值减少（15位）
 * UTF-8:变长的编码方式，可用1-4个字节来表示一个字符
 *
 *
 *
 * @author zhaomin
 * @date 2020/2/16 9:51
 */
public class InputStreamReaderTest {
    @Test
    public void test() throws IOException {
        File file=new File("hello1.txt");
        FileInputStream fis=new FileInputStream(file);

        //参数二要指明文件使用的字符集，具体是有哪个要看问价保存时使用的字符集
        //如果不指定第二个参数，就默认用系统的字符集
        InputStreamReader is=new InputStreamReader(fis,"utf-8");
        //byte[] buff = new byte[10];
        char[] buff=new char[10];
        int len;
        while ((len = is.read(buff)) != -1) {
            String str = new String(buff, 0, len);
            System.out.print(str);
        }
        is.close();
    }

    /**
     * 综合使用InputStreamReader和OutputStreamWriter
     * 将utf-8的文件转为gbk的
     */
    @Test
    public void test2() throws IOException {
        //1，造文件、造流
        File file1 = new File("src\\简历-赵敏.pdf");
        File file2 = new File("简历-赵敏.doc");

        FileInputStream fis = new FileInputStream(file1);
        InputStreamReader is=new InputStreamReader(fis,"utf-8");
        //FileReader fr=new FileReader(file1);

        FileOutputStream fw=new FileOutputStream(file2);
        OutputStreamWriter os=new OutputStreamWriter(fw,"GB2312");
        //2.操作数据
        char[] buff=new char[1024];
        int len;
        while ((len = is.read(buff))!=-1) {
            os.write(buff,0,len);
            //System.out.println(Arrays.toString(buff));
        }
        //3.关闭资源
        os.close();
        is.close();
    }

}
