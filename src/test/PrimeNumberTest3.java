package test;

/**
 * 优化三：
 * @author zhaomin
 * @date 2020/1/12 15:58
 */
public class PrimeNumberTest3 {
    public static void main(String[] args) {
       label: for(int i=2;i<=100;i++){
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0) {
                    continue label;
                }
            }
            System.out.println(i);
        }
    }
}

