package java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 1.使用情景：当要传递给lambda体的操作，已经有实现放入方法了，可以使用方法引用
 * 2.方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例，所以
 *   方法引用，也是函数式接口的实例
 * 3.使用格式： 类（或对象）：：方法名
 * 4.具体分为如下三种情况：
 * 对象 ：：非静态方法
 * 类 ：：静态方法
 * 类 ::非静态方法
 *
 * 5.方法引用使用的要求
 * ：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值相同
 * （针对情况1、情况2）
 * @author zhaomin
 * @date 2020/2/27 13:57
 */
public class MethodReTest {
    //情况1：对象：：实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1=str-> System.out.println(str);
        con1.accept("北京");

        System.out.println("++++++++++++++++++");
        PrintStream ps=System.out;
        Consumer<String> con2=ps::println;
        con2.accept("背景");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){
        Employee emp=new Employee("Tom",12);
        Supplier<String> sup1=()->emp.getName();
        System.out.println(sup1.get());

        System.out.println("++++++++++++++");
        Supplier<String> sup2=emp::getName;
        System.out.println(sup2.get());
    }

    //情况2：类::静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer 中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> com1=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));

        System.out.println("________________");

        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(12,3));
    }

    //Function中的R apply(T t)
    // Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double,Long> func=new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(func.apply(12.3));

        Function<Double,Long> func1=d->Math.round(d);
        System.out.println(func1.apply(12.6));

        Function<Double,Long> func2=Math::round;
        System.out.println(func2.apply(12.5));
    }

    //情况3：类：：实例方法（有难度）
    //Comparator中的int compare(T t1,T t2)
    //String 中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1=(s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));
        System.out.println("++++++++++++++++++");
        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("abd", "abm"));
    }

    //BiPredicate中的boolean test(T t1,T t2)
    //String中的boolean t1.equlas(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> bi=(t1,t2)->t1.equals(t2);
        System.out.println(bi.test("a","b"));
        System.out.println("++++++++++++++");
        BiPredicate<String,String> bi2=String::equals;
        System.out.println(bi2.test("an","an"));
    }

}
