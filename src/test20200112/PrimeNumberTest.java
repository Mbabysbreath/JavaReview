package test20200112;

/**
 * 100以内质数输出的实现 一
 * 100依次去除从2开始到本身减一，
 * @author zhaomin
 * @date 2020/1/12 14:28
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
          for(int i=2;i<=100;i++){
              boolean flag=true;
              for(int j=2;j<i;j++){
                  if(i%j==0){
                      flag=false;
                      break;//优化一：支队本身非质数的数有效
                  }
              }
              if(flag==true){
                  System.out.println(i);
              }
          }
    }
}
