package java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例（o1,o2）->Integer.compare(o1,o2);
 * 2.格式：
 *       ->:lambda操作符或剪头操作符
 *       ->左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *       ->右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3.lambda表达式的使用：（分为6中情况介绍）
 * 总结：
 * ->左边：lambda形参列表的参数类型可以省略（类型推断），如果只有一个参数括号也可以省略，
 * ->右边：lambda体应该用{}包裹，如果只有一条执行语句（可能是return ），可以省略{}和return 关键字
 * 4.lambda表达式的本质：作为函数式接口的实例
 * 5.函数式接口：只含有一个抽象方法的接口,有@FunctionalInterface注解
 * 6.所以以前用匿名实现类表示的现在都可以用lambda表达式来写
 *
 * @author zhaomin
 * @date 2020/2/26 21:10
 */
public class LambdaTest {
    //格式一：无参无返回值
    @Test
    public  void test1() {
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("我想去哔哩哔哩");
            }
        };
        r1.run();

        Runnable r2=()-> System.out.println("我要去哔哩哔哩");
        r2.run();
    }
    //格式二：有一个参数，无返回值
    @Test
    public void test2(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("理想和梦想的区别是什么");

        Consumer<String> consumer1=(String s)-> {
            System.out.println(s);
        };
        consumer1.accept("一个是可能，一个是做梦");
    }

    //格式三：数据类型可以省略，因为可以有编译器推断得出，称为类型推断
    //类型推断：泛型ArrayList<String> list=new AttayList<>();
    //数组：int[] arr={1,2,3};
    @Test
    public void test3(){
        Consumer<String> consumer1=(String s)-> {
            System.out.println(s);
        };
        consumer1.accept("一个是可能，一个是做梦");
        Consumer<String> consumer2=(s)-> {
            System.out.println(s);
        };
        consumer2.accept("一个是可能，一个是做梦");
    }

    //语法格式四：lambda若只要一个参数，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> consumer1=(String s)-> {
            System.out.println(s);
        };
        consumer1.accept("一个是可能，一个是做梦");

        Consumer<String> consumer2=s-> System.out.println(s);
        consumer2.accept("一个是可能，一个是做梦");
    }
    //语法格式五：lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(12, 23));

        Comparator<Integer> comparator1=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(33, 21));
    }

    //格式六：当lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7(){

        Comparator<Integer> comparator=(o1,o2)->{
            return o1.compareTo(o2);
        };

        System.out.println(comparator.compare(12,21));

        Comparator<Integer> comparator1=(o1,o2)-> o1.compareTo(o2);
    }
}
