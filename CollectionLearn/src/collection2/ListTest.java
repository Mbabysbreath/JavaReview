package collection2;

import collection1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**1.
 * |------Collection接口：单列集合，用来存储一个一个的对象
 *      |----List接口：有序的可重复的数据，”动态“的数组,替换原有的数组
 *           |ArrayList：主要实现类jdk1.2;   线程不安全，效率高；查找方便   底层结构—数组Object[] elementDate
 *           |LinkedList:jdk1.2:   对于频繁的插入、删除操作，效率更高；    底层结构是双向链表
 *           |Vector：jdk1.0,List接口的古老实现类；   线程安全，效率不高；.底层实现结构—数组Object[] elementDate
 * 2.面试题：ArrayLIst\LinkedList\Vector三个类 的区别：
 * （1）相同点：都实现了List接口；存储数据的特点：有序可重复,可以存储null
 * （2）区别：见上。底层数据结构、效率、版本
 *
 * 3.ArrayList的源码分析：
 * （1）jdk7的情况：
 *     ArrayList list=new ArrayList();//底层创建一个长度为10的Object[] elementData数组
 *     list.add(123)；添加元素，elementData[0]=new Integer(123)
 *     ...
 *     list.add(434);如果此次的添加导致底层数组容量不够，则扩容。默认情况扩容为原来的1.5倍
 *                   同时要将原数组的数据复制到新数组中
 *    结论：建议开发中使用带参的构造器，指明容量
 *          ArrayList list=new ArrayList(int capacity);
 * （2）jdk8中ArrayList的变化：
 *     ArrayList list=new ArrayList();//底层Object[] elementData的初始化为{}，
 *                                     并没有创建长度为10的数组
 *    list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementsData中
 *    。。。
 *    后续的添加和扩容与jdk7无异
 * （3）小结：
 * jdk7中的ArrayList的对象的创建类似于单例模式的饿汉式，
 * jdk8中的ArrayList的对象的创建类似于单例模式的懒汉式，延迟数组创建，节省内存
 *
 * 4.LinkedList的源码分析：
 * LinkedList lis=new LinkedList();//内部声明了Node类型的两个属性first和last，默认为null
 * list.add(123);//将123封装到Node中，创建了Node对象
 * 其中，Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E> {
 *    E item;
 *    Node<E> next;
 *    Node<E> prev;

 *    Node(Node<E> prev, E element, Node<E> next) {
 *    this.item = element;
 *    this.next = next;
 *    this.prev = prev;
 *    }
 *}
 * 5.Vector的源码分析：jdk7和jdk8中通过Vector（）构造器创建对象时，底层都创建了长度为10的数组
 *                   在扩容方面，默认扩容为原来的数组长度的2倍
 * 6.List接口中的常用方法;
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index)/remove(Object obj)--remove(new Integer(2))
 * 改：set(int index,Object ele)
 * 查：indexOf(Obj obj)/lastIndexOf(Obj obj)/get(int index)
 * 插：add(int index,Object obj)
 * 长度:int size();
 * 遍历：Iterator 迭代器方式、foreach()、普通的循环
 * @author zhaomin
 * @date 2020/2/7 14:36
 */
public class ListTest {

    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(234);
        list.add(345);
        list.add(456);
        //1.void add(int index,Object e);在index位置插入e
        list.add(1, "AA");
        System.out.println(list);
        //2.boolean addAll(int index,Collection eles);从index开始将集合eles中的所有元素插入
        List list1 = Arrays.asList("BB", "CC", new Person("Z",11));
        list.addAll(1,list1);
        System.out.println(list.size());
        System.out.println(list);
        //3.Object get(int index);获取指定index位置的元素
        Object o = list.get(2);
        System.out.println(o);
    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(234);
        list.add(345);
        list.add(456);
        list.add(123);
        list.add(null);
        System.out.println(list.size());
        //4.int indexOf(Object obj);//返回obj在集合中首次出现的位置，如果不存在返回-1
        int index=list.indexOf(123);
        System.out.println(index);//0
        //5.int lastIndexOf(Object obj);//返回obj在集合中最后一次出现的位置，否则返回-1
        System.out.println(list.lastIndexOf(123));
        //6.Object remove(int index);//移除指定位置index上的元素，并返回
        System.out.println(list.remove(0));
        System.out.println(list);

        //7.Object set(int index,Object ele);//将指定index位置的元素设为ele,返回之前的元素
        System.out.println(list.set(0, "aa"));;
        System.out.println(list);
        //8.List subList(int fromIndex,int toIndex);//返回【fromIndex,toIndex）位置的左闭右开的区间子串
        List subList = list.subList(1, 3);
        System.out.println(subList);
        System.out.println(list);
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(234);
        list.add(345);
        list.add(456);
        list.add(123);
        //方式一：Iterator
        Iterator iterator=list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("******************");
        //方式二：foreach()
        for(Object obj:list){
            System.out.println(obj);
        }
        System.out.println("********************");
        //方式三：普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
