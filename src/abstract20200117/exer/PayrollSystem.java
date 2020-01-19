package abstract20200117.exer;

import operator20200112.ScannerTest;

import java.util.Scanner;

/**
 * 定义PayrollSystem类，创建Employee变量数组并初始化，
 * 该数组存放各类雇员对象的引用
 * 利用循环结构遍历数组元素，输出各个对象的类型，number，name,birthday，
 * 当键盘输入本月月份时，如果本月是某个Employee对象的生日，
 * 还要输出增加工资信息
 * @author zhaomin
 * @date 2020/1/18 0:18
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入当月份：");
        int month=scanner.nextInt();
        Employee[] employees=new Employee[2];
        employees[0]=new SalariedEmployee("马森",1002,
                new MyDate(1992,2,28),10000);
        employees[1] = new HouryEmployee("阳江", 2001,
                new MyDate(1991, 3, 4), 60, 240);
        for(int i=0;i<employees.length;i++){
            System.out.println(employees[i]);
            int salary=employees[i].earings();
            System.out.println("月工资为："+salary);
            if(month==employees[i].getBirthday().getMonth()){
                System.out.println("生日快乐，加100");
            }
        }
    }

}
