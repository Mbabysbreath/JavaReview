package volitileTest;

/**
 * 验证volitile的可见性
 * @author zhaomin
 * @date 2020/4/21 15:44
 */
class MyData{
    volatile int num=0;
    public void addTo60(){
        this.num=70;
    }
}
public class Test1 {
    public static void main(String[] args) {
        MyData data=new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "进来了。。。");
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName()+"将值改为"+data.num);

        },"AAA").start();


        while (data.num==0){

        }
        System.out.println(Thread.currentThread().getName() + "近啦了");
            System.out.println(Thread.currentThread().getName()+"获取num="+data.num);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "近啦了");
            System.out.println(Thread.currentThread().getName()+"获取num="+data.num);
        },"BBB").start();
    }
}
