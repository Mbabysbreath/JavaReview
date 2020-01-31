package operator20200112;

/**
 * （1）break和continue关键后不能跟执行语句，因为无法访问到
 * （2）break label 结束指定标识的一层循环结构，
 * 可用于嵌套循环直接结束外层循环的 场景
 * （3）continue label 结束指定标识的一层循环的当次循环
 * @author zhaomin
 * @date 2020/1/12 15:43
 */
public class BreakContinueTest {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            if(i%4==0){
                break;
            }
            System.out.println(i);
        }
    }
}
