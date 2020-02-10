package collection3;

import org.junit.Test;

import java.util.*;

/**一、Map的实现类的结构：
 * /----Map:双列数据，存储key-value数值对对的数据--类似于高中的函数：y=f(x)
 *      |---HashMap:Map的主要实现类，线程不安全的，效率高，可以存储null的key和value
 *          |---LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *               原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个
 *                    对于频繁的遍历操作，此类执行效率高于HashMap
 *     |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序、定制排序
 *                  底层使用红黑树
 *     |----Hashtable:古老的实现类，线程安全，效率低，不能存储null的key和value
 *          |---Properties:常用来处理配置文件，key-value都是String类型
 *    HashMap的底层：数组+链表（jdk7之前）
 *                  数组+链表+红黑树（jdk8)
 * 面试题：
 * 1.HashMap的底层实现原理？--**
 * 2.HashMap和Hashtable的异同
 * 3.CurrentHashMap与Hashtable异同？（暂时不讲）
 *
 * 二、Map结构的理解：put的是一个一个的entry{key,value}
 * Map中的key:无序的、不可重复的，使用Set存储所有的key-->key所在的类要重写equals和hashCode
 * Map中的value:无序的、可重复的，使用Collection存储所有的value，value所在的类要重写equals
 * 一个键值对：key-value构成一个entry对象
 * Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 * @author zhaomin
 *
 * 三、HashMap的底层实现原理
 * 1.jdk7:
 * HashMap map=new HashMap();
 * 在实例化以后，底层创建了长度为16的一维数组Entry[] table
 * ...可能已经执行过多次put..
 * map.put(key1,value):
 * (1)首先调用key1所在类的hashCode（）计算key1的哈希值，此哈希值经过某种算法以后，得到在数组Entry中的存放位置；
 * （2）如果此位置的上的数据为空，则key1-value1添加成功---情况1
 * （3）如果此位置上的数据不为空，（意为着在此位置已经存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个
 *     或多个数据的哈希值：
 *     都不相同：key1-value1添加成功---情况2
 *     和某一数据（key2-value2）相同，继续比较：调用key1所在类的equals(key2):
 *         如果equals()返回false:key1-value1添加成功---情况3
 *         如果equals()返回true:使用value1替换value2
 *  补充：关于情况2、3：此时key1-value1和原来的数据以链表的形式存储
 *       在不断添加的过程，会涉及到扩容问题，
 *       默认的扩容方式：当超出临界值12（且要存放放入位置非空）时， 扩容为原来容量的2倍，并将原有的数据复制过来
 *2.jdk8 相较于jdk7在底层实现方面的不同：
 * （1）new HashSet()时，：底层没有创建一个长度为16的数组
 * （2）jdk 8底层的数组是：Node[] ,而非Entry[]
 * (3)首次调用put()方法时，底层创建长度为16的数组
 * （4）jdk7底层结构只有：数组+链表，jdk8中：数组+链表+红黑树
 *      使用红黑树：
 *       当数组中的某一个索引位置上的元素以链表形式存在的数据个数>8,且当前数组的长度>64时，
 *       此时此索引位置上的索引数据改为使用红黑树存储，提高效率，
 *补充常量：
 * EFAULT_INITIAL_CAPACITY:HashMap的默认容量：16
 * DEFAULY_LOAD_FACTORY:HashMap的默认加载因子:0.75
 * threshold:扩容的临界值=容量*填充因子： 16*0.75》=12
 * TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值，转化为红黑树：8
 * MIN_TREEIFY_CAPACITY:桶中的Node被树化时最小的hash表容量：64
 * 扩容是为了尽量减少链表的使用
 *
 * 面试题：
 * 负载因子值的大小对HashMap有什么影响？
 * （1）负载因子的大小决定了HashMap的数据密度
 * （2）负载因子越大，密度越大，越容易碰撞，数组中链表越长
 *      造成查询、插入时比较的次数增多，性能下降
 * （3）负载因子越小，越容易触发扩容，数据密度越小，发生碰撞几率变小，
 *     数组中链表越短，查询和插入时比较次数越少，性能会更高。
 *     但会浪累一定的内容空间，而且经常扩容影响性能。
 *     建议初始化时预设大一点的空间。
 * （4）负载因子设置为0.7-0.75，此时平均检索长度接近于常数
 *
 * 四、LinkedHashMap的底层实现原理（了解）
 * LinkedHashMap与HashMap底层实现原理一样，因为LinkedHashMap继承于HashMap
 * 区别在于：LinkedHashMap用Entry替换了 HashMap中的Node
 * 源码中：
 *  static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
    }
 * static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;//能够记录添加的元素的先后顺序
        Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
        }
    }
*五、Map中常用的方法
 *添加：put(Object key,Object value)
 *删除：remove(Object key)\clear()
 *修改:put(Object key,Objec value)
 *查询：get(Object key)
 *长度：size()
 *遍历：keySet()/values()/entrySet()
 * @date 2020/2/8 17:57
 */
public class MapTest {
    @Test
    public void test(){
        Map map=new LinkedHashMap();
        map.put(1, 1);
        map.put(2,2);
        map.put(3, 3);
        map.put(null,null);
        System.out.println(map);
    }
    /*添加、删除、修改*/
    @Test
    public void test1(){
        Map map=new HashMap();
        //Object put(Object key,Object value);//如果是替换value则返回原来value,否则返回null
        map.put("A",111);
        map.put("B", 222);
        map.put("C",333);
        System.out.println(map.put("C",555));
        System.out.println(map.put("D",444));
        System.out.println(map);
        //void putAll(Map map1)
        Map map1=new HashMap();
        map1.put("D",444);
        map1.put("E",555);
        map.putAll(map1);
        System.out.println(map);
        //Object remove(Object key);//将key对应的键值对删除，并返回value
        Object val=map.remove("C");
        System.out.println(val);
        System.out.println(map);
        //void clear();//将集合中所有元素清空，不等于map=null
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
    }
    /*元素查询操作*/
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("A",111);
        map.put("B", 222);
        map.put("C",333);
        //Object get(Object key)
        System.out.println(map.get("A"));
        //boolean containKey(Object key)
        System.out.println(map.containsKey("A"));
        System.out.println(map.containsKey("F"));
        //boolean containValue(Object value)
        System.out.println(map.containsValue(333));
        //int size()
        System.out.println(map.size());
        //boolean isEmpty()；判断当前map是否为空
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.isEmpty());
        //boolean equals(Object obj)//判断当前map和参数对象obj是否相等
        //要想返回true,obj必须也为map,且对应的key-value相等
    }
    /*元视图操作的方法*/
    @Test
    public void test3(){
        //1.Set keySet():遍历key
        Map map = new HashMap();
        map.put("A",111);
        map.put("B", 222);
        map.put("C",333);
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //2.Collection values();//遍历所有的value
        Collection collection=map.values();
        for (Object obj : collection) {
            System.out.println(obj);
        }
        //3.entrySet();//遍历所有的键值对Entry
        //--方式一：
        Set set1=map.entrySet();
        for (Object obj : set1) {
            //entrySet集合中所有的元素都是entry
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"-->"+entry.getValue());

        }
        System.out.println("====方式二====");
        //--方式二：
        Set set2=map.keySet();
        Iterator iterator1=set2.iterator();
        while (iterator1.hasNext()) {
            Object key=iterator1.next();
            Object value=map.get(key);
            System.out.println(key+"-->"+value);
        }
    }

}
