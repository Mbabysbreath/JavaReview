package exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用实现Runnable接口的方式
 *仍然存在线程安全问题，三个窗口都卖出100号票
 * （1）问题：卖票的过程出现重票和错票
 * （2）原因：当某个线程操作车票的过程中，尚未操作完成，其他线程参与进来，也操作车票
 * （3）解决：当一个线程a在操作共享对象时，其他线程不能参与进来，直到线程a操作完毕，其他
 *       线程才可以开始操作共享对象。
 *       这种情况，即使线程a出现了阻塞，也不能被改变
 * （4）java中通过同步机制，来解决线程的安全问题：
 * 方式一：同步代码块
 *          synchronized(同步监视器){
 *              //需要被同步的代码（操作共享数据的代码）
 *              //共享数据：多个线程共同操作的变量
 *              //不能包含太多，不也能包太少
 *          }
 *          同步监视器----俗称：锁，任何一个类的对象,都可一充当锁
 *          要求：多个线程必须要共用同一把锁,唯一
 *          补充：
 *              在实现Runnable接口中，使用this做同步监视器
 *              在继承Thread类创建多线程的方式中，使用线程类.class作为同步监视器，慎用this
 *
 * 方式二：同步方法
 * 将需要进行同步的代码放在一个方法中，给方法加上synchronized
 * 关于同步方法的总结：
 * ①同步方法仍然涉及到同步监视器，只是不需要显示声明
 * ②非静态的同步方法：同步监视器是：this
 *   静态的同步方法：同步监视器是当前类的本身类.class
 * （5）好处----同步的方式，解决了线程的安全问题
 *     局限性----操作同步代码时，只能有一个线程参与，其他线程等待。
 *            相当于是一个单线程的过程，效率低
 * @author zhaomin
 * @date 2020/1/23 23:34
 */
class Window1 implements Runnable {
    /*只创造了一个Window1对象,因此可以实现100张票共享*/
    private int ticket=100;
    Object ob=new Object();
    @Override
    public void run() {
        while(true){
            synchronized(this) {//此时的this：唯一的window1对象，不用在另外创建一个类的对象
           // synchronized(ob) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();
        Thread w1=new Thread(w);
        Thread w2=new Thread(w);
        Thread w3=new Thread(w);
        w1.setName("窗口1：");
        w2.setName("窗口2：");
        w3.setName("窗口3：");
        w1.start();
        w2.start();
        w3.start();
    }
}
