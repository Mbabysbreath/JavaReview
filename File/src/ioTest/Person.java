package ioTest;

import java.io.Serializable;

/**
 * Person需要满足如下的要求：
 * 1.需要实现接口：Serializable
 * 2.当前类需要提供一个全局常量serialVersionUID要提供一个序列化的版本号
 * 3.static和transient修饰的变量不能被序列化
 * @author zhaomin
 * @date 2020/2/16 12:27
 */
public class Person implements Serializable {
    //如果序列化版本号注释掉，而没有重新执行序列化操作时，那么再次直接执行反序列化时，会报异常
    private static final long serialVersionUID=87431327182349L;
    private String name;
    private int age;
    private static int id;

    public Person() {

    }

    public Person(String name, int age,int id) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Person.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +",id"+id+
                '}';
    }
}

