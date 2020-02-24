package reflection5;

import org.junit.Test;
import reflection3.Person1;

import java.lang.reflect.Field;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 * @author zhaomin
 * @date 2020/2/23 15:43
 */
public class ReflectionTestField {
    /**
     * 不需要掌握
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Class<Person1> clazz = Person1.class;
        //获取运行类的实例对象
        Person1 p = (Person1)clazz.newInstance();
        //获取指定的属性--getFiled()--
        // 只能是public--所以一般不用
        Field id = clazz.getField("id");

        System.out.println(id);
        //set（）设置当前属性的值-参数：指明获取那个对象的当前属性值
        id.set(p, 123);
        //get():获取那个对象的当前属性值
        int pId=(int)id.get(p);
        System.out.println(pId);
    }

    /**
     * 如何操作运行时类的指定的属性--需要掌握
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Class<Person1> clazz = Person1.class;
        Person1 p = clazz.newInstance();
        //获取指定的属性getDeclaredField(String fileName):
        // --获取运行时类中指定变量名的属性-不受权限修饰符的限制
        Field name = clazz.getDeclaredField("name");
        //保证当前属性是可访问的
        name.setAccessible(true);
        //获取、设置对象的属性值
        name.set(p, "Tom");
        String pName =(String)name.get(p);
        System.out.println(pName);

    }


}
