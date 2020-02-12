package generic5;

import java.util.List;

/**
 * @author zhaomin
 * @date 2020/2/12 18:07
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao=new DAO<>();
        dao.save("1001",new User(1001,33,"周杰伦"));
        dao.save("1002",new User(1002,34,"周中华伦"));
        dao.save("1003",new User(1003,35,"周看电视剧伦"));

        dao.update("1003",new User(1003,30,"方文山"));
        List<User> list=dao.list();
        list.forEach(System.out::println);
    }
}
