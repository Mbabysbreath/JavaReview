package operator20200112;

/**
 * 三目运算符
 * (1)三目运算符可以进行嵌套
 * (2)凡是可以使用三元运算符的都可以该校为if else
 *    反之，不成立
 *（3）如果，程序既可以使用if也可以使用三目运算符，
 *     优先选三目运算符
 *    简洁，执行效率高
 * @author zhaomin
 * @date 2020/1/12 11:45
 */
public class Ternary {
    public static void main(String[] args) {
        int n=4;
        int m=4;
        int max=(m>n)?m:n;
        System.out.println(max);
        String maxStr=(m>n)?"m大":((m==n)?"m和n一样":"n大");
        System.out.println(maxStr);
    }
}
