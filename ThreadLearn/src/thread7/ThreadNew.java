package thread7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口---JDK5.0新增
 * （1）创建一个实现Callable接口的实现类
 * （2）重写call()方法，将此线程执行的操作声明在call()方法中，可以有返回值
 * （3）创建Callable接口实现类的对象
 * （4）将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，
 *     创建FutureTask的对象
 *  （5）将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，
 *     并调用start()
 *  (6)【可选，需要的话】获取Callable中call方法的返回值
 *
 *如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程强大
 *call()可以有返回值
 *call()方法可以抛出异常,被外面的操作捕获，获取异常的信息
 *Callable支持泛型的返回值
 *
 * @author zhaomin
 * @date 2020/1/30 11:49
 */
class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get()返回值为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object sum = futureTask.get();

            System.out.println("总和："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
