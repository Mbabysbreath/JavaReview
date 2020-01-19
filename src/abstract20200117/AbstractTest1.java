package abstract20200117;

/**
 * 抽象类的使用例子
 * @author zhaomin
 * @date 2020/1/17 22:44
 */
public class AbstractTest1 {
    public static void main(String[] args) {
        //多态使用
        Employee manager = new Manager("库克", "101", 1200, 200);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
abstract class Employee{
    String name;
    String id;
    private int salary;

    public Employee(){
        super();
    }

    public Employee(String name,String id,int salary) {
        super();
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    public abstract void work();
}
class Manager extends Employee{
    private double bonus;//奖金

    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, String id, int salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工");
    }
}