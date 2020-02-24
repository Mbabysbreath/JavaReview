package reflection5;

import org.junit.Test;
import reflection3.Person1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author zhaomin
 * @date 2020/2/23 16:19
 */

public class ReflectionTestMethod {
    /**
     * 如何操作运行时类中指定的方法--需要掌握
     */
    @Test
    public void testMethod() throws Exception{
        Class clazz= Person1.class;

        //创建运行时类的对象
        Person1 p = (Person1)clazz.newInstance();
        //getDeclaredMethod():
        // 参数1：指明获取的方法的名称  参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class, String.class);
        //保证当前方法是可访问的
        show.setAccessible(true);
        //invoke() 参数1：方法的调用对象 参数2：。。传入方法的实参给形参赋值
        //invoke的返回值就是对应类中调用方法的返回值
        //String nation=p.show("CHN","ShanXi");
        Object returnValue = show.invoke(p, "CHN","ShanXi");
        System.out.println(returnValue);

        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类的方法没有返回值，则invoke()返回null
        Object o = showDesc.invoke(clazz);
        //或者
        showDesc.invoke(Person1.class);
        //或者
        showDesc.invoke(null);
        System.out.println(o);
    }
    /**
     * 获取调用运行时类的指定构造器
     */
    @Test
    public void test2() throws Exception {
        Class clazz=Person1.class;
        //    private Person1(String name)
        //1.获取指定的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person1 p = (Person1) declaredConstructor.newInstance("Tom");
        System.out.println(p);
    }

}
