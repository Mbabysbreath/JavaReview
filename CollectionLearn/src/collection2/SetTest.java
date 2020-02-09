package collection2;

import collection1.Person;
import org.junit.Test;

import java.util.*;

/**
 * 1.Set接口的框架：
 *  |------Collection接口：单列集合，用来存储一个一个的对象
 *      |----Set接口：无序的不可重复的数据---》高中的”集合“
 *           |HashSet：底层结构：数组+链表（HashMap()）；作为Set接口的主要实现类：线程不安全：可以存储null
 *               |-----LinkedHashSet：作为HashSet的子类，因为添加了Linked，所以遍历内部数据时，可以按照添加的顺序遍历
 *                                    优点:对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *           |TreeSet：红黑树存储；可以按照添加元素（对象）的指定属性进行排序
 * 2.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 * 3.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *   要求：重写的hashCode()和equals()尽可能保持一致性，想等的对象必须具有想等的散列码
 *   重写两个方法的小技巧：对象中用作equals()方法比较的Field,都应该用来计算hashCode
 * @author zhaomin
 * @date 2020/2/7 21:25
 */
public class SetTest {
    /**
     * 一、Set:存储无序的、不可重复的数据
     * 以HashSet为例说明：
     * （1）无序性：不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加，
     *            而是根据数组的哈希值进行添加
     * （2）不可重复性：保证添加的元素按照equals()判断时，不能返回true
     *              即相同的元素只能添加一个
     * 二、添加元素a的过程：以HashSet为例：
     * （1）调用元素a所在类的hashCode()方法，计算元素a的哈希值
     * （2）此哈希值接着通过某种算法计算出HashSet底层数组的存放位置（即为：索引位置）、
     * （3）判断数组此位置是否已有元素：
     *      如果没有，则元素添加成功，---》情况1
     *      如果有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值，
     *      如果hash值不相同，则元素a添成功---》情况2
     *      如果hash值相同，进而需要调用元素a所在equals()方法，
     *          equals（）方法返回true，元素a添加失败
     *          equals()返回false,则元素a添加成功---》情况3
     *说明：对于添加成功的情况2和3而言，元素a与已经存在指定索引位置上数据以链表的方式存储
     * jdk7:元素a放到数组中，指向原来的元素，链表中a在首位
     * jdk8:原来数组中的元素指向a,链表中a放在尾部
     * 总结：七上八下
     * HashSet底层：数组+链表
     */
    @Test
    public void test(){
        Set set=new HashSet();
        set.add(123);
        set.add(456);
        set.add(789);
        set.add(new Person("Zhaomin",20));
        set.add(new Person("Zhaomin",20));
        set.add(new Person("Zhaomin",20));
        System.out.println(set);
    }

    /**
     * LinkedHashSet的使用
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，
     *     每个数据还维护类两个引用，记录此数据前一个数据和后一个数据
     * 优点:对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void test1(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(789);
        set.add(new Person("Zhaomin",20));
        set.add(new Person("Zhaomin",20));
        set.add(new Person("Zhaomin",20));
        System.out.println(set);
    }
    /**
     * 1.向TreeSet中添加的数据，要求是相同的类对象，不能添加不同类的对象
     *2.两种排序方式：自然排序和定制排序
     * 3.自然排序中，比较两个对象是否相同的标准为compareTo()返回0，不再是equals()
     * 4.定制排序中，比较两个对象是否相同的标准为compa()返回0，不再是equals()
     */
    @Test
    public void test3(){
        /*举例1：添加整型数字*/
        Set set=new TreeSet();
        set.add(12);
        set.add(-1);
        set.add(34);
        System.out.println(set);
        /*举例2：添加自定义对象,实现compareTo()、compare()*/
        Set set1=new TreeSet();
        set1.add(new Person("ZhaoMin", 20));
        set1.add(new Person("WangYiBo", 22));
        set1.add(new Person("XiaoZhan", 28));
        set1.add(new Person("XiaoZhan", 26));
        Iterator iterator=set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test4(){

        Comparator comparator=new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.age,p2.age);
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set1=new TreeSet(comparator);//将比较器传进去
        set1.add(new Person("ZhaoMin", 20));
        set1.add(new Person("WangYiBo", 22));
        set1.add(new Person("XiaoZhan", 28));
        set1.add(new Person("XiaoZhan", 26));
        Iterator iterator=set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
