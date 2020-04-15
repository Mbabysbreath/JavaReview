package thread20200415;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池：ThreadPoolExecutor
 * @author zhaomin
 * @date 2020/4/15 23:39
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //一池多线程
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        //一池一线程
       // ExecutorService threadPool= Executors.newSingleThreadExecutor();
        //一池N线程
        ExecutorService threadPool= Executors.newCachedThreadPool();

        for(int i=0;i<10;i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
