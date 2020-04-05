package jdbc1;

import org.junit.Test;
import util.JDBCUtils;
import util.Jobs;

import java.beans.Customizer;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 数据库的查询操作
 * @author zhaomin
 * @date 2020/4/4 19:53
 */
public class Jdbc5 {

    @Test
    public void select() throws Exception {
        Connection connection= null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql="SELECT * from jobs WHERE job_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"WYB");
            res = ps.executeQuery();
            //处理结果集
            while(res.next()){
                String job_id=res.getString(1);
                String job_title=res.getString(2);
                int min_salary=res.getInt(3);
                int max_salary=res.getInt(4);
                Jobs job = new Jobs(job_id, job_title, min_salary, max_salary);
                System.out.println(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,ps,res);
        }

    }

    /**
     * 查询操作的统一
     */
    public static Jobs selectSQL(String sql,Object ...args) {
        Connection connection= null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++) {
                ps.setObject(i+1,args[i]);
            }
            res = ps.executeQuery();

            //获取结果集的元数据
            ResultSetMetaData metaData = ps.getMetaData();
            //获取结果集的列数
            int columnCount = metaData.getColumnCount();
            while(res.next()){
                Jobs job=new Jobs();
                for(int i=0;i<columnCount;i++){
                    //获取列值
                    Object colVal = res.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);
                    //给job对象指定的columnName属性，赋值为columValue,通过反射
                    Field field = Jobs.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(job,colVal);
                }
                System.out.println(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,ps,res);
        }
        return null;
    }
    @Test
    public void test(){
        String sql="SELECT * FROM jobs WHERE min_salary>?";
         selectSQL(sql, 1000);
    }
}
