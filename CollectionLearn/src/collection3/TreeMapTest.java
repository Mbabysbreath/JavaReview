package collection3;

import collection1.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author zhaomin
 * @date 2020/2/9 13:42
 */
public class TreeMapTest {
    /*向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
      因为要按照key进行排序：自然排序、定制排序
     */
    //1.自然排序
    @Test
    public void test(){
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Jerry", 10);
        Person p3 = new Person("Lion", 15);
        Person p4 = new Person("Jeff", 15);

        Map map=new TreeMap();
        map.put(p1, 90);
        map.put(p2, 89);
        map.put(p3, 96);
        map.put(p4, 88);
        Set entry=map.entrySet();
        Iterator iterator=entry.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    //定制排序
    @Test
    public void test1(){
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Jerry", 10);
        Person p3 = new Person("Lion", 15);
        Person p4 = new Person("Jeff", 15);

        Map map=new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.age,p2.age);
                }
                throw new RuntimeException("输入的类型不匹配");
            }

        });
        map.put(p1, 90);
        map.put(p2, 89);
        map.put(p3, 96);
        map.put(p4, 88);

        Set entry=map.entrySet();
        Iterator iterator=entry.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
