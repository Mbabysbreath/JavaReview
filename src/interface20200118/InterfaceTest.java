package interface20200118;

/**
 * @author zhaomin
 * @date 2020/1/18 14:38
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flable.MAX_SPEED);//体现了接口中常量都是静态的
       // Flable.MAX_SPEED=80;//体现了接口常量是final的
        Flable f=new Plane();
        f.fly();
    }
}
interface Flable{
    //全局常量
     public static final int MAX_SPEED=7900;//第一宇宙速度
     int MIN_SPEED=1;
     //抽象方法
    public abstract void fly();
    //省略了public abstract
    void stop();
}
interface Attackable{
    void attack();
}
class Plane implements  Flable{
    @Override
    public void fly() {
        System.out.println("飞机起飞");
    }

    @Override
    public void stop() {
        System.out.println("减速停止");
    }
}
abstract class Kite implements Flable{
    @Override
    public void fly() {

    }
}
class Bullet extends Object implements Flable,Attackable,CC{
    @Override
    public void fly() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

//*******************
interface AA{
    void method1();
}
interface BB{
    void method2();
}
interface CC extends AA,BB{

}