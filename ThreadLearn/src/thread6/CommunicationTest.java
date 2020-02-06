package thread6;

/**
 * 线程通信的例子：
 * 使用两个线程打印1-100，交替打印
 * 涉及到的方法：
 * wait()--一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()--一旦执行此方法，就会唤醒wait的一个线程，如果有多个线程wait，就唤醒优先级高的
 * notifyAll()---一旦执行此方法，会唤醒所有被wait的线程
 *
 * 说明：
 * （1）实现线程通信wait()\notify()\notifyAll()三个方法必须使用在同步代码块或同步方法中
 * （2）上述三个代码的调用者必须是同步代码块或同步方法中的同步监视器
 *      否则会出现异常java.lang.IllegalMonitorStateException
 *  (3)wait()\notify()\notifyAll()在java.lang.Object类中
 *
 *  面试题：sleep()和wait()方法的异同
 *  （1）相同点：一旦执行方法，都可以使当前线程进入阻塞状态
 *  （2）不同点：
 *       a)两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *       b)调用的要求不一样，sleep()可以在任何需要的场景调用，
 *        wait()必须使用在同步代码块或同步方法中
 *      c)关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中：
 *         sleep()--不会释放锁，wait()会释放锁
 *      d)sleep()时间到了，线程就被唤醒
 *        wait()需要使用notify/notifyAll（）来唤醒
 * @author zhaomin
 * @date 2020/1/29 20:00
 */

public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
class Number implements Runnable{
    private int number=1;
    private Object obj=new Object();
    @Override
    public void run() {
        while(true){
           // synchronized (this){
            synchronized (obj){//调用notify的对象要和同步监视器是同一个对象，否则会抛异常
                               //加上obj.wait(),obj.notify,obj.notifyAll()
               // notify();
               obj.notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                       // wait();
                       obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}