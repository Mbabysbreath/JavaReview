package other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用：
 * 1.System
 * 2.java.lang.Math
 * 3.java.math.BigInteger（整型）---可以表示不可变的任意精度的整数
 *   构造器---BigInteger(String val):根据字符串创建BigInteger对象
 *  java.math.BigDecimal（浮点型）--支持不可变的任意精度的十进制定点数
 * @author zhaomin
 * @date 2020/2/4 22:50
 */
public class OtherClassTest {
    @Test
    public void test(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的Version：" + javaVersion);

        String javaHome=System.getProperty("java.home");
        System.out.println("java的home：" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.Version");
        System.out.println("os的Version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");//当前模块所在路径
        System.out.println("user的dir:"+userDir);
    }

    @Test
    public void test1(){
            BigInteger bi=new BigInteger("1243324119879723");
            BigDecimal bd = new BigDecimal("12435.351");
            BigDecimal bd2=new BigDecimal("11");
              System.out.println(bi);
           // System.out.println(bd.divide(bd2));
            System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//四舍五入
            System.out.println(bd.divide(bd2, 15,BigDecimal.ROUND_HALF_UP));//保留15位

    }
}

