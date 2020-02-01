package exer;

import sun.util.cldr.CLDRLocaleDataMetaInfo;

/**
 * 线程通信的应用---生产者和消费者
 *  多线程问题--生产者线程、消费者线程
 *  共享数据--产品(店员)
 *  线程安全问题--三种
 *  线程通讯问题
 *
 * @author zhaomin
 * @date 2020/1/29 20:45
 */
class Clerk{
    private int productCount=0;
    //生产
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费
    public synchronized void consumeProduct() {
        if(productCount>0){

            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产。。。");
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
class Customer1 extends Thread{
    private Clerk clerk;
    public Customer1(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费。。。");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        Customer1 c1=new Customer1(clerk);
        c1.setName("消费者1");
        Customer1 c2=new Customer1(clerk);
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }
}
