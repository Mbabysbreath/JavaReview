package string1;

import org.junit.Test;

/**
 * String的使用
 * @author zhaomin
 * @date 2020/1/31 14:13
 */
public class StringTest {

    /**
     * String:字符串，使用一对""引起来
     * String声明为final的，不可被继承
     * 实现了Serializable接口：表示字符串是支持序列化的
     * 实现类Comparable接口：表示字符串可以比较大小
     * String内部定义类final char[] value用于存储字符串数据
     * String：代表不可变的字符序列。简称：不可变性
     * 体现：
     * （1）当对字符串重新赋值时，需要重写指定内存区域赋值【在常量池中重新创造】，不能使用原有的value进行赋值。
     * (2)当对现有字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有value赋值
     * (3)当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
     * 通过字面量（区别于new方式）的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中
     * 字符串常量池中是不会存储相同的字符串的
     *
     *
     * 面试题：
     * String s=new String("abc");方式在内存中创建了几个对象
     * 2个
     * 一个是堆空间中new结构，另一个是char[]对应的常量池中的数据“abc"
     */
    @Test
    public void test1(){
        String s1="abc";//字面量的定义方式--直接复制
        String s2="abc";
        s1="hello";
        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("*******************");
        String s3="abc";
        s1+="def";
        System.out.println(s3);
        System.out.println(s1);
        System.out.println("********************");
        String s4="abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }

    /**
     * String 的实例化方式：
     * 方式一：通过字面量定义的方式
     * 方式二：通过new+构造器的方式
     */
    @Test
    public void test2(){
        //此时的s1和s2的数据声明在方法区中的字符串常量池中
        String s1="javaEE";
        String s2="javaEE";
        //通过new+构造器的方式：s3和s4保存的地址值，
        // 是数据在堆空间中开辟空间以后对应的地址值
        String s3=new String("javaEE");
        String s4=new String("javaEE");

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1==s4);//false
        System.out.println(s3==s4);//false
        System.out.println("*******************");
        Person p1=new Person("Tom",12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name.equals(p2.name));

        p1.name="Jerry";
        System.out.println(p1.name);
        System.out.println(p2.name);
    }

    /**结论：
     * 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 在拼接时，只要其中有一个是变量，结果就在堆中
     * 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1="javaEE";
        String s2="hadoop";
        String s3="javaEEhadoop";
        String s4="javaEE"+"hadoop";
        String s5=s1+"hadoop";
        String s6="javaEE"+s2;
        String s7=s1+s2;
        String s8 = s5.intern();//返回值得到的s8使用的是常量池存在的javaEEhadoop

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3==s7);//f
        System.out.println(s5 == s6);//f
        System.out.println(s5==s7);//f
        System.out.println(s6==s7);//f
        System.out.println(s3==s8);//true
    }

    @Test
    public void test4(){
        String s1="javaEEhadoop";
        String s2="javaEE";
        String s3=s2+"hadoop";
        System.out.println(s1==s3);//false
        final String s4="javaEE";//常量
        String s5=s4+"hadoop";
        System.out.println(s1==s5);//true
    }

    public static int num(int[] arr, int k) {
        int count=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if (arr[i] + arr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
