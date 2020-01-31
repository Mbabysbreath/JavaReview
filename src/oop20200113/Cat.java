package oop20200113;

/**
 * @author zhaomin
 * @date 2020/1/14 22:29
 */
public class Cat extends Animal {
    int age=10;
    @Override
    public void walk() {
        System.out.println("喵喵走路");
    }

    //@Override
  //  public void eat() {
    //    System.out.println("喵喵吃鱼");
  //  }

    public void shout(){
        System.out.println("喵喵叫");
    }

    @Override
    public void setLegs(int leg) {
        super.setLegs(leg);
    }
}
