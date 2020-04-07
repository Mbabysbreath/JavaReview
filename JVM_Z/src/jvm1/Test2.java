package jvm1;

/**
 * @author zhaomin
 * @date 2020/4/6 18:55
 */
public class Test2 {
    //如果没有静态代码块或者静态变量，则不会自动生成clinit方法
    private int a=1;
    private static  int b=10;//会生成
    static {
        int c=4;
    }

    public static void main(String[] args) {
        int b=2;

    }
}
