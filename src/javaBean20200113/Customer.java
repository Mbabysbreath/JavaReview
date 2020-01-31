package javaBean20200113;

/**
 * 一、JavaBean
  *  是一种Java语言写成的可重用组件
  *  是指符合如下标准的Java类：
 *（1）类是公共的
 *（2）有一个无参的公共的构造器
 *（3）有属性，且有对应的get,set方法
 * @author zhaomin
 * @date 2020/1/13 13:34
 */
public class Customer {
    private int id;
    private String name;

    public Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

