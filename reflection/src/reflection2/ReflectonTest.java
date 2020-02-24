package reflection2;

import org.junit.Test;
import reflection1.Person;

import java.lang.annotation.ElementType;

/**
 * 获取Class类实例的方式
 * @author zhaomin
 * @date 2020/2/19 15:25
 */
public class ReflectonTest {
    /**
     * 获取Class类实例的方式
     * 前三种需要掌握
     */
    @Test
    public void test() throws ClassNotFoundException {
        /*方式一：通过运行时类的属性：class*/
        Class clazz = Person.class;
        System.out.println(clazz);

        /*方式二：通过运行时类的对象调用getClass()*/
        Person person=new Person();
        Class clazz1 = person.getClass();
        System.out.println(clazz1);

        /*方式三:调用Class静态方法：forName(String classPath)
        * 用的多
        * */
        Class<?> clazz2 = Class.forName("reflection1.Person");
        System.out.println(clazz2);

        /*方式四：使用类的加载器 ClassLoader--了解*/
        ClassLoader classLoader = ReflectonTest.class.getClassLoader();
        Class<?> clazz3 = classLoader.loadClass("reflection1.Person");
        System.out.println(clazz3);
        /**
         * 加载到内存中的运行时类，会缓存一定的时间。
         在此时间内，我们可以通过不同的方式来获取此运行时类
         */
        System.out.println(clazz == clazz1);//true
        System.out.println(clazz == clazz2);//true
        System.out.println(clazz == clazz3);//true

    }

    /**
     * Class实例可以是哪些结构
     */
    @Test
    public void test1(){
        Class c1=void.class;
        Class<Object> c2 = Object.class;
        Class<String[]> c3 = String[].class;
        Class<Override> c4 = Override.class;
        Class<Integer> c5 = int.class;
        Class<Class> c6 = Class.class;
        Class<ElementType> c7 = ElementType.class;

        //只要数组的类型和维度相同就是同一个Class
        int[] arr1 = new int[10];
        int[] arr2 = new int[100];
        Class aClass = arr1.getClass();
        Class aClass1 = arr2.getClass();
        System.out.println(aClass==aClass1);
    }
}
