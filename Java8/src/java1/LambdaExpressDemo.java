package java1;

/**
 * @author zhaomin
 * @date 2020/4/14 0:17
 */
//接口中只有一个方法的--函数式接口
//函数是接口的注解
@FunctionalInterface
interface Foo {
    //public void sayHello();
    public int add(int x,int y);
    default int div(int x,int y){
        System.out.println("==defalut==");
        return x/y;
    }

    public static int mv(int x, int y) {
        return x*y;
    }
}
@FunctionalInterface
interface Foo1{
    public void sayHello();

}
/**
 * Lambda Express--函数式接口可以使用--接口中只有一个普通方法,可以多个default方法，多个static方法
 * 1.口诀：
 * 拷贝小括号，写死右剪头，落地大括号
 * 2.@FunctionalInterface
 * 3.default--接口中的方法有方法体实现
 * 4.静态方法实现
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo1 foo = new Foo1() {
            @Override
            public void sayHello() {
                System.out.println("+++++hello+++");
            }
        };
        foo.sayHello();

        /**
         * Lambda Express--函数式接口可以使用--接口中只有一个方法
         * 口诀：
         * 拷贝小括号，写死右剪头，落地大括号
         */
        Foo1 foo1 = () -> {
            System.out.println("+++++hello+++"); };
        foo1.sayHello();

        Foo foo2=(x,y)->{
            System.out.println("come in here");
            return x+y;
        };
        System.out.println(foo2.add(2, 6));
        System.out.println(foo2.div(4, 2));
        System.out.println(Foo.mv(3, 6));
    }
}
