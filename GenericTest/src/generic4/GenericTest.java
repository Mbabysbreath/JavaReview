package generic4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 * 2.通配符的使用
 * @author zhaomin
 * @date 2020/2/11 23:58
 */
public class GenericTest {
    /**
     * 泛型在继承方面的体现
     * 类A是类B的父类，G<A>和G<B>不具备关系
     */
    @Test
    public void test(){
        Object obj = null;
        String str=null;
        obj=str;

        Object[] arr1=null;
        String[] arr2=null;
        arr1=arr2;

        List<Object> list1=null;
        List<String> list2=null;
        //此时list1 和 list2 的类型不具备父子继承关系
        //list1=list2编译不通过

        Date date=new Date();
        //str=date;编译不通过
    }

    /**
     * 通配符的使用：
     * 通配符：？
     * （1）类A是类B的父类，G<A>和G<B>是没有关系的，
     *      二者的共同的父类是G<?>
     */
    @Test
    public void test1(){
        List<Object> list1=null;
        List<String> list2=null;

        List<?> list=null;
        list=list1;
        list=list2;

       //编译不通过，空指针引用
       // print(list1);
        // print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("SS");
        list3.add("DD");
        list3.add("PP");
        list=list3;
        //添加（写入）：对于List<?>就不能向其内部添加数据，null可以
        //list.add("FF");
        list.add(null);

        //获取（读数）：允许读取数据,读取数据类型是Object
        Object o = list.get(0);
        System.out.println(o);

    }
    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while (iterator.hasNext()) {
            Object obj=iterator.next();
            System.out.println(obj);
        }
    }

    /*? extends A
    *  G<? extends A>---可以作为G<A>和G<B>的父类，B是A的子类
    * ? super A
    * G<? super A>------可以作为G<A>和G<B>的父类，B是A的父类
    * */
    @Test
    public void test3(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;
         //
        list1=new ArrayList<Person>();
        list1=new ArrayList<Student>();

        list2 = new ArrayList<Person>();
        list2=new ArrayList<Object>();
        //读取数据，用最大的来接受
        Person person = list1.get(0);//用Student接受会编译不通过
        Object object = list2.get(0);//用Person接受会编译不通过
        //写入数据
       // list1.add(new Student());编译不通过，可能list1中?的泛型类要比Student小，
                                     //就不能装一个Student类对象
        list2.add(new Person());//?是比Person大的类，
                              //因此可以装比Person小的类对象
        list2.add(new Student());
    }
}
