package enum1;

import java.util.Arrays;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 * 三、Enum类常用的方法
 * values()——返回枚举类型的对象数组，该方法可以很方便的遍历所有的枚举值
 * valueOf(String str):可以把一个字符串转为对应的枚举类对象，
 *                      要求：字符串必须是枚举类
 * toString():返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：每个枚举类对象分别重写接口中的抽象方法，实现各自的功能
 * @author zhaomin
 * @date 2020/2/5 0:39
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        //toString():
        System.out.println("toString()方法："+spring.toString());
        System.out.println(Season1.class.getSuperclass());
        //values():
        Season1[] arr=Season1.values();
        System.out.println("values（）方法："+Arrays.toString(arr));
        Thread.State[] values = Thread.State.values();
        System.out.println(Arrays.toString(values));
        //valuesOf():
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        //如果字符串与枚举类对象名不同，会抛出异常java.lang.IllegalArgumentException
//        Season1 summer2 = Season1.valueOf("SUMMER2");
//        System.out.println(summer2);
        winter.show();
    }
}
//1.使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供好当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    /*情况2：枚举类对象各自重写接口的抽象方法*/
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天在这里");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },

    WINTER("冬天", "冬雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天里的一把火");
        }
    };

    //2.声明Season对的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //3.私有化构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonDesc=seasonDesc;
        this.seasonName=seasonName;
    }


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /*情况1：枚举类重写接口抽象方法*/
    @Override
    public void show() {
        System.out.println("这是一个季节");
    }

   /* //5.其他诉求2：提供toString(),可以不用重写toString

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/
}
interface Info{
    void show();
}
