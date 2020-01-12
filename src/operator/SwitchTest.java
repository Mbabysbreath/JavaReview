package operator;

/**
 * switch-case
 * 1.格式
 *  switch（表达式）｛
 *  case 常量1：
 *        执行语句1；
 *        //break;
 *   ｝
 * 2，说明：
 * （1）根据switch表达式的值，依次匹配各个case中的常量，
 *      一旦匹配成功，则进入相应case结构中，迪欧爱用其语句
 *      当调用玩执行语句以后，则仍然继续向下执行其他case结构中的执行语句，
 *     直到遇到break关键字或此switch结构末尾结束
 * （2）switch结构中的表达式，只能是如下的6中数据类型之一：
 *      byte\short\char\int\枚举类型（JDK5.0）\String类型（JDK7.0）
 *  (3)case 后只能声明常量，不能声明范围
 * @author zhaomin
 * @date 2020/1/12 13:34
 */
public class SwitchTest {
    public static void main(String[] args) {
        int num=2;
        switch (num){
            case 0:
                System.out.println("zero");
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
                default:
                    System.out.println("other");

        }
    }
}
