package jdbc1;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 修改数据
 * @author zhaomin
 * @date 2020/4/4 17:47
 */
public class Jdbc3 {
    @Test
    public void update() {
        Connection connection= null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.预编译sql语句，获取可执行sql语句的PreparedStatement实例
            String sql="UPDATE jobs set job_title=? where job_id=?  ";
            ps = connection.prepareStatement(sql);
            //3.填充占位符
            ps.setString(1,"TEST");
            ps.setString(2,"ZM");
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            JDBCUtils.close(connection,ps);
        }

    }
}
