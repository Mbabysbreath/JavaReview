package thread20200414;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 抢车位，狼多肉少-3个资源6和线程
 * @author zhaomin
 * @date 2020/4/15 15:06
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();//获取到了资源，就让资源数减一
                    System.out.println(Thread.currentThread().getName()+"抢占车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    semaphore.release();//释放资源就让资源加一
                }

            },String.valueOf(i)).start();
        }
    }
}
