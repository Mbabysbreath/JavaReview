package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS--比较并交换
 * @author zhaomin
 * @date 2020/4/22 11:11
 */
public class CASTest {
    public static void main(String[] args) {
        //设定初始值为5
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //main线程在工作一段时间后，要将自己的工作内存的值写进主内存
        //main的期望值是5，如果期望值与atomicInteger的值一样，就更新我指定的值，
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "值为" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020, 21) + "值是：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020, 21) + "值是：" + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
