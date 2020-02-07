package collection1;

import org.omg.SendingContext.RunTime;

import java.util.Objects;

/**
 * @author zhaomin
 * @date 2020/2/6 17:20
 */
public class Person implements Comparable {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals........");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 按照姓名从小到大排序,如果相同按照年龄从小到大
     * @param o 比较对象
     * @return 比较结果
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof  Person){
            Person p=(Person)o;
            int result=this.name.compareTo(p.name);
            if(result!=0){
                return result;
            }else{
                return Integer.compare(this.age,p.age);
            }
        }else{
            throw new RuntimeException("传入对象类型有误！");
        }
    }
}
