package thread20200414;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 第三种创建多线程的方式：实现Callable接口
 * @author zhaomin
 * @date 2020/4/14 23:02
 */
class MyThread implements Callable<String>{
    @Override
    public String call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);//设置时间
        System.out.println("--实现Callable接口--");
        String string = UUID.randomUUID().toString();//获取随机数
        return UUID.randomUUID().toString();
    }
}
public class CallableTest {
    public static void main(String[] args) {
        MyThread callable=new MyThread();
        FutureTask futureTask=new FutureTask(callable);

        Thread thread=new Thread(futureTask);
        thread.start();
        new Thread(futureTask).start();//两个线程，一个futureTask，只执行一次
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
