package exer;

import org.junit.Test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中
 * 分别按照以下方式对集合中的元素进行排序，并并遍历输出：
 * （1）使Employee实现Comparable接口，并按name 排序
 * （2）创建TreeSet时传入Comparator对象，按生日日期的先后排序
 * @author zhaomin
 * @date 2020/2/8 13:23
 */
public class EmployeeTest {
    //问题一：使用自然排序
    @Test
    public void test() {
        Employee e1 = new Employee("WYB", 22, new MyDate(1997, 8, 4));
        Employee e2 = new Employee("WEB", 23, new MyDate(1996, 8, 4));
        Employee e3 = new Employee("WSB", 24, new MyDate(1995, 8, 4));
        Employee e4 = new Employee("WDB", 25, new MyDate(1994, 8, 4));
        Employee e5 = new Employee("WYB", 26, new MyDate(1993, 8, 4));

        TreeSet set = new TreeSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //问题二：按生日日期的先后排序
    @Test
    public void test1(){
        Employee e1 = new Employee("WYB", 22, new MyDate(1997, 8, 4));
        Employee e2 = new Employee("WEB", 23, new MyDate(1997, 8, 4));
        Employee e3 = new Employee("WSB", 24, new MyDate(1995, 8, 4));
        Employee e4 = new Employee("WDB", 25, new MyDate(1994, 8, 4));
        Employee e5 = new Employee("WYB", 26, new MyDate(1993, 8, 4));

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Employee&&o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1=e1.getBirthday();
                    MyDate b2=e2.getBirthday();
                    //比较年
                    int minuYear=b1.getYear()-b2.getYear();
                    if(minuYear!=0){
                        return minuYear;
                    }else{//比较月
                        int minuMonth=b1.getMonth()-b2.getMonth();
                        if(minuMonth!=0){
                            return minuMonth;
                        }else{//比较日
                            return b1.getDay()-b2.getDay();
                        }
                    }
                }
                throw new RuntimeException("输入的参数类型不一致");
            }
        });
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
