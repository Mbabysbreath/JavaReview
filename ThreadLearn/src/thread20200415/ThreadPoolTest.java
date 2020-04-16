package thread20200415;

import java.util.concurrent.*;

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
//        ExecutorService threadPool= Executors.newCachedThreadPool();
        /*在实际开发中，要用自定义的线程池
        * ThreadPoolExecutor.AbortPolicy()---会跑一箱
        * ThreadPoolExecutor.CallerRunsPolicy()--多余的任务返回给调用者线程来执行
        * ThreadPoolExecutor.DiscardPolicy()--直接拒绝，默默工作--最好了
        * ThreadPoolExecutor.DiscardOldestPolicy()--踢掉最早来到阻塞队列等待的任务，给新任务腾地方*/
/**public ThreadPoolExecutor(int corePoolSize,
                            int maximumPoolSize,
                            long keepAliveTime,
                            TimeUnit unit,
                             BlockingQueue<Runnable> workQueue,
                            ThreadFactory threadFactory,
                             RejectedExecutionHandler handler) {*/
        ExecutorService threadPool= new ThreadPoolExecutor(
                2,
                3,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
