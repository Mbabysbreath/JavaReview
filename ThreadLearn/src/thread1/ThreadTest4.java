package thread1;

/**
 * @author zhaomin
 * @date 2020/3/24 15:05
 * 验证多线程在一定的情况下可以提高程序的运行效率
 */
public class ThreadTest4 {
    private static final long num=10_0000_0000;
    public static void main(String[] args) throws InterruptedException {
        concurrency();//多线程情况下
        serial();//只有主线程
    }

    private static void serial() {
        long start=System.nanoTime();
        //全部在主线程内计算ab的值
        int a=0;
        int b=0;
        for(long i=0;i<num;i++) {
            a--;
        }
        for(long i=0;i<num;i++) {
            b--;
        }
//        System.out.println("ser--"+a+"  "+b);
        long end=System.nanoTime();
        double res=(end-start)*1.0/1000/1000;
        System.out.println("串行"+res);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.nanoTime();
        //一个线程计算a的值
        Thread thread=new Thread(){
            @Override
            public void run() {
                int a=0;
                for(long i=0;i<num;i++) {
                    a--;
                }
            }
        };
        thread.start();
        //主线程计算b
        int b=0;
        for(long i=0;i<num;i++) {
            b--;
        }
        //等待线程执行完毕，再执行后边语句
        thread.join();
//        System.out.println("ser--"+a+"  "+b);

        long end = System.nanoTime();
        double res=(end-start)*1.0/1000/1000;
        System.out.println("并发执行："+res);
    }
}
