package abstract20200117.exer;

/**练习一：
 * 定义一个Employee类，该类包含：
 * private成员变量name,number,birthday,其中birthday为Mydate类的对象
 * abstract方法earnings()
 * toString()方法输出对象的name,number,birthday
 *
 * @author zhaomin
 * @date 2020/1/17 23:45
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public abstract int earings();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString();
    }
}
