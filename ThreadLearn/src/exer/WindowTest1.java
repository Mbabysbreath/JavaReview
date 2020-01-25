package exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张,使用实现Runnable接口的方式
 *仍然存在线程安全问题，三个窗口都迈出100号票
 * @author zhaomin
 * @date 2020/1/23 23:34
 */
class Window1 implements Runnable {
    /*只创造了一个Window1对象,因此可以实现100张票共享*/
    private int ticket=100;
    @Override
    public void run() {
        while(true){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                ticket--;
            }else{
                break;
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
