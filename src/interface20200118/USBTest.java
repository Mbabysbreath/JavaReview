package interface20200118;

import abstract20200117.CommonEmployee;

/**
 * @author zhaomin
 * @date 2020/1/18 16:38
 */
public class USBTest {
    public static void main(String[] args) {
        Computer computer=new Computer();
        //1.创建了接口的非匿名实现类的非匿名对象
        USB flash=new Flash();
        computer.transferData(flash);
        //2.创建接口的非匿名实现类的匿名对象
        computer.transferData(new Printer());
        //3.创建接口的匿名实现类的非匿名对象
        USB phone=new USB(){
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }
        };
        computer.transferData(phone);
        //4.创建接口的匿名实现类的匿名对象
        computer.transferData(new USB(){
            @Override
            public void start() {
                System.out.println("MP3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("MP3结束工作");
            }
        });
    }

}
class Computer{
    public void transferData(USB usb){
        usb.start();
        System.out.println("具体数据传输");
        usb.stop();
    }
}
interface USB{
    void start();
    void stop();
}

/**
 * U盘
 */
class Flash implements USB{
    @Override
    public void start() {
        System.out.println("U盘工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘拔出");

    }
}
class Printer implements USB{
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}
