package jvm1;

import java.util.Currency;

/**
 * @author zhaomin
 * @date 2020/4/6 22:02
 */
public class Test4 {
    //虚拟机必须保证一个类的<clinit>（）方法在多线程下被同步执行
    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("开始");
                Hello hello=new Hello();
                System.out.println("结束毕");
            }
        };
       Thread thread1=new Thread(r,"线程1");
       Thread thread2=new Thread(r,"线程2");
        thread1.start();
        thread2.start();
    }
}
class Hello{
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + ":初始化当前类");
            while (true){

            }
        }
    }
}