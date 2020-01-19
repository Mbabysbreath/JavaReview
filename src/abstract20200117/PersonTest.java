package abstract20200117;

/**
 * 抽象类的匿名子类
 * @author zhaomin
 * @date 2020/1/17 22:59
 */
public class PersonTest {
    public static void main(String[] args) {
        method(new Student());//匿名对象
        Worker worker=new Worker();
        method1(worker);//非匿名类和对象
        method1(new Worker());//非匿名类，匿名对象
        Person p=new Person(){//创建了匿名子类的对象
            @Override
            public void eat() {
                System.out.println("吃东西");
            }
        };
        method1(p);
    }

    public static void method(Student s){

    }

    public static void method1(Person p){
        p.eat();
    }
}
class Worker extends Person{
    @Override
    public void eat() {

    }
}