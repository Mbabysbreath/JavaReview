package singleton;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 单例模式的懒汉式实现
 * @author zhaomin
 * @date 2020/1/18 20:19
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order o1=Order.getInstance();
        Order o2=Order.getInstance();
        System.out.println(o1==o2);
    }

}
/*懒汉式*/
class Order{
    //1.私有化构造器
    private Order(){

    }
    //2.声明当前类对象,static
    private static Order instance=null;
    //3.public static的返回当前类对象的方法
    public static Order getInstance(){
            if(instance==null){
                instance=new Order();
            }
            return instance;
    }
}