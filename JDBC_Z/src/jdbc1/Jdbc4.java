package jdbc1;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author zhaomin
 * @date 2020/4/4 19:07
 */
public class Jdbc4 {
    @Test
    public void test(){
        //1.插入数据
        String sql = "INSERT INTO jobs(job_id,job_title,min_salary,max_salary) VALUES(?,?,?,?)";
        updateSQL(sql,"ZM","CAR",10000,20000);
        //2.删除
        String sql2="DELETE FROM jobs Where job_id=?";
        updateSQL(sql2,"ZM");
        //3.修改
       // String sql="UPDATE jobs set job_title=? where job_id=?  ";

        String sql3="UPDATE jobs set min_salary=? Where job_id=?";
        updateSQL(sql3,1000,"PU_MAN");
    }

    /**
     * 通用的SQL
     * @param sql
     * @param args
     */

    public void updateSQL(String sql,Object ...args)  {
        Connection connection= null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            connection = JDBCUtils.getConnection();
            //2.预编译
            ps = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            //3.ps执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            JDBCUtils.close(connection,ps);
        }
    }
}
