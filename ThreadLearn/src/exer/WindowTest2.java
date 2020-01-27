package exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用继承Thread类的方式
 * 使用同步代码块解决Thread类的线程安全问题
 * @author zhaomin
 * @date 2020/1/27 12:22
 */
class Window2 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run(){
        while(true){
            synchronized(obj) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(getName() + "卖票：" + ticket);
                    ticket--;
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
