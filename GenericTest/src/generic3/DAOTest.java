package generic3;

import java.util.List;

/**
 * 测试类
 * @author zhaomin
 * @date 2020/2/11 22:58
 */
public class DAOTest {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> forList = dao.getForList(10);

        StudentDAO student = new StudentDAO();
        student.add(new Student());
    }
}
