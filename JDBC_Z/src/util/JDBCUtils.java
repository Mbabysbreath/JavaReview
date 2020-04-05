package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 * @author zhaomin
 * @date 2020/4/4 16:34
 */
public class JDBCUtils {
    /**
     * 获取数据库连接
     * @return 数据库连接
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        pros.load(is);

        String driver = pros.getProperty("driver");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 关闭资源连接
     * @param connection
     * @param statement
     */
    public static void close(Connection connection, Statement statement, ResultSet res) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection,Statement statement){
        close(connection,statement,null);
    }
}
