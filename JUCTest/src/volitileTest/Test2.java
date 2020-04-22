package volitileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile不保证原子性
 * 解决不保证原子性的问题--AtomicInteger
 * @author zhaomin
 * @date 2020/4/21 16:25
 */
class Num{
    volatile int num=0;
    //20个线程对num进行加1操作，理论上应该为20000
    public void numAdd(){
        num++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void myAtomicAdd(){
        atomicInteger.getAndIncrement();//每次加1
    }
}
public class Test2 {
    public static void main(String[] args) {
        Num obj=new Num();
        for(int i=1;i<=20;i++) {
            new Thread(()->{
              for(int j=0;j<1000;j++){
                  obj.numAdd();
                  obj.myAtomicAdd();
              }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"获取结果为："+obj.num);
        System.out.println(Thread.currentThread().getName()+"获取结果为："+obj.atomicInteger);
    }
}
