package thread1;

/**
 * 创建多线程的方式二：实现Runnable 接口
 * （1）创建一个实现了Runnable接口的类
 * （2）实现类去实现Runnable中的抽象方法，run()
 * （3）创建实现类的对象
 * （4）将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * （5）通过Thread类的对象调用start()
 *
 * 比较两种创建线程的方式：
 * 开发中优先选择:实现Runnable接口的方式
 * 原因：（1）实现的方式没有类的单继承性的局限性
 *       （2）实现的方式更适合处理多个线程共享数据的情况
 * 联系：Thread类也实现了Runnable接口
 * 相同点：两种方式都需要覆盖run(),将线程要执行的逻辑声明在run()方法中
 * @author zhaomin
 * @date 2020/1/23 23:02
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t1 = new Thread(m);
        t1.setName("Thread-1:");
        t1.start();
        //再启动一个线程，遍历50以内的偶数
        //不用再创建Runnable的对象
        Thread t2=new Thread(m);
        t2.setName("Thread-2");
        t2.start();
    }
}
