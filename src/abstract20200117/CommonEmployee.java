package abstract20200117;

import org.junit.Test;

/**
 * @author zhaomin
 * @date 2020/1/17 22:53
 */
public class CommonEmployee extends Employee {

    @Override
    public void work() {
        System.out.println("普通员工工作");
    }
}
