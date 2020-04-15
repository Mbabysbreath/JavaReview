package reentrantLock20200414;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：ReentrantLock
 * 可以只给需要的代码行进行加锁
 * @author zhaomin
 * @date 2020/4/13 23:47
 */
class Ticket{//资源类
    private int number=30;
    private Lock lock = new ReentrantLock();

    public void saleTickets(){
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出第：" + number-- + "张票，还剩下：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 题目：三个售票员 卖出 30张票
 * 多线程编程的套路+模版
 * 在高内聚低耦合的前提下：线程  操作（对外暴露的调用方法）  资源类
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=40;i++) {
                    ticket.saleTickets();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=40;i++) {
                    ticket.saleTickets();
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=40;i++) {
                    ticket.saleTickets();
                }
            }
        },"CC").start();
        //Lambada表达式
        new Thread(()->{for(int i=1;i<=40;i++)
            ticket.saleTickets();
        },"A").start();
    }

}
