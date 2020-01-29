package exer;

/**
 * 三个窗口卖100张票
 * 用同步方法解决，实现Runnable接口创建多线程
 * @author zhaomin
 * @date 2020/1/27 23:02
 */

class Window3 implements Runnable {
    /*只创造了一个Window1对象,因此可以实现100张票共享*/
    private int ticket=100;
    @Override
    public synchronized void run() {
        while(true){
                show();
            }
        }
    private synchronized void show(){
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

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w=new Window3();
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

