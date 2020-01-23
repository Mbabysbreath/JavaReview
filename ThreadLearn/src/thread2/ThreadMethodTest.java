package thread2;


/**
 * 测试Thread中的常用方法：
 * （1）start()--------------启动当前线程，调用当前线程的run()
 * （2）run()----------------通常需要重写Thread类中的此方法，
 *                          将创建的线程要执行的操作生命在此方法中
 * （3）currentThread()-----静态方法，返回执行当前代码的线程
 * （4）getName()-----------获取当前线程的名字
 * （5）setName(String name)--------设置当前线程的名字
 *                         ①Thread.currentThread.setName(String name);
 *                        ②Thread(String name)--利用有参构造器直接传入参数
 * （6）yield()------------释放当前CPU的执行权
 * (7)join()--------------在线程a中调用线程b的join()方法，线程a会进入阻塞状态，
 *                        直到等待线程b执行往后，a才结束阻塞状态。
 *（8）sleep(long milltime)-静态方法--让当前线程“睡眠”指定的milltimes毫秒，
 *                          在指定的milltime毫秒时间内，当前线程阻塞
 *（9）isAlive():判断当前线程是否存活
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY:10
 *  MIN_PRIORITY:1
 *  NORM_PRIOROTY:5
 * 2.高优先级的线程要抢占低优先级线程CPU的执行权，
 *   但是，只是从概率上讲，高优先级的线程高频率的情况下被执行，
 *  并不意味着只有当高优先级的线程执行完后，低优先级的线程才执行
 *
 * @author zhaomin
 * @date 2020/1/23 9:16
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+
                    Thread.currentThread().getPriority()+"-->"+i);
            //sleep()
            try {//只能用try-catch处理，因为父类没用过Throws，子类也不能用
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //yield()
           /* if(i%2==0){
                yield();
            }*/
        }
    }
//空参构造器
    public MyThread() {
        super();
    }
//可以命名的构造器
    public MyThread(String name) {
        super(name);
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.setName("Thread-1");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        //直接在构造器传入参数命名
        MyThread t1=new MyThread("Thread-2");

        t1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+
                    Thread.currentThread().getPriority()+"---"+i);
            if(i==20){
                try {
                    //join（）方法
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
        System.out.println(Math.cos(Math.toRadians(60)));
    }
}
