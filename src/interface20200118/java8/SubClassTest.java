package interface20200118.java8;

/**
 * @author zhaomin
 * @date 2020/1/18 19:14
 */
public class SubClassTest  {
    public static void main(String[] args) {
        SubClass s=new SubClass();
        /*1.接口中定义的静态方法，只能通过接口来调用，实现类的对象不能调用*/
        //s.method1();
        //SubClass.method1();
        CompareA.method1();
        /*2.通过实现类的对象，可以调用接口中的默认方法
        * 如果实现类重写了接口中的默认方法，调用时，仍然调用的时重写以后的方法*/
        s.method2();
        s.method3();
        //类优先原则，只针对方法
        /*3.如果子类或实现类继承或实现的接口生命力同名同参数的方法
        * 那么子类在没有重写此方法的情况下，默认调用的是父类的种的同名同参数的方法*/
        //接口冲突
        /*4.如果实现类实现了多个接口，而者多个接口种定义了同名同参数的默认方法，
        * 那么在实现类没有重写此方法的情况下，会报错*/
        /*5.用接口.super.方法名（）来调用接口中的默认方法*/
        s.myMethod();

    }
}
class SubClass extends SuperClass implements CompareA,CompareB{
    @Override
    public void method2() {
        System.out.println("SubClass:上海");
    }
    public void myMethod(){
        method2();//调用自己定义的重写方法
        super.method3();//调用父类种声明的方法
        CompareA.super.method3();//调用接口中的默认方法
        CompareB.super.method3();
    }
}