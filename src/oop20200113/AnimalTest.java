package oop20200113;

/**面向对象的特征
        * 一、封装（模块化）
        * 1.问题的引入：
        * 当我们创建一个类的对象后，可以通过对象.属性的方式，对对象进行赋值。
        * 这里，赋值操作受到属性的数据类型和存储范围的制约，初次之外，没有其他制约条件。
        * 但是，在实际问题中，我们万网需要给属性赋值加入额外的限制条件，这个条件就不能在属性声明时体现
        * ，我们只能通过方法进行限制条件的添加
        * 同时，我们需要避免在使用“对象.属性”进行赋值，则需要将属性声明为私有化
        * --》此时，针对属性就体现了封装
        * 2.封装的体现：
        * （1）将类的属性私有化，同时提供public方法来获取和设置此属性的值
        * （2）不对外暴露的私有的方法
        * （3）单例模式(构造器私有化)
        * 3.封装性的体现，需要权限修饰符的配合
        * （1）Java的四种权限：
        *    private 缺省 protected public
 * (2)4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
         * （3）具体的：4种都可以修饰类的内部结构
         *    修饰类：缺省，public
 * 二、类的继承性（代码复用）
         *  （1）减少了代码的冗余，提高了代码的复用性
         *  （2）便于功能的扩展
         *  （3）为之后多态性的使用，提供了前提
         * 1.一旦子类继承了父类。子类就可以获取了父类的所有属性和方法
         *   包括私有private方法或属性，static属性和方法（可以访问。不能继承，不能重写）
         *   证明：
         *       属性:通过get()\set（int i）来进行设置和获取
         *       方法：将私有方法放在public方法中还是可以被调用的
         * 方法的重写：
         * 1.子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同
         * 2.子类重写的权限不小于父类（特殊：子类不能重写private方法）
         * 3.子类重写方法抛出的异常类型不大于父类
         * 4.返回值类型：
         *   （1）父类被重写的方法类型是void,子类重写也是void
         *   (2)父类被重写的方法类型是A,子类重写方法可以是A或A的子类
         *   （3）父类被重写的方法类型是基本数据类型,子类重写方法也是相同的基本数据类型
         *  5.不能重写static
         *为什么要重写：
         * （1）父类的情况不适用于子类，圆求面积，但圆柱体求表面积
         * （2）操作的多样化
         *  三、类的多态性（运行时行为，只有在运行后才能确定对象）
         *  1.什么是多态性：
         *  答：对象的多态性，就是父类的引用指向子类的对象
         *举例：Person p=new Man()(new的对象是多种形态的)
         *  2.什么是虚拟方法：
         *   p.eat()
         *   调用方法时，编译看左边，运行看右边
         *
         *  1.理解：一个事物的多种形态
         *  2.何为多态性（多态的使用）：动态绑定
         *  （1）对象的多态性：（向上转型）编译看左（父类），运行看右（子类），调用虚拟方法
         *       ①父类引用指向子类对象，当调用子父类同名参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
         *       ②如果子类没有重写该方法，则执行父类的方法.
         *       ③该子类对象不能调用自身的特有方法（编译会看左边的父类）
         *   (2)对象的多态性只适用于方法不适用于属性，属性都看左边的父类
         *   3.多态的使用前提：
         *   （1）类的继承关系
         *   （2）要有方法的重写
         *   4.为什么有多态性：可以通过传入不同的对象来控制不同的特征结果
         *   5.有了对象的多态性后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明为父类类型，
         *      导致编译时，只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用
         *
         *    如何调用子类特有的属性和方法：
         *     强制类型转换，（向下转型）将父类引用指向的对象转为为子类类型
         *     可能会出现ClassCastException异常，
         *     解决方法：Instanceof
         *     a instanceof A:判断对象a是否是A/A的子类的实例,如果true就向下转型
         *     如果 a instanceof A:为true，a instanceof B也为true，则B是A的父类
         *
         *   虚拟方法：在多态的情况下，父类的方法称为虚拟方法，父类根据赋给它的不同子类对象，
         *   动态调用属于子类的该方法，这样的方法在编译时时不确定的
         *
         *四、方法的重载和重写
         * （1）从定义看：
         *      重载：同一个类，可以方法名相同，形参列表不同，返回值不同,权限符不同
         *     重写(有子父类的关系)：方法名，形参列表相同，返回值，权限符与父类有关
         * （2）从编译和运行的角度
         *     重载：（不表现为多态性）允许存在多个同名的方法，编译器根据方法的不同的参数列表进行区分
         *            对编译器而言，这些同名方法就成了不同的方法，
         *            他们的调用地址在编译期间就确定了
         *            子类可以重载父类的同名不同参数的方法
         *            早绑定，静态绑定
         *    重写：可以理解为多态，动态绑定，玩绑定
         *    (3)static:重载可以，重写不行
        *       static 随着类的加载加载，不能被覆盖
        *   (4)构造器可以重载不能重写
        *五、super关键字
        * 1.调用属性，方法，
        * （1）一般省略
        * （2）子类、父类有同名属性时，要用super.属性来指明是调用父类
        *（3）子类重写父类方法后，在子类方法中调用父类被重写的方法时，要用super.方法
        *2.调用构造器
        *
 * @author zhaomin
 * @date 2020/1/13 14:19
 */
public class AnimalTest {
    public static void main(String[] args) {
        /*
        测试封装性
         */
        Animal animal=new Animal();
        animal.name="富贵";
        animal.age=1;
       // animal.legs = 4;//没有限制条件，不符合实际，
                        // 要添加限制条件通过方法setLegs(int leg)
        animal.setLegs(4);//但用户还是可以通过对象.legs改变legs的值，
                          // 所以要将这条路封起来，即private legs
        System.out.println("-----======================-------");
        /*
        测试多态性
         */
        System.out.println();
        Animal cat=new Cat();
        cat.name="hh";
        //如何才能调用子类特有的属性和方法，
        // 使用强制类型转化符，向下转型。将父类引用指向的对象转为子类的引用对象
        Cat cat1=(Cat)cat;
        /*
        可能会出现ClassCastException异常，解决方法：instanceof
        */

        if(cat instanceof Cat){
            Cat dog=(Cat) cat;
            dog.eat();
        }
        System.out.println(cat.age);//对于属性，编译和运行都看左边的父类
        AnimalTest animalTest=new AnimalTest();
        animalTest.func(cat);
        animalTest.func(new Dog());
        animalTest.func(new Animal());
        cat.setLegs(4);
    }

    public void func(Animal animal){
        animal.eat();
        animal.walk();
    }
    private int func(){
        System.out.println("hah ");
        return 1;
    }
}
class Animal{
    static  String name;
    int age;
    private int legs;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0)
        this.age = age;
    }

    //对属性的设置
    public void setLegs(int leg){
        if(leg>=0&&leg%2==0){
            legs=leg;
        }else{
            legs=0;
        }
    }
    //对属性的获取
    public int getLegs(){
        return legs;
    }
    public void walk() {
        System.out.println("动物走路");
    }
    public void eat(){
        System.out.println("动物吃");
    }

}
