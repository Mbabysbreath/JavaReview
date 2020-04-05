package jdbc1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author zhaomin
 * @date 2020/4/4 11:23
 */
public class Jdbc1 {

       @Test
       public void getConnection1(){
           //
           Connection connection=null;
           Statement statement=null;
           ResultSet resultSet=null;

           try{
               //1.加载驱动
               //可以省略注册驱动DriverManager.registrDriver(new com.mysql.jdbc.Driver);
               //是因为Driver类里静态加载了注册驱动的步骤
//               static {
//                   try {
//                       DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//                   } catch (SQLException var1) {
//                       throw new RuntimeException("Can't register driver!");
//                   }
//               }
               Class.forName("com.mysql.jdbc.Driver");
               //2.获取数据库连接
               String url="jdbc:mysql://localhost:3306/myemployees?useSSL=false";
               String user="root";
               String password="419423mmzz";
               connection = DriverManager.getConnection(url, user, password);
               System.out.println(connection);
               //3.获取可以执行sql语句的对象Statement
               statement=connection.createStatement();
               //4.获 取结果集
               String sql="SELECT * FROM jobs";
               resultSet=statement.executeQuery(sql);
               //5.处理结果集
               while (resultSet.next()) {
                   String job_id=resultSet.getString(1);
                   String job_title=resultSet.getString(2);
                   String max_salary=resultSet.getString(3);
                   String min_salary = resultSet.getString(4);
                   System.out.println(job_id+","+job_title+" "+min_salary+" "+max_salary);
               }
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (SQLException e) {
               e.printStackTrace();
           }finally {
               //6.关闭连接
               if (resultSet != null) {
                   try {
                       resultSet.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
               if (statement != null) {
                   try {
                       statement.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
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

       //将数据库连接所需的四个基本信息声明再配置文件中，通过读取配置文件的方式，获取连接

    /**
     * 好处：
     * （1）实现了数据与代码的分离，实现了解耦
     * （2）如果有需要可以直接修改配置文件的信息，避免程序重写打包
     */
    @Test
    public void getConnection2() throws IOException {
           //1.读取文件的配置信息
        InputStream is = Jdbc1.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros=new Properties();
        pros.load(is);
        String driver = pros.getProperty("driver");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        try {
            //2.加载驱动
            Class.forName(driver);
            //3.获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
