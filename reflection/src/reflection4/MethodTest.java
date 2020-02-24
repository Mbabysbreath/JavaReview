package reflection4;

import org.junit.Test;
import reflection1.Person;
import reflection3.Person1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的方法
 * @author zhaomin
 * @date 2020/2/22 22:59
 */
public class MethodTest {
    @Test
    public void test1(){
        Class clazz= Person1.class;

        //getMethods()--获取当前的运行时类及所有父类的public方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("==========================");
        //-getDeclaredMethods()--获取当前类的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);

        }
    }

    /**
     * 获取方法的：
     * 注解
     * 权限修饰符  返回值 方法名 形参列表（参数类型1 形参名1，...) 异常
     */
    @Test
    public void test2(){
        Class<Person1> clazz = Person1.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            //权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers)+" ");
            //返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName()+" ");
            //方法名
            String name = m.getName();
            System.out.print(name+" ");
            //形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes==null&&parameterTypes.length==0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + ",args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+"args_"+i+",");

                }
            }
            System.out.print(") ");
            //异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)) {
                System.out.print("throws");
                for(int i=0;i<exceptionTypes.length;i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+",");
                }
            }
            System.out.println();
        }
    }

}
