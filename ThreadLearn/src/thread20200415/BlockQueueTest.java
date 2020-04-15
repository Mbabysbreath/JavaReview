package thread20200415;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomin
 * @date 2020/4/15 17:09
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        //抛出异常
// 添加
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
       // System.out.println(blockingQueue.add("c"));java.lang.IllegalStateException: Queue full
//删除
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); java.util.NoSuchElementException
//检查
        //System.out.println(blockingQueue.element());java.util.NoSuchElementException

        //特殊值
//添加--如果队列已满，返回false
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        //System.out.println(blockingQueue.offer("a"));
////删除--如果队列已经为空，返回null
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//       // System.out.println(blockingQueue.poll());
//       // System.out.println(blockingQueue.poll());
////检测--如果队列为空，返回null,否则返回第一个元素
//        System.out.println(blockingQueue.peek());

        //阻塞
//添加--如果队列已满，put 方法会阻塞
       blockingQueue.put("a");
       blockingQueue.put("a");
       blockingQueue.put("a");
//      // blockingQueue.put("a");
////删除--如果队列为空，移除操作会阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());

        //过时不候
//添加--如果队列已满，添加操作的线程会等待一个时间，超过了就自己退出，并返回false
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
//移除--如果队列为空，等待一段时间后自己退出，返回null
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));

    }
}
