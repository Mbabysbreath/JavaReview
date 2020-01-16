package exception20200115;

import org.junit.Test;

/**
 * 便携EcmDef.java接受命令行的两个参数，要求不能输入附属，计算两数相除
 * 对数据类型不一致（NumberFormatEception）
 *  缺少命令行参数（ArrayIndexOutOfBoundsException）
 *  除0（ArithmeticException）
 *  输入负数（EcDef自己定义的异常）进行处理
 * @author zhaomin
 * @date 2020/1/15 20:10
 */
public class EcmDef {

    public static void main(String[] args) {
        String str="1";
        System.out.println(Integer.parseInt(str));
        try {
            int a=1;
            int b=0;
            int result=ecm(a, b);

            System.out.println(result);
        } catch (EcDef ecDef) {
            System.out.println(ecDef.getMessage());
        }catch(NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(ArithmeticException e){
            System.out.println("除0异常");
        }
    }
    public static int ecm(int a,int b) throws EcDef {
        if(a<0||b<0){
            //编译时异常需要在方法声明中处理
            throw new EcDef("分子或分母为负数");
        }
        return a/b;
    }
}
