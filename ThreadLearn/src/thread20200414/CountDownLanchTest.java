package thread20200414;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLaunch做线程减法，即所有线程执行完后，才可以进行下一步
 * @author zhaomin
 * @date 2020/4/15 8:35
 */
public class CountDownLanchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for(int i=0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"--离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main离开教室");

    }
}
