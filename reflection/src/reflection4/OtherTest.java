package reflection4;

import org.junit.Test;
import reflection1.Person;
import reflection3.Person1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhaomin
 * @date 2020/2/22 23:48
 */
public class OtherTest {
    @Test
    public void test(){
        Class clazz = Person1.class;
        //获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        //获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test3(){
        Class clazz = Person1.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    /*
    获取运行时类的带泛型的父类
     */
    @Test
    public void test4(){
        Class clazz = Person1.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    /*
    获取运行时类的带泛型类的父类的泛型
     */
    @Test
    public void test5(){
        Class clazz = Person1.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        //如果一个类是泛型类，那么它肯定是一个带参数的类
        // 所以我们可以将这个类强转为带参数的类型的类--ParameterizedType
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for (Type act : actualTypeArguments) {
            System.out.println(act.getTypeName());
            //Class才能getName()
            System.out.println(((Class)act).getName());
        }
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test6(){
        Class clazz = Person1.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }

        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class i : interfaces1) {
            System.out.println(i.getName());
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test7(){
        Class<Person1> clazz = Person1.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    /*
    获取运行时类声明的注解
     */
    @Test
    public void test8(){
        Class<Person1> clazz = Person1.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}
