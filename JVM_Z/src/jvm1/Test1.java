package jvm1;

/**
 * @author zhaomin
 * @date 2020/4/6 18:27
 */
public class Test1 {
    //iconst:变量取值为1-5，bipush:-128到127
    //1.clinit方法会将静态类变量的初始化和静态代码块初始化合并在一起
    private static int a=1;
    int v=9;
    static {
        a=2;

        System.out.println(a);
        number=10;
        //a=number;//可以赋值但不能调用，为什么？只分配了内存空间没声明变量，不能调用？
      //  System.out.println(number);//报错，非法向前引用
    }
    //linking环节的prepare已经将变量加载到内存中并初始化为0
    //所以在初始化initial的环节可以对变量先进性初始化10，在覆盖为10
    private static int number=20;


    public static void main(String[] args) {
        int c=1;
        int d=c;
        c=2;
        System.out.println("c"+c);
        System.out.println("d"+d);
        System.out.println(a);
      System.out.println(number);

    }
}
