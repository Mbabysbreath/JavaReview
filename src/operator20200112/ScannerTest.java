package operator20200112;

import java.util.Scanner;

/**
 * 如何从键盘获取不同类型的变量：
 * （1）导包：importability javanese.util.Scanner;
 * (2)Scaner 的实例化：Scanner scan=new Scanner(System.in);
 * (3)对于char型的获取，Scanner没有提供相关的方法，只能获取一个字符串
 *   但可以用charAt（index）取相应位置的字符
 *   （4）需要根据相应的方法，来输入指定类型的值
 * @author zhaomin
 * @date 2020/1/12 12:14
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入你的姓名：");
        String name=scan.next();
        System.out.println(name);

        System.out.println("请输入你的年龄：");
        int age=scan.nextInt();
        System.out.println(age);

        System.out.println("请输入你的体重：");
        double weight=scan.nextDouble();
        System.out.println(weight);

        System.out.println("你是否单身：（true/false）");
        boolean isSingle=scan.nextBoolean();
        System.out.println(isSingle);

        System.out.println("请输入你的性别：（男/女）");
        String sex=scan.next();
        //或者用charAt转为读取字符
        char sexChar=sex.charAt(0);//获取索引为0的位置上的字符
        System.out.println(sex);
        System.out.println(sexChar);
    }
}
