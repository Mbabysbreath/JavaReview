package exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张
 * --使用继承Thread类的方式
 * 存在线程安全问题，三个窗口都卖出了100号的票
 * 待解决
 * @author zhaomin
 * @date 2020/1/23 22:47
 */
 class Window extends Thread {
     /*使用static实现100张票共享*/
    private static int ticket=100;
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
public class WindowTest{
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}


