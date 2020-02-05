package enum1;

/**
 * 一、枚举类的使用：
 * 1.枚举类的理解：类的对象只有有限个，确定的
 * 2.需要定义一组常量时，建议使用
 * 3.如果枚举类中只有一个对象，可以作为单例模式的实现方式
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0时，使用enum关键字定义
 *
 *
 * @author zhaomin
 * @date 2020/2/5 0:07
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
class Season{
    //1.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc=seasonDesc;
        this.seasonName=seasonName;
    }

    //3.创造多个确定的对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬雪皑皑");
    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //5.其他诉求2：提供toString()

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
