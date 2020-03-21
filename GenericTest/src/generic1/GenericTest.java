package generic1;

import org.junit.Test;

import java.util.*;

/**
 * 1.jdk5.0引入泛型
 * 2.在集合中使用泛型：
 * 总结：
 * （1）集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * （2）在实例化集合类时，可以指明具体的泛型类型
 * （3）指明以后，在集合类或接口中凡是定义类或接口时，
 *     内部结构（方法、构造器、属性等）使用类的泛型的位置，
 *     都指定为实例化的泛型类
 * （4）注意：泛型的类型必须是类，不能是基本数据类型，
 *     如果要用，就用包装类进行自动拆箱
 * （5）如果实例化时，没有指明泛型类型，默认类型为Object类型
 *3.如何自定义泛型结构，泛型类，泛型接口；
 *   泛型方法<E>
 *
 * 4.泛型在继承方面的体现
 *
 * 5.通配符
 *
 * @author zhaomin
 * @date 2020/2/10 17:32
 */
public class GenericTest {
    //在集合中使用泛型
    @Test
    public void test(){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(123);
        list.add(345);
        list.add(567);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test1(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 12);
        map.put("Jerry", 12);
        map.put("Gugu", 14);
        Set<Map.Entry<String,Integer>> entries=map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }
}

