package abstract20200117;

/**
 * 抽象类的应用——模板方法的设计模式
 * 计算代码段的运行时间
 * @author zhaomin
 * @date 2020/1/17 23:24
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template t=new SubTemplate();
        t.spendTime();
    }
}
abstract class Template{
    public void spendTime(){
        long start=System.currentTimeMillis();
        code();//不确定的部分
        long end=System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));
    }
    public abstract void code();
}

/*1000以内的质数*/
class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag=true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag=false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
    }
}