package exer;

/**
 * 使用同步方法解决继承Thread类创建多线程
 * @author zhaomin
 * @date 2020/1/27 23:17
 */
class Window4 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run(){
        while(true) {
            show();

            }
        }
    private static synchronized void show(){//此时同步监视器：Window4.class
    //private  synchronized void show(){//同步监视器的对象不唯一，和new 有关
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1=new Window4();
        Window4 w2=new Window4();
        Window4 w3=new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}

