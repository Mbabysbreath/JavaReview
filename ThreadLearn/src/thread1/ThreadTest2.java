package thread1;

/**
 * 多线程的创建：
 * 方式一（简化--匿名子类的匿名对象）
 * @author zhaomin
 * @date 2020/1/23 1:08
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println();
            }
        }.start();
    }
}
