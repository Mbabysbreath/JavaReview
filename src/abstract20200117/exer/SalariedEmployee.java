package abstract20200117.exer;

/**按月计算工资
 * 定义SalariedEmployee类继承Employee类
 * 实现按月计算工资的员工处理。
 * 该类包括：private成员变量mpnthlySalary;
 * 实现父类的抽象方法earnings(),该方法返回monthlySalary值
 * toString()方法输出员工类型信息及员工的name,number,birthday
 * @author zhaomin
 * @date 2020/1/17 23:59
 */
public class SalariedEmployee extends Employee {
    private int monthlySalary;//月工资
    public SalariedEmployee(String name, int number, MyDate birthday,int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary=monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee["+super.toString()+"]";
    }
}
