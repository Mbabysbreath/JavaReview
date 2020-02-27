package java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 * 抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 *
 * 可以把数组看作是一个特殊的类，则写法与构造器引用一致
 * @author zhaomin
 * @date 2020/2/27 18:26
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier<Employee>
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>(){
            @Override
            public Employee get(){
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("+++++++++++++++");
        Supplier<Employee> sup1=()->new Employee();
        System.out.println(sup1.get());
        System.out.println("+++++++++++++++++");
        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());
    }

    //Function中的apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> func1 = age -> new Employee(age);
        Employee employee=func1.apply(12);
        System.out.println(employee);

        System.out.println("+++++++++++++++++");
        Function<Integer,Employee> func2=Employee::new;
        Employee employee1 = func2.apply(13);
        System.out.println(employee1);
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<String, Integer, Employee> func1 = (name,id) -> new Employee(name,id);
        System.out.println(func1.apply("Tom", 11));
        System.out.println("+++++++++++++++++++");
        BiFunction<String,Integer,Employee> func2=Employee::new;
        System.out.println(func2.apply("Jerry", 323));
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1=length->new String[length];
        String[] arr1=func1.apply(5);
        System.out.println(Arrays.toString(arr1));
        System.out.println("++++++++++++");
        Function<Integer,String[]> func2=String[]::new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }


}
