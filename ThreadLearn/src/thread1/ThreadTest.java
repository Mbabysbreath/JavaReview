package thread1;

/**
 * 多线程的创建：
 * 方式一：继承于Thread类
 * 1.创建一个集成与Thread类的子类
 * 2.重写Thread类的run()
 *   ----将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过该对象调用start()
 * ---①启动当前线程
 * ---②调用当前线程的run()方法
 * 问题一：如果不调用start()，直接调用run()，
 * -----就相当于没有启动新线程，run中的语句会执行，
 * -----但调用者是主线程，创建的线程类很普通类一样，
 * -----里边的方法会按照调用顺序执行
 *问题二：同一个线程对象只能start()启动一次，否则会报异常
 * 例子：遍历100以内的所有偶数
 * @author zhaomin
 * @date 2020/1/23 0:19
 */
class MyThread extends Thread{
    @Override
    public void run() {
        Thread.yield();

        for (int i = 0; i < 100; i++) {

                System.out.println(Thread.currentThread().getName());
//                System.out.print(i + "-- ");


        }
    }
}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==============");
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.start();
        t2.start();

        //t1.run();
       // t1.start();
//        for(int i=0;i<10;i++) {
//            System.out.println("hello----1");
//        }
        //Thread.yield();
    }
}
