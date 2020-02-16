package ioTest;

import org.junit.Test;

import java.io.*;

/**对象流的使用：
 *
 * @author zhaomin
 * @date 2020/2/16 11:55
 * 1.ObjectInputStream和ObjectOutputStream
 *2. 对象的序列化机制：
 * 允许把内存中的Java对象转换成与平台无关的二进制流，从而允许把这种二进制流持久的保存在磁盘上，
 * 或通过网络讲这种二进制流传输到另一个网络节点。
 * 当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 * 3.要想一个java对象是可序列化的，需要满足相应的要求，见Person类
 * 以Person类为例进行对象的序列化
 * 4.除了当前Person类，还要保证类中所有属性都是可序列话的
 *   默认基本数据类型也是可序列话的
 * 5.补充：对象流不能序列化static和transiet修饰的成员变量
 */
public class ObjectStreamTest {
    /**
     * 序列化的过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            File file = new File("object.dat");
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(new String("王一博&照敏"));
            oos.writeObject(new Person("王一博",22));
            oos.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的java对象
     * 使用ObjectInputStream来实现
     */
    @Test
    public void test1(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str=(String)obj;
            System.out.println(str);

            Object o=ois.readObject();
            Person person=(Person) o;
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
