package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题的引入和解决（原子引用+版本号）
 * @author zhaomin
 * @date 2020/4/22 16:01
 */
public class ABATest {
    //普通的原子引用
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    //解决ABA
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        System.out.println("+++++++++++++以下是ABA问题的引入++++++++++");
        //虽然A线程从100-101--100已经进行过一次修改了，但从结果可以看到：B并不知晓
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"AA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"修改状态："+
                    atomicReference.compareAndSet(100, 2020)+"\t"+atomicReference.toString());
        },"BB").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("++++++以下是ABA问题的解决++++++++++");
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "第一次获取版本号" + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //试图引入ABA问题
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "获取版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "获取版本号：" + atomicStampedReference.getStamp());
        },"CC").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次获取版本号：" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicStampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"修改状态："+b+"第二次获取版本号：" + atomicStampedReference.getStamp());
        },"DD").start();
    }
}
