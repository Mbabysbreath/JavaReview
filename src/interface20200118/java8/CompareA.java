package interface20200118.java8;

/**
 * JDK8中处理定义全局常量和抽象方法外，还可以定义静态方法、默认方法
 * @author zhaomin
 * @date 2020/1/18 19:10
 */
public interface CompareA {
    //静态方法
    public static void method1(){
        System.out.println("CompareA:北京");
    }
    //默认方法
    public default void method2(){
        System.out.println("CompareA:上海");
    }
    default void method3(){
        System.out.println("ComapareA:上海");
    }
}
