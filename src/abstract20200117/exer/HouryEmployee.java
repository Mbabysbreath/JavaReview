package abstract20200117.exer;

/**
 * 按小时计算工资，该类包括：
 * private成员变量wage和hour
 * 实现父类的抽象方法earnings(),该方法返回wage*hour
 * toString()输出员工类型信息和name,number,birthday
 * @author zhaomin
 * @date 2020/1/18 0:12
 */
public class HouryEmployee extends Employee  {
    private int wage;
    private int hour;
    public HouryEmployee(String name, int number, MyDate birthday,int wage,int hour) {
        super(name, number, birthday);
        this.hour=hour;
        this.wage=wage;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public int earings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return "HouryEmployee{" +super.toString()+"}";
    }
}
