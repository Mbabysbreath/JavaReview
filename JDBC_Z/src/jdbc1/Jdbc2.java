package jdbc1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 增加数据
 * 使用PreparedStatement替换Statement，实现对数据的增删改查
 * @author zhaomin
 * @date 2020/4/4 16:02
 */
public class Jdbc2 {
    @Test
    public void testInsert(){
        Connection connection=null;
        PreparedStatement ps=null;
        //1.读取配置文件的信息
        InputStream is = Jdbc2.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        try {
            pros.load(is);
            String driver = pros.getProperty("driver");
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            //2.加载驱动
            Class.forName(driver);
            //3.获取数据库的连接
           connection = DriverManager.getConnection(url, user, password);
            //4.获取执行SQL语句的对象PrepareStatement
            //预编译sql语句
            String sql="insert into jobs(job_id,job_title,min_salary,max_salary) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1, "ZM");
            ps.setString(2, "IT");
            ps.setInt(3, 10000);
            ps.setInt(4,30000);
            //6.执行操作
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //7.关闭资源
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
