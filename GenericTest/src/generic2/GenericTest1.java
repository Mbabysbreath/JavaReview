package generic2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构，泛型类，泛型接口；泛型方法
 * 1，泛型类写构造器时，不要给构造器加泛型类<>,
 *    实例化时要加上
 * 2.泛型类型不同的引用不能相互赋值
 * ArrayList<Integer> list1=new ArrayList<>();
 * ArrayList<String> list2=new ArrayList<>();
 * list1=list2//错误的
 * 3.泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，
 *   但不等价与Object.
 * 4.如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象
 * 5.泛型类不能使用在静态结构中
 *   可以定义静态的泛型方法
 * 6.异常的类不能声明为泛型类，catch(T e)//也错误
 *   class MyException<T> extends Exception{
 *       //错误
 *   }
 * 7.泛型类的数组不能正常定义
 *    T[] arr=new T[10];//错误
 *    T[] arr=(T[])new Object[10];//解决
 * 8.子类继承父类泛型的保留问题
 * class Father<T1,T2>{}
 * （1）子类没有保留父类的泛型
 *      a.没有类型 擦除
 * class Son1<A,B> extends Father{
 *     //等价于常量class Son1 extends Father<Object,Object>
 * }
 *
 *     b.具体类型
 * class Son2<A,B> extends Father<Integer,String>{
 * }
 *
 * (2)子类保留父类的泛型--A,B是子类额外定义的
 *     a.全部保留
 * class Son3<T1,T2,A,B> extends Father<T1,T2>{}
 *    b.部分保留
 * class Son4<T2,A,B> extends Father<Integer,T2>
 *
 * @author zhaomin
 * @date 2020/2/11 21:02
 */
public class GenericTest1 {
    @Test
    public void test(){
        //1.如果定义了泛型类，实例化没有指明类的泛型<T>，则认为此泛型类为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT("ASD");
        order.setOrderT(111);

        //2.建议：实例化时指明类的泛型<T>---><String>
        Order<String> order1 = new Order<>("orderA", 123, "TTT");
        order1.setOrderT("VVV");
        String s = order1.orderT;
        System.out.println(s);
    }
    //继承泛型类---指明泛型的类型
    @Test
    public void test1(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承泛型的父类时，指明了泛型类型，
        //则实例化子类对象时，不再需要指明泛型类型
        subOrder.setOrderT(1);

    }
    //继承泛型类----没有指明泛型的类型
    @Test
    public void test2(){
        SubOrder1<String> order1=new SubOrder1();
        order1.setOrderT("AAA");
    }
    //调用泛型方法
    @Test
    public void test3(){
        Order<String> order = new Order();
        Integer[] arr=new Integer[]{1,2,3};
        //泛型方法在调用时指明泛型参数的类型
        List<Integer> list=order.asList(arr);
        System.out.println(list);
    }


}
