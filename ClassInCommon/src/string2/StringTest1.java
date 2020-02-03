package string2;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 * @author zhaomin
 * @date 2020/2/1 22:48
 */
public class StringTest1 {
    /**
     * String 与基本数据类型、包装类之间的转换
     * （1）String--》基本数据类型、包装类
     *     调用包装类的静态方法Integer.parseXXX(str);
     * (2)基本数据类型、包装类--》String：
     *     调用String重载的valueOf(XXX);
     */
    @Test
    public void test1(){
        String s1="123";
        int num=Integer.parseInt(s1);
        int num1=Integer.valueOf(s1);
        String s2=String.valueOf(num);
        String s3=num+"";
        System.out.println(s2);
        System.out.println(s3);
    }

    /**
     * String 与char[]之间的转换
     * (1)String-->char[]:
     *    调用String的toCharArray()
     * (2)char[]-->String:
     *    调用String的构造器
     */
    @Test
    public void test2(){
        String s1="abc123";
        char[] ch=s1.toCharArray();
        System.out.println(Arrays.toString(ch));
        char[] ch2=new char[]{'h','e','l','l','o'};
        String s2=new String(ch2);
        System.out.println(s2);
        //将abc123--转为a21cb3
    }

    /**
     * String 与byte[]之间的转换
     * 编码：String-->byte[]:
     *   (1)调用String的getBytes()
     * 解码：byte[]-->String
     *    调用String的构造器
     * 说明：解码时，要求解码使用的字符集必须与编码使用的字符集一致
     *      否则会出现乱码
     *
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1="abc123中国";
        byte[] b1=s1.getBytes();//使用默认的字符集进行转换utf-8,三个字节一个汉字
        System.out.println(Arrays.toString(b1));
        String s2="abc123中国";
        byte[] b2 = s2.getBytes("gbk");
        //使用gbk字符集进行编码2个字节一个汉字
        System.out.println(Arrays.toString(b2));

        String s3=new String(b1);//使用默认字符集进行解码
        System.out.println(s3);

        String s4=new String(b2);//解码集和编码集不同，会出现乱码
        System.out.println(s4);
        String s5 = new String(b2, "gbk");//使用指定的解码集
        System.out.println(s5);
    }
}
