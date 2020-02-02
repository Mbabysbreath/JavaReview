package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户，
 * 两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
 * 分析：
 * 1.多线程问题--两个储户线程
 * 2.有共享数据--账户余额
 * 3.有线程安全问题
 * 4.解决线程安全问题--同步机制
 * @author zhaomin
 * @date 2020/1/29 17:14
 */
class Account{
    private double balance=0;
    public Account(double balance){
        this.balance=balance;
    }
    //存钱
    public  void deposit(double amt){
        if(amt>0){
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+":存钱成功，余额为："+balance);
        }
    }
}
class Customer extends Thread{
    private Account acct;
    private static ReentrantLock lock=new ReentrantLock();
    public Customer(Account acct){
        this.acct=acct;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            lock.lock();
            acct.deposit(1000);
            lock.unlock();
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
