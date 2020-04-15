package thread20200414;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读读可同时
 * 读写、写写要独占
 * @author zhaomin
 * @date 2020/4/15 16:10
 */
class Book{
    private volatile Map<String,String> map=new HashMap<>();
    ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void put(String key, String val) {
        readWriteLock.writeLock().lock();//加写锁
        try{
            System.out.println("正在写---");
            map.put(key,val);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写入-"+key);
            System.out.println("写完了---");
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
        readWriteLock.readLock().lock();//加读锁
        try{
            System.out.println("读书中---");
            String s = map.get(key);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取-"+s);
            System.out.println("读完了---");
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
}
public class ReadWriteLockTest {
    public static void main(String[] args) {
        Book book=new Book();
        for(int i=1;i<5;i++) {
            final int tem=i;
            new Thread(()->{

                book.put(String.valueOf(tem),String.valueOf(tem));

            },String.valueOf(i)).start();
        }

        for (int i=1;i<=5;i++) {
            final int tem=i;
            new Thread(()->{

                book.get(String.valueOf(tem));

            },String.valueOf(i)).start();
        }
    }

}
