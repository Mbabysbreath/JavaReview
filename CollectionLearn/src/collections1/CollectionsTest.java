package collections1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类是用来操作Collection和Map的工具类
 * 面试题：Collection和Collections的区别
 * @author zhaomin
 * @date 2020/2/9 14:47
 */
public class CollectionsTest  {
    /**
     * reverse(List list);反转List中元素的顺序
     * shuffle(List list）；对List集合元素进行随机排序
     * sort(List list);根据元素的自然顺序对指定List集合元素按升序排序
     * swap(List,int i,int j);根据指定List集合中i和j处元素进行交换
     *
     * Object max(Collection):根据元素的自然顺序、返回给定集合中的最大元素
     * Object max(Collection,Comparator):根据Comparator指定的顺序，返回给定集合中的最大值
     * Object min(Collection)
     * Object min(Collection,Comparator)
     * int frequency(Collection,Object):返回指定集合中指定元素的出现次数
     * void copy(List dest,List src):将src中的内容复制到dest中
     * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List中的旧值
     * synchronizedXxx()；使指定集合包装成线程同步的集合，从而可以解决多线程并发集合时的线程安全问题
     */
    @Test
    public void test(){
        List list=new ArrayList();
        list.add(123);
        list.add(34);
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(0);
        System.out.println(list);
        //reverse(List list);反转List中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
        //shuffle(List list);随机排序List
        Collections.shuffle(list);
        System.out.println(list);
        //sort(List list);根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);
        //swap(List,int i,int j);根据指定List集合中i和j处元素进行交换
        Collections.swap(list,0,3);
        System.out.println(list);
        //int frequency(Collection,Object):返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list,89));
    }
    //void copy(List dest,List src):将src中的内容复制到dest中
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(34);
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(89);
        list.add(0);
        //方式一：
        List list1=new ArrayList();//java.lang.IndexOutOfBoundsException
        list1.addAll(list);
        //方式二：
        List list2= Arrays.asList(new Object[list.size()]);
        Collections.copy(list2,list);
        System.out.println(list1);
        System.out.println(list2);
    }
    /**
     * Collections类中提供了多个synchronizedXxx()方法，
     * 该方法可以使指定集合包装成线程同步的集合，
     * 从而可以解决多线程并发集合时的线程安全问题
     */
    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(34);
        list.add(89);
        list.add(89);
        list.add(89);
        //返回的list1即为线程安全的list
        List list1=Collections.synchronizedList(list);
    }

}
