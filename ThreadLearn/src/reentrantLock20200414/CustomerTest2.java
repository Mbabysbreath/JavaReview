package reentrantLock20200414;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者改进
 * 用lock替换了synchronized
 * 两个线程交互，一个加1，一个减1
 * @author zhaomin
 * @date 2020/4/14 12:15
 */
class Source{
    int number=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public void incerment()  {
        lock.lock();
        try {
            //1.判断
            while (number != 0) {//避免虚假唤醒
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "加1--》" + number);
            //3.通知
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "减1-->" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}
public class CustomerTest2 {
    public static void main(String[] args) {
        Source source=new Source();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                        source.incerment();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                    source.decrement();
            }},"b").start();
    }
}
