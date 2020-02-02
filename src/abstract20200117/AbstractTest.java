package abstract20200117;

/**
 * 一、abstract关键字的使用
 1.abstract可以可以用来修饰的结构：类、方法
 2.abctract修饰类——抽象类
 》此类不能实例化
 》抽象类中一定有构造器，便于子类实例化时调用（类中一定会有构造器）
 》开发中，都会提供抽象类的子类，让子类实例化，完成相关操作
 3.abstract修饰方法——抽象方法
 》抽象方法只有方法的声明，没有方法体
 》包含抽象方法的类一定是抽象类，反之，抽象类中可以没有抽象方法
 》若子类重写了父类的所有抽象方法，子类方可实例化
 若子类没有重写父类所有的抽象方法，则此子类也是一个抽象类，需要用abstract修饰
 二、abstract使用上的注意点
 （1）abstract不能用来修饰属性、构造器等结构
 （2）abstract不能用来修饰私有方法（不能被重写），静态方法(static方法不能被重写)、
 final的方法（不能被重写）、final的类（不能被继承）
 （3）一定会用到继承
 * @author zhaomin
 * @date 2020/1/17 21:23
 */
public class AbstractTest {
    public static void main(String[] args) {
        Person p=new Student();
        p.walk();
       // Person p1=new Person();

    }

}
 abstract class Person{
    String name;
    int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
     abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }
}
 class Student extends Person{
    public Student(){
        super();
    }
  public Student(String name,int age){
      super(name,age);
  }
  public void eat(){
      System.out.println("学生吃好的");
  }
}