package string2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/2/1 19:41
 */
public class StringMethodTest {
    /**
     * int length()——return value .length
     * char charAt(int index)——返回某索引处的字符return value[index]
     * boolean isEmpty():——判断是否是空字符串：return value.length=0;
     * String toLowerCase():——String字符转为小写
     * String toUpperCase():——strin字符转为大写
     * String trim():返回字符串的副本，忽略前边和尾部的空白
     * boolean equals(Object obj):比较字符串的内容是否相同
     * boolean equalsIgnoreCase(String anotherString):与equals`方法类似，忽略大小写
     * String concat(String str):将指定字符串连接到此字符串的结尾。---》等价于用“+”
     * int compareTo(String str):比较两个字符串的大小，涉及到字符串排序
     * 左闭右开
     * String substring(int beginIndex)：返回一个新的字符串，它是从此字符串的从beginIndex开始截取到最后一个子字符串
     * String substring(int beginIndex,int endIndex):返回一个新的字符串，它是此字符串从beginINdex开始截取到endIndex(不包含)的的一个字符串
     */
    @Test
    public void test1() {
        String s1 = "helloWorld";
        System.out.println(s1.length());//9
        System.out.println(s1.charAt(0));//h
        System.out.println(s1.charAt(9));//d
        // System.out.println(s1.charAt(10));//字符串下标越界异常

        String s2 = "";
        String s3 = new String();
        String s4 = new String("HelloWORLD");
        String s5 = s2;
        System.out.println(s2.isEmpty());//t
        System.out.println(s3.isEmpty());//t
        System.out.println(s5.isEmpty());//t
        System.out.println(s1.equals(s2));//f
        System.out.println(s1.equalsIgnoreCase(s4));//t
        System.out.println(s1.toUpperCase());//大写
        System.out.println(s1);
        System.out.println(s4.toLowerCase());//小写

        String s6 = "   A  BC    ";
        String s7 = s6.trim();
        System.out.println("----" + s6 + "-----");
        System.out.println("----" + s7 + "-----");

        String s8 = "ZhaoMin";
        String s9 = s8.concat("&&WangYiBo");
        System.out.println(s8);
        System.out.println(s9);

        String s10 = new String("WangYiBo");
        //涉及到字符串排序
        System.out.println(s9.compareTo(s10));//3 Z-W

        System.out.println(s8.substring(4));
        System.out.println(s8.substring(4, 7));
    }

    /**
     * boolean endsEith(String suffix):测试此字符串是否以指定的后缀结束
     * boolean startWith(String prefix):测试此字符串是否以指定的前缀开始
     * boolean startWith(String prefix,int offset):测试此字符串从指定索引开始,是否是以指定字符串开始
     */
    @Test
    public void test2() {
        String s1 = "helloWorld";
        boolean b1 = s1.endsWith("rld");
        System.out.println(b1);
        boolean b2 = s1.startsWith("He");
        System.out.println(b2);
        System.out.println(s1.startsWith("ll", 2));
    }

    /**
     * boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列，返回true
     *int indexOf(String str):返回指定子字符串在此字符串中第一次出现的索引
     *int indexOf(String str,int fromIndex):返回指定子字符串从指定位置开始在此字符串中第一次出现的索引
     *int lastIndexOf(String str);返回指定字符串在此字符串中最后一次出现时的索引
     *int lastIndexOf(String str,int fromIndex);返回指定子字符串在此字符串中最后一次出现的索引，从指定索引向前搜索
     */
    @Test
    public void test3(){
        String s1="helloWorld";
        System.out.println(s1.contains("rl"));
        System.out.println(s1.indexOf("ll"));
        System.out.println(s1.indexOf("l",3));
        System.out.println(s1.lastIndexOf("lo"));
        System.out.println(s1.lastIndexOf("ll",5));
    }

    /**
     * 替换：
     * String replace(char oldChar,char newChar);返回一个新的字符串，它是通过newChar替换了全部oldChar
     *String replace(CharSequence target,CharSequence replacement);使用指定的字面值替换序列替换此字符串中所有匹配的字面值目标序列的子字符串
     *String replaceAll(String regex,String replacement);使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
     *String replaceFirst(String regex,String replacement);使用给定的replacement替换字符串匹配给定给定的正则表达式的第一个子字符串
     * 匹配：
     * boolean matches(String regex);告知此字符串是否匹配给定的正则表达式
     */
    @Test
    public void test4(){
        String s1="我要好好活着，我要见到你";
        String s2 = s1.replace('我', '你');
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.replace("我要", "我们要");
        System.out.println(s3);
        //正则匹配
        String s4="0571-12345678";
        //判断str字符串中是否全部是数字组成，即有1--n个数字组成
        boolean matches=s4.matches("\\d+");//表示数字
        System.out.println(matches);
        //判断这是否是一个杭州的固定电话
        boolean res=s4.matches("0571-\\d{7,8}");//表示前缀为0571-，后边有7-8位数字，左闭右闭
        System.out.println(res);
    }

    /**
     * String[] split(String regex);根据给定正则表达式的匹配拆分此字符串
     * String[] spilt(String regex,int limit);根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个；
     * 如果超过了，剩下的全部都放到最后一个元素中
     */
    @Test
    public void test5(){
        //正则表达式
        String s1="abc|def|ghttt";
        String[] str=s1.split("\\|");
        System.out.println(Arrays.toString(str));
    }
}
