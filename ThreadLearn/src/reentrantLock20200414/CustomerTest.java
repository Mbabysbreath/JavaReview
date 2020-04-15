package reentrantLock20200414;

/**
 * 生产者-消费者
 * 1.高内聚低耦合的前提下，线程操作资源类
 * 2.判断、干活、通知
 * 3.多线程交互中，防止多线程的虚假唤醒，也即判断要用while,不能用if
 * @author zhaomin
 * @date 2020/4/14 11:01
 */
class Resource{//资源类
    int number=0;
    public  synchronized void   increment() throws InterruptedException {
        //1.判断
        while(number!=0){
            this.wait();
        }
        //2.干活
        number++;
        System.out.println(Thread.currentThread().getName()+"加一num="+number);
        //3.通知
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while(number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "减一num=" + number);
        this.notifyAll();
    }
}
public class CustomerTest {
    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
