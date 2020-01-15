package oop20200113;

/**
 * @author zhaomin
 * @date 2020/1/14 22:44
 */
public class Dog extends Animal {
    @Override
    public void walk() {
        System.out.println("狗狗跑");
    }

    @Override
    public void eat() {
        System.out.println("狗狗吃骨头");
    }
}
