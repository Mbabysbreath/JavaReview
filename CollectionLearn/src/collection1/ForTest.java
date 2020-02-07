package collection1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0新增foreach循环，用于遍历集合、数组
 * @author zhaomin
 * @date 2020/2/6 23:46
 */
public class ForTest {

    @Test
    public void test(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String("sdf"));
        Person p=new Person("ZhaoMin",20);
        coll.add(p);
        coll.add(new Person("WangYiBo",22));
        System.out.println("++++++++++遍历集合+++++++");
        //遍历集合：foreach()——内部还是迭代器（Iterator）
        //for(集合中元素的类型 局部变量：集合对象)
        for(Object obj:coll){
            System.out.println(obj);
        }

        System.out.println("++++++遍历数组++++++++++");
        //遍历数组：foreach()——内部还是迭代器（Iterator）
        //for(数组中元素的类型 局部变量：数组对象)
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for(int i:arr){
            System.out.println(i);
        }
    }

}
