package collection1;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述：
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *   说明：此时的存储，主要怕指的是内存层面的存储，不涉及到持久化的存储（数据库中的数据）
 * （1）数组在存储多个数据方面的特点：
 *      》一旦初始化以后，其长度就确定了
 *      》数组一旦定义好，其元素的类型也就确定了。我们就只能操作指定类型的数据
 *      》比如：String[] arr,int[] arr,Object[] arr
 * (2)数组在存储多个数据方面的缺点：
 *     》一旦初始化以后，其长度就确定了
 *     》数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 *     》获取数组中实际元素的个数的需求，数组没有现成的属性或方法可以用
 *     》数组存储数据的特点：有序可重复，对于无序不可重复的需求，不能满足
 * 二、集合框架
 *  |------Collection接口：单列集合，用来存储一个一个的对象
 *      |----List接口：有序的可重复的数据，”动态“的数组
 *           |----ArrayList\LinkedList\Vector
 *      |----Set接口：无序的不可重复的数据---》高中的”集合“
 *           |----HashSet\LinkedHashSet\TreeSet
 *  |------Map接口：双列集合，用来存储一对（key-value）一对的数据--》高中函数(v)y=f(x)(k)
 *          一个key只能对应一个value(一对多)
 *      |---HashMap\LinkedHashMap\TreeMap\Hashtable\Properties
 *三、Collection接口中的方法的使用
 * 结论：
 *向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 * @author zhaomin
 * @date 2020/2/5 18:29
 */
public class CollectionTest {
    @Test
    public void test(){
        Collection coll=new ArrayList();

        //add(Object e):将元素e添加到集合coll
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());
        //size():获取添加的元素的个数
        System.out.println(coll.size());
        //addAll(Collection coll2);将coll2集合中的元素全部添加到当前的集合中
        Collection coll2=new ArrayList();
        coll2.add("DD");
        coll2.add("DD");
        coll.addAll(coll2);
        System.out.println(coll.size());
        //clear():将集合中的元素清空，不是将对象清为null
        coll.clear();
        System.out.println(coll.size());
        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        coll.add(new Person("Z",11));
        coll.add(122);
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));
        //contains(Object obj);判断当前集合中是否包含obj，equals比较
        boolean contains=coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("abc")));
        System.out.println(coll.contains(new String("sdf")));
        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("ZhaoMin", 20)));//false,如果Person类没有重写equals()

        //containsAll(Collection coll1);判断形参coll1中的所有是否都存在于当前集合中
        System.out.println("******");
        Collection coll1= Arrays.asList(123,"abc",new Person("Z",11));
        System.out.println(coll.containsAll(coll1));
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));

        //remove(Object obj)
        boolean remove = coll.remove(123);
        System.out.println(remove);
        System.out.println(coll.remove(234));
        System.out.println(coll.remove(new Person("ZhaoMin", 20)));
        System.out.println(coll);
        //removeAll(Collection coll1);差集：从当前集合中移除coll1中所有的元素
        System.out.println("***********");
        Collection coll1=Arrays.asList(123,234);
        System.out.println(coll.removeAll(coll1));
    }
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));
        //retainAll(Collection coll1);交集：获取当前集合与coll1集合的交集，并修改当前集合为交集
        Collection coll1=Arrays.asList(123,234,new Person("WangYiBo",22));
        boolean retain=coll.retainAll(coll1);
        System.out.println(retain);
        System.out.println(coll);
        //equals(Object obj);要想返回true,需要当前集合和形参集合的元素都相同，
                         //至于顺序差别对结果的影响，需要看是ArrayList(顺序不同，接果为false)还是HashSet等
        Collection coll2=new ArrayList();
        coll2.add(123);
        coll2.add("abc");
        coll2.add(new String("sdf"));
        Person p1=new Person("ZhaoMin",20);
        coll2.add(p1);
        coll2.add(new Person("WangYiBo",22));
        System.out.println(coll2.equals(coll2));
    }
    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //集合---》数组：toArray()
        Object[] arr=coll.toArray();
        System.out.println(Arrays.toString(arr));
        //拓展：数组--》集合：Arrays.asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        List<String> list4 = Arrays.asList("AA", "BB", "CC");
        System.out.println(list);
        System.out.println(list4);
        List<Integer> list1 = Arrays.asList(123, 23);
        List<Integer> list2 = Arrays.asList(new Integer[]{123, 23});
        List<int[]> list3 = Arrays.asList(new int[]{123, 23});
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        //iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中

    }
    @Test
    public void test5(){
        System.out.println(isExists("abc","ac"));
    }
    private boolean isExists(String s1,String s2){
        char[] arr1=s1.toCharArray();
        Character[] a = new Character[arr1.length];
        for(int i=0;i<arr1.length;i++){
            a[i]=arr1[i];
        }
        char[] arr2=s2.toCharArray();
        Character[] a2 = new Character[arr2.length];
        for(int i=0;i<arr2.length;i++){
            a2[i]=arr2[i];
        }
        List<Character> list1=Arrays.asList(a);
        List<Character> list2=Arrays.asList(a2);
        if(list1.containsAll(list2)){
            return true;
        }
        return false;
    }
}
