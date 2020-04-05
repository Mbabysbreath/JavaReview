package test;

/**
 * @author zhaomin
 * @date 2020/3/24 10:15
 */
public class StaticTest {
    //静态代码块，对于定义在它之后的变量可以赋值，不能访问
    static {
        c=6;//编译通过
       // System.out.println(c);//报错
    }
   public static int c;

    public static void main(String[] args) {
        System.out.println(c);
    }
}
