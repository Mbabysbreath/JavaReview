package thread3;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @author zhaomin
 * @date 2020/1/28 23:46
 */
public class BankTest {
    public static void main(String[] args) {

    }
}
class Bank{
    private Bank(){

    }
    private static Bank instance=null;
//方式一：效率较差---同步代码块直接加一个synchronized
    public static  Bank getInstance(){
        //方式二：效率更高---同步代码块前加一个判断条件，如果不满足就不要再等了
        if(instance==null){
            synchronized (Bank.class) {
                if(instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}