package generic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaomin
 * @date 2020/2/11 20:51
 * 自定义泛型类
 */
public class Order<T> {

    String orderName;
    int orderID;
    T orderT;

    public Order(){

    }

    public Order(String orderName, int orderID, T orderT) {
        this.orderID = orderID;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    //静态方法中不能使用类的泛型
    //因为泛型是在造对象时使用的，static静态结构早于对象的创建
/*
    public static void show(T orderT) {
        System.out.println(orderT);
    }
*/
     //泛型方法：在泛型方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //也就是说，泛型方法所处的类是不是泛型类，都没有关系
    //方法前说明这是一个泛型方法<E>
    //泛型方法，可以声明为静态的，泛型参数是在调用方法时确定的，并非在实例化类时确定
    public <E> List<E> asList(E[] arr){
        ArrayList<E> list = new ArrayList<E>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
