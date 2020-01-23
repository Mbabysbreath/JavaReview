package exer;

/**
 * 练习：
 * 创建两个分线程，一个遍历100以内的偶数，一个遍历奇数
 * @author zhaomin
 * @date 2020/1/23 1:00
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0)
            System.out.println(Thread.currentThread().getName()+"-->"+i+" ");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 m1=new MyThread1();
        MyThread2 m2=new MyThread2();
        m1.start();
        m2.start();
        /*利用匿名子类的匿名对象来实现*/
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2==0)
                        System.out.println(Thread.currentThread().getName()+"-->"+i+" ");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2!=0)
                        System.out.println(Thread.currentThread().getName()+"-->"+i+" ");
                }
            }
        }.start();
    }
}
