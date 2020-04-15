package thread20200414;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程加法，只有等到一定数量的线程都开启后，才进行下一步(执行runnable里的方法)
 * @author zhaomin
 * @date 2020/4/15 8:51
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐7颗龙珠，召唤神龙");
            }
        };
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,runnable);

        for(int i=0;i<7;i++){
            final  int  count=i;//Lambda表达式中的变量必须是final的
            new Thread(()->{
                System.out.println(count+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
