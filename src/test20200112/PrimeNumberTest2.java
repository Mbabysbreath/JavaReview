package test20200112;

/**100以内质数的输出优化
 * @author zhaomin
 * @date 2020/1/12 15:28
 */
public class PrimeNumberTest2 {
    public static void main(String[] args) {
        for(int i=2;i<=100;i++){
            boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){//优化二：对本身是质数的自然数是有效的（更好）
                if(i%j==0){
                    flag=false;
                    break;//优化一：只对本身非质数的数有效
                }
            }
            if(flag==true){
                System.out.println(i);
            }
        }
    }
}

