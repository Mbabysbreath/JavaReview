package date1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * JDK8之前日期和时间的API测试：
 * 1.System类中的currentTimeMillis()
 * 2.java.util.Date类
 *       |------java.sql.Date类
 * 3.SimpleDateFormat
 * 4.Calender
 * @author zhaomin
 * @date 2020/2/2 18:17
 */
public class DateTimeTest {
    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        // 时间戳--应用在订单号的生成，唯一
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /**
     * 2.java.util.Date类
     * |------java.sql.Date类
     * （1）两个构造器的使用
     * 》构造器一：Date()，创建一个对应当前时间的Date对象
     * 》构造器二：Date(long date),创建指定毫秒数的Date对象
     * （2）两个方法的使用
     * >toString():显示当前的年、月、日、时、分、秒
     * >getTime():获取当前Date对象对应的时间戳（毫秒数）
     * （3）java.sql.Date:对应着数据库中的日期类型
     * 》如何实例化：java.sql.Date(long date)
     * 》如何将java.util.Date对象转换为java.sql.Date对象:
     * 情况一：
     * Date date4=new java.sql.Date(12931481749L);
     * java.sql.Date date5= (java.sql.Date) date4;
     * 情况二：
     * Date date6=new Date();
     * //java.sql.Date date7= (java.sql.Date) date6;出现类型转换异常，不能将父类转子类
     * java.sql.Date date8=new java.sql.Date(date6.getTime());
     */
    @Test
    public void test2() {
        //构造器一：Date()，创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun Feb 02 19:23:45 GMT+08:00 2020
        System.out.println(date1.getTime());//1580642704846

        //构造器二：Date(long date),创建指定毫秒数的Date对象
        Date date2 = new Date(1580642704846L);
        System.out.println(date2);//Sun Feb 02 19:25:04 GMT+08:00 2020

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(218743587582L);
        System.out.println(date3.toString());//1976-12-07

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
        Date date4 = new java.sql.Date(12931481749L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        // java.sql.Date date7= (java.sql.Date) date6;出现类型转换异常，不能将父类转子类
        java.sql.Date date8 = new java.sql.Date(date6.getTime());
    }

    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期类的格式化和解析
     * 1.两个操作：
     * （1）格式化：日期---》字符串
     * （2）解析：格式化的逆过程：字符串---》日期
     * <p>
     * 2.SimpleDateFormat的实例化
     */


    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        /*(1)无参构造器：格式会默认*/
        //格式化:日期--》字符串
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat();
        String format=sdf.format(date);
        System.out.println(format);

        /*解析：格式化的逆过程，字符串---》日期*/
        String str="20-2-3 下午7:22";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        /*(2)有参构造器：格式可以指定*/
       // SimpleDateFormat sdf1=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String format1=sdf1.format(date);
        System.out.println(format1);

        /*解析：一定要注意格式和构造器中的参数格式一致，一个空格的错误也不能*/
       // String str1=;
        Date date2=sdf1.parse("2020-02-03  19:48:27");
        //System.out.println(date2);
    }

    /**
     * 练习一：字符串”2020-02-03“转换为java.sql.Date
     *
     */
    @Test
    public void test() throws ParseException {
        String str="2020-02-03";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(str);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }
    /**
     * 练习二：”三天打鱼两天晒网“1990-01-01开始
     * 问：某年某月某日在干什么例如：2020-09-08打鱼？晒网
     */
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse("1990-01-01");
        Date date1=sdf.parse("2020-09-08");
        long time=date1.getTime()-date.getTime();
        int days=(int)(time/(1000*60*60*24)+1);
        System.out.println(days);
    }
    /**
     * Calendar日历类（抽象类）的使用
     */
    @Test
      public void test4() throws ParseException {
          //1.实例化
         //(1)调用静态方法getInstance(),实际上还是子类的对象
        //(2)使用子类的构造方法class java.util.GregorianCalendar
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);//月中天
        System.out.println("一个月的第几天:"+days);
        System.out.println("一年中的第几天："+calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);//设置为一个月中的第几天
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add(),减法的话，写负值
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---》Date
        Date date=calendar.getTime();
        System.out.println(date);

        //setTime():Date--日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Date date2=s.parse("1999-04-09");
        System.out.println(date2.getTime());


      }
}