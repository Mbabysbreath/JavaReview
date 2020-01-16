package exception20200115;

/**
 * @author zhaomin
 * @date 2020/1/16 22:16
 */
public class TestFinally {
    public static void main(String[] args) {
        try {
            int a=-1;
            int b=0;
          //  System.out.println(a/b);
            System.out.println("jiji");
            if(a<0||b<0){
                throw new EcDef("分子或分母为负数");
            }

        } catch(ArithmeticException e){
          //  e.getMessage();
            System.out.println("除0异常");
        }catch(EcDef e){

            System.out.println(e.getMessage());
        }finally {
            System.out.println("结束啦");
        }

    }
}
