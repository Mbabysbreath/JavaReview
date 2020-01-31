package singleton;

/**单例设计模式---减少系统的开销
 * 1.采取一定的方法保证在整个的软件设计系统中，对某个类只能存在一个对象实例
 * 2.如何实现
 * (1)饿汉式
 * （2）懒汉式
 * 3.区分饿汉式和懒汉式
 * 饿汉式：
 *          坏处：对象加载时间过长
 *          好处：线程安全的
 * 懒汉式：
 *          好处：延迟对象的创建
 *          坏处：目前的写法是不安全的--》多线程时修改
 *
 * @author zhaomin
 * @date 2020/1/18 20:09
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1=Bank.getInstance();
      //  Bank b1=Bank.instance;
      //  Bank b=Bank.instance;
        Bank bank2=Bank.getInstance();
        System.out.println(bank1==bank2);
    }


}
/*饿汉式*/
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象，为私有静态的
    public static Bank instance=new Bank();
   // private static Bank instance=new Bank();
    //3.提供静态公共的方法，返回类的对象
    public static Bank getInstance(){

        return instance;
    }

}