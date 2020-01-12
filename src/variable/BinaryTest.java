package variable;

import org.junit.Test;

/**
 * 计算机中不同进制的使用说明
 * 二进制（binary）:0,1 以0b或0B开头
 * 十进制（Decimal）
 * 八进制（octal）:以数字0开头
 * 十六进制（hex）：以0x或0X，A-F不区分大小写
 * @author zhaomin
 * @date 2020/1/12 9:26
 */
public class BinaryTest {
    public static void main(String[] args) {
        int n1=0b11;//二进制
        byte n5=(byte)0b11110010;//-14 计算机底层是以补码的形式存储数据
        int n2=0127;//八进制
        int n3=110;//十进制
        int n4=0x110A;//十六进制
        System.out.println("n1="+n1);
        System.out.println("n5="+n5);
        System.out.println("n2="+n2);
        System.out.println("n3="+n3);
        System.out.println("n4="+n4);
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toOctalString(8));
        System.out.println(Integer.toHexString(17));
    }

}
