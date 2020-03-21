package thread7;

import java.util.concurrent.*;

/**
 * @author zhaomin
 * @date 2020/3/20 19:52
 */
public class CallableRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // test();
        test1();
    }
    public static void test(){
        /**
         * 使用场景：需要在某个地方阻塞等待线程执行完毕，并获取线程执行的结果
         */
        Callable callable=new Callable() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"--call");
                return 1;
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(Thread.currentThread().getName() + "子线程run，before get()");
        try {
            //FutureTask.get()会进行阻塞等待，直到子线程执行完毕，并由get方法获取返回值
            System.out.println(Thread.currentThread().getName()+"get:"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "子线程run,after get()");
    }

    public static void test1() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future future = pool.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+":call");
                return "call finish";
            }
        });
        System.out.println(Thread.currentThread().getName() + "pool submit,before submit");
        System.out.println(Thread.currentThread().getName()+"get:"+future.get());
    }
}
