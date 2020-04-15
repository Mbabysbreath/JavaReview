package reentrantLock20200414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者--生产者
 *体现了相对于synchronized来说lock的优势，可以精准定位
 *
 * 场景：
 * 三个线程的调用顺序A\b\c\A
 * A打印5次--》B打印10次--》C打印15次--》A
 * 重复10轮
 *
 * 口诀：
 * 1.在高内聚低耦合的前提下：线程  操作  资源类
 * 2.判断--干活--通知
 * 3.在多线程交互的情况下，防止虚假唤醒（即判断写在while中）
 * 4.注意标志位
 * @author zhaomin
 * @date 2020/4/14 13:01
 */
class Resource1{
    int number=1;//标志位，代表三个线程ABC
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void printA5(){
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +"-->"+ i);
            }
            number=2;//重置标志位
            condition2.signal();//精准唤醒2
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB10(){
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void printC15(){
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class CustomerTest3 {
    public static void main(String[] args) {
        Resource1 resource=new Resource1();
        new Thread(()->{
            for(int i=0;i<10;i++){
                resource.printA5();
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                resource.printB10();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                resource.printC15();
            }
        },"C").start();
        Random random=new Random();
        ArrayList list=new ArrayList();
        Arrays.asList(new String("ac"));
    }
}
