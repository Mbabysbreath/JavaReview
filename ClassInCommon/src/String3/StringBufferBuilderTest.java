package String3;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 * @author zhaomin
 * @date 2020/2/1 23:46
 */
public class StringBufferBuilderTest {
    /**
     * String\StringBuffer\StringBuilder的区别
     * String:不可变的字符序列，底层结构使用char[]
     * StringBuffer:可变的字符序列，线程安全，效率低，底层结构使用char[]
     * StringBuilder:可变的字符序列：jdk5.0新增，线程不安全，效率高，底层结构使用char[]
     *
     * 源码分析：
     * String str=new String();//char[] value=new char[0];
     * String str1=new String("abc");//char[] value=new char[]{'a','b','c'}
     *
     * StringBuffer sb1=new StringBuffer();//char[] value=new char[16];底层创建一个长度是16的数组
     * sb1.append('a');//value[0]='a';
     * sb1.append('b');//value[1]='b';
     *
     * StringBuffer sb2=new StringBuffer("abc");//char[] value=new char["abc".length()+16]
     *
     * 问题1：sout(sb2.length());//返回的是数组中实际存储的长度，不是真实长度
     * 问题2：扩容问题：如果要添加的数据底层数组盛不下了，就需要扩容底层的数组
     *       默认情况下，扩容为原来容量的2倍+2，同时将原有的数组元素复制到新的数组中
     *
     * 指导意义：在实际开发中要尽量避免扩容，因为还要进行数组复制
     *         所以建议使用StringBuffer(int capacity)或StringBuilder(int capacity)的构造器，
     *         提前指定容量，提高效率
     * */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        System.out.println(sb1.length());
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }

    /**
     *StringBuffer append(xxx):提供了很多的append()方法，用于进行字符串的拼接,可扩容
     *StringBuffer delete(int start,int end);删除指定位置的内容
     *StringBuffer replace(int start,int end,String str);把[start,end)位置替换为str可扩容
     *StringBuffer insert(int offset,xxx):在指定位置插入xxx
     *StringBuffer reverse();把当前字符序列逆转
     *
     *public int indexOf(String str)
     *
     *返回一个从start开始到end索引结束的左闭右开区间的子字符串
     *public String substring(int start,int end)
     *public int length()
     *public char charAt(int n)
     *public void setCharAt(int n,char ch)//将指定位置的字符改为ch
     *
     *
     * 总结：
     * 增：append(xxx)
     * 删：delete(int start,int end)
     * 改：setCharAt(int n,char ch)/replace(int start,int end,String str)
     * 查：charAt(int n)/indexOf(String str)/lastIndexOf(String str)
     * 插：insert(int offset,xxx)
     * 长度：length()
     * 遍历：for()+charAt()/toString()
     */
    @Test
    public void test2(){
        StringBuffer s1=new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        System.out.println(s1);

        s1.delete(2,4);//左闭右开
        System.out.println(s1);

        s1.replace(2,4,"hello");//左闭右开
        System.out.println(s1);

        s1.insert(2,false);
        System.out.println(s1);
        System.out.println(s1.length());

        s1.reverse();
        System.out.println(s1);

        String s2=s1.substring(1,3);
        System.out.println(s1);
        System.out.println(s2);

        int n = s1.indexOf("ll");
        System.out.println(n);
    }

    /**
     * 对比String\StringBuffer\StringBuilder三者的效率
     * 从高到低排列：StringBuilder>StringBuffer>String
     */
    @Test
    public void test3(){
        //初识设置
        long startTime=0L;
        long endTime=0L;
        String text="";
        StringBuffer buffer=new StringBuffer("");
        StringBuilder builder=new StringBuilder("");
        //开始对比
        startTime=System.currentTimeMillis();
        for(int i =0;i<20000;i++) {
            buffer.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime=System.currentTimeMillis();
        for(int i =0;i<20000;i++) {
            builder.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime=System.currentTimeMillis();
        for(int i =0;i<20000;i++) {
            text=text+i;
        }
        endTime=System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
    }
}
