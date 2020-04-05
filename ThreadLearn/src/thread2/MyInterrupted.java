package thread2;

/**
 * @author zhaomin
 * @date 2020/3/24 22:18
 * 线程中断的两种方式：
 * 1.标志位
 * 2.interrupt()
 */
public class MyInterrupted {

    public static void main(String[] args) throws InterruptedException {
        MyThreadTest t=new MyThreadTest("线程1");
       // t.start();
       //Thread.sleep(1);
        t.flag=true;
        System.out.println("=======================");
        MyThread2 t2=new MyThread2();
        //t2.start();
       // t2.interrupt();
//        System.out.println(t2.isInterrupted());
//        System.out.println(t2.isInterrupted());

        MyThread3 t3=new MyThread3();
        t3.start();
        t3.interrupt();
        System.out.println(t3.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }
}
class MyThreadTest extends Thread{
    public static volatile boolean flag=false;
    @Override
    public void run() {

        //1.标志位
        while(!flag){
            System.out.println(Thread.currentThread().getName()+"是否中断---"+
                    Thread.currentThread().isInterrupted()+
                    "------"+
                    Thread.currentThread().getState());
        }
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getState());
    }

    public MyThreadTest() {
    }

    public MyThreadTest(String name) {
        super(name);
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {

    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(Thread.currentThread().getName()+"是否中断---"+
                    Thread.currentThread().isInterrupted()+
                    "------"+
                    Thread.currentThread().getState());
        }
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(Thread.currentThread().getName()+"是否中断---"+
                    Thread.currentThread().isInterrupted()+
                    "------"+
                    Thread.currentThread().getState());
        }
    }
}