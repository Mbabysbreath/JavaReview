package reflection3;

import java.util.Comparator;

/**
 * @author zhaomin
 * @date 2020/2/21 23:35
 */
@MyAnnotation(value = "hi")
public class Person1 extends Creature<String> implements Comparable<String>,MyInterface {

    private  String name;
    int age;
    public int id;

    public Person1(){

    }
    @MyAnnotation(value = "abc")
    private Person1(String name) {
        this.name = name;
    }

      Person1(String name, int age) {
        this.age=age;
        this.name=name;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的丑八怪");
    }
    @MyAnnotation
    private String  show(String nation,String pov){
        System.out.println("我的国籍是：" + nation);
        System.out.println("我的省份是："+pov);
        return nation;
    }

    public String display(String interests)throws NumberFormatException{
        return interests;
    }
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
