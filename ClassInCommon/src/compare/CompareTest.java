package compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：
 * Java中对象之间，正常情况下只能比较==或！=，不能进行> <的比较
 * 但是，在实际开发中，需要对多个对象进行排序，就是需要比较对象的大小
 * 如何实现：
 * 使用Comparable或Comparator两个接口中的任何一个
 *
 * 二、Comparable接口与Comparator接口的区别
 * Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小--永久
 * Comaprator接口属于临时性的比较
 *
 *
 * @author zhaomin
 * @date 2020/2/4 12:02
 */
public class CompareTest {

    /**
     * Comparable接口的使用举例：自然排序
     * 1、像String、包装类等都实现了Comaparable接口，重写了ComareTo(obj)方法，比较两个对象的方法
     * 2、像String、包装类重写compareTo（）方法以后，进行从小到大的顺序进行排列
     * 3、重写CompareTo(obj)的规则：
     * 如果当前对象this大于形参对象obj,返回正整数
     * 如果当前对象this小于形参对象obj,返回负整数
     * 如果当前对象this等于形参对象obj,返回0
     * 4、对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，
     * 重写compareTo()，在该方法中指明如何排序
     */
    @Test
    public void test(){
        String[] arr=new String[]{"AA","VV","DD","MM","GG"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test1(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("HP",33);
        arr[1]=new Goods("HuaWei",35);
        arr[2]=new Goods("Dell",30);
        arr[3] = new Goods("Lenovo", 33);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparator接口的使用————定制排序
     * 1.背景：
     * 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     * 或者实现类java.lang.Comparable接口的排序规则不适合当前的操作，
     * 那么可以考虑使用Comparator的对象来排序
     * 2.重写compare(Object o1,Object o2),比较o1和o2
     * 如果方法返回正整数，则表示o1>o2
     * 如果方法返回负整数，则表示o1<o2
     * 如果方法返回0，则表示o1=o2
     *
     */
    @Test
    public void test2(){
        String[] arr={"AA","MM","PP","BB","LL"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String&&o2 instanceof String){
                    String s1=(String)o1;
                    String s2=(String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("HP",33);
        arr[1]=new Goods("HuaWei",35);
        arr[2]=new Goods("Dell",30);
        arr[3] = new Goods("Lenovo", 33);
        arr[4] = new Goods("Lenovo", 45);
        //先按照名称从低到高，再按照价格从高到低
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods&&o2 instanceof Goods){
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}