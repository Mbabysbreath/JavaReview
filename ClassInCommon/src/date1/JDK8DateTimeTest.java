package date1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author zhaomin
 * @date 2020/2/4 8:54
 */
public class JDK8DateTimeTest {
    /**
     * LocalDate\LocalTime\LocalDateTime的使用
     * 说明：
     * 1.LocalDateTime相较于LocalDate\LocalTime使用频率更高
     * 2.类似于Calendar
     */
    @Test
    public void test(){
        //now():获取当前日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");

        //of():设置指定的年、月、日、时分秒
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 02, 23, 13, 40, 23);
        System.out.println(localDateTime1);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");

        //getXxx():获取月中天，第几个月等
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        //withXxx():改变设置时间，体现LocalTime的不可变型
        LocalDate localDate1=localDate.withDayOfMonth(22);
        System.out.println("实际："+localDate);
        System.out.println("改变："+localDate1);

        //plusXxx():在实际时间基础增加时间，体现不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println("实际："+localDateTime);
        System.out.println("改变1："+localDateTime2);
        System.out.println("改变2:"+localDateTime3);
    }
    /**
     * Instant的使用
     * 类似于java.util.Date类
     */
    @Test
    public void test1(){
        //获取本初子午线所在时区的当前时间（）
        Instant instant = Instant.now();
        System.out.println("本初子午线：" + instant);
        //添加时间的偏移量（北京东八区比本初子午线快8个小时）
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("北京东八区："+offsetDateTime);
        //toEpochMilli():获取自1970-01-01 0:0:0 UTC格林尼治开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //根据给定的毫秒数获取一个Instant实例时间
        Instant instant1=Instant.ofEpochMilli(1580783448817L);
        System.out.println(instant1);
    }
    /**
     * DateTimeFormatter日期时间格式化
     * 类似于SimpleDateFormat
     */
    @Test
    public void test2(){
        /*方式一：预定义标准格式：如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME*/
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期---》字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println("当前时间："+localDateTime);
        System.out.println("格式化1："+str1);
        //解析：字符串---》日期
        TemporalAccessor parse = formatter.parse("2020-02-04T11:08:25.229");
        System.out.println("解:1："+parse);

        /*方式二：本地化相关的格式：如：ofLocalizeDateTime()
        * FormatStyle.LONG ； FormatStyle.MEDIUM ; FormatStyle.SHORT--适用于LocalDateTime
        *
        * 本地化相关的格式:ofLocalizeDate()
        * FormatStyle.FULL;FormatStyle.LONG ； FormatStyle.MEDIUM ; FormatStyle.SHORT*/
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化LocalDateTime
        String str2 = formatter1.format(localDateTime);//2020年2月4日 上午11时26分09秒
        System.out.println("格式化2—1："+str2);
        //解析
        TemporalAccessor parse1 = formatter1.parse("2020年2月4日 上午11时25分50秒");
        System.out.println("解析2："+parse1);
        //格式化LocalDate
        DateTimeFormatter formatter2=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3=formatter2.format(LocalDate.now());
        System.out.println("格式化2-2:"+str3);//2020年2月4日 星期二

        /*重点：格式化三：自定义格式：如：ofPattern("yyyy-MM-dd hh:mm:ss")*/
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(localDateTime);
        System.out.println("格式化3："+str4);
        //解析
        TemporalAccessor parse2 = formatter3.parse("2020-02-04 11:46:29");
        System.out.println(parse2);
    }
}
