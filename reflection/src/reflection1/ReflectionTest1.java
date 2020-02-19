package reflection1;

import org.junit.Test;

import java.io.FileOutputStream;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * @author zhaomin
 * @date 2020/2/19 13:50
 */
public class ReflectionTest1 {
    /**
     * 反射之前，对于Person类的操作
     */
    @Test
    public void test(){
        //1.对象的实例化
        Person person = new Person("Tom", 12);

        //2.通过对象调用其内部的属性和方法
        person.age=23;
        System.out.println(person.toString());
        person.show();

        //3.在Person类的外部。不能通过对象调用内部私有结构（属性、方法、构造器）
    }

    /**
     * 反射之后，对于Person类的操作
     */
    @Test
    public void test1() throws Exception {
        //1.通过反射获取Person类
        Class pClass = Person.class;
        //2.通过反射创建Person类的构造器，并创建对象
        Constructor cons = pClass.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        //3.通过反射，调用对象的属性和方法
        System.out.println(p.toString());
        //调用属性，并设置属性
        Field age = pClass.getDeclaredField("age");
        age.set(p,23);
        System.out.println(p.toString());
        //调用方法
        Method show = pClass.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构
        //调用私有构造器
        Constructor cons1 = pClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有属性
        Field name = pClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"海绵宝宝");
        System.out.println(p1);
        //调用私有方法
        Method showNation = pClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object object = showNation.invoke(p1, "中国");
        String nation=(String)object;
        System.out.println(nation);
    }
    //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中用哪个
    //建议：直接new
    //2.什么时候使用反射的方式---反射的特征：动态性
    //疑问2：反射机制与面向对象中的封装性是不是矛盾的，如何看待
    //不矛盾，私有--是建议最好别用 反射--硬要使用也可以

    /**
     *
     */
}
