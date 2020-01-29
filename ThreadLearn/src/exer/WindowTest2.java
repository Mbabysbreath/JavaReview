package exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 * 使用同步代码块解决继承Thread类的线程安全问题
 * @author zhaomin
 * @date 2020/1/27 12:22
 */
class Window2 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run(){
        while(true) {
         //   synchronized (obj) {
                synchronized (Window2.class) {//类类型的对象也可以
                    //    synchronized(this) {错误，在继承这种方法的时候不能写this,因为new的时候会产生多个对象
                    if (ticket > 0) {
                        try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        System.out.println(getName() + "卖票：" + ticket);
                        ticket--;
                    }else{
                        break;
                    }
                }
            }
        }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1=new Window2();
        Window2 w2=new Window2();
        Window2 w3=new Window2();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
