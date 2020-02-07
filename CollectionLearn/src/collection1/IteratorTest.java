package collection1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口——仅用于遍历Collection,不包含Map
 * 1.内部的方法:hasNext() next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象
 *   默认游标都在集合的第一个元素之前
 * 3.内部的remove(),会删除当前迭代器所指的集合的元素，不同于集合中的remove
 *
 * @author zhaomin
 * @date 2020/2/6 21:16
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            //指针开始是在第一个元素的前一个位置
            //调next()：（1）指针下移（2）将下移后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }
    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用next()方法之后已经调了remove（）方法
    //再调用remove()都会报IllegalStateException
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));

        /*删除集合中的“abc"*/
        Iterator iterator=coll.iterator();
        while (iterator.hasNext()) {
           // iterator.remove();//java.lang.IllegalStateException
            Object obj=iterator.next();
            if("abc".equals(obj)){
                iterator.remove();
            }
            //iterator.remove();//java.lang.IllegalStateException
        }
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }

}
