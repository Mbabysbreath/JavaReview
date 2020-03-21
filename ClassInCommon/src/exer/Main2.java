package exer;

import org.junit.Test;

/**
 * @author zhaomin
 * @date 2020/3/4 17:17
 */
public class Main2 {
    public int countWays(int n) {
        // write code here
        if(n<=2){
            return n;
        }
        if(n==3){
            return 4;
        }
        return (countWays(n-1)+countWays(n-2)+countWays(n-3))%100000007;
    }
    @Test
    public void test(){
        System.out.println(countWays(5));
    }
}
