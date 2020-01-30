package thread5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全的方式三：Lock锁---JDK5.0新特性
 *
 *1.面试题：synchronized和ReentrantLock （Lock）的异同
 * 相同：二者都可以解决线程安全问题
 * 不同：
 *  (1)synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *     Lock需要手动的启动同步（lock()）,结束同步（unLock()）
 *  (2)Lock只有代码块锁
 *     synchronized有代码快和方法锁
 *  （3）使用Lock锁，JVM会花费较少时间来调度线程，性能更好。并且具有更好的扩展性（提供更好的子类）
 * 优先使用顺序：
 * Lock--同步代码快（已经进入方法题，分配了相应的资源）--同步方法（在方法体之外）
 *2.面试题：如何解决线程安全问题？有几种方式
 * @author zhaomin
 * @date 2020/1/29 13:04
 */
class Window implements Runnable{
    private int ticket=100;
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
           try{
               //调用锁定lock方法
               lock.lock();
               if(ticket>0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + "售票：" + ticket);
                   ticket--;
               }else{
                   break;
               }
           }finally {
               //3.调用解锁方法
               lock.unlock();
           }
        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread w1=new Thread(window);
        Thread w2=new Thread(window);
        Thread w3=new Thread(window);
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
