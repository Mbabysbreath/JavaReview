package reflection4;

import org.junit.Test;
import reflection1.Person;
import reflection3.Person1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 * @author zhaomin
 * @date 2020/2/21 23:50
 */
public class FieldTest {
    @Test
    public void test1(){
        Class clazz= Person1.class;

        /*获取属性结构*/

        //getFields():获取当前运行时类及父类中声明为public的访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("===================================");

        //getDeclaredFields():获取当前运行时类中声明的所有属性也包括private
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    //获取属性的权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class clazz = Person1.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符0-默认 1.公共 2.私有
            int mod = f.getModifiers();
            System.out.print(Modifier.toString(mod)+"-----");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName()+"----------");
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }

    }
}
