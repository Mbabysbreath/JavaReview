package ioTest;

import java.io.Serializable;

/**
 * Person需要满足如下的要求：
 * 1.需要实现接口：Serializable
 * 2.当前类需要提供一个全局常量serialVersionUID要提供一个序列化的版本号
 * @author zhaomin
 * @date 2020/2/16 12:27
 */
public class Person implements Serializable {
    private static final long serialVersionUID=87431327182349L;
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

