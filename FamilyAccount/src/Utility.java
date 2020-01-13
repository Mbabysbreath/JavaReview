import java.util.Scanner;

/**
 * 将不同的功能封装位方法。
 * 可以直接调研方法使用它的功能，而无须考虑具体功能的实现细节
 * @author zhaomin
 * @date 2020/1/12 21:57
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用于界面菜单的选择，
     * 读取键盘中用户输入的‘1’--’4‘中的任意字符，则方法返回
     * 用户键入的字符
     * @return 用户的选择
     */
    public static char readMenueSelection(){
        char c;
        while(true){
            String str=readKeyBoard(1);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'){
                System.out.print("选择错误，请重新输入：");
            }else
                break;
        }
        return c;
    }

    private static String readKeyBoard(int i) {
        while(true) {
            String str = scanner.next();
            if (str.length() <= i) {
                return str;
            }else{
                System.out.println("长度不符合要求，请重新输入:");
            }
        }
    }

    /**
     * 用于收入和支出金额的输入。
     * 该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值
     * @return 金额
     */
    public static int readNumber(){
        int n;
        while(true){
            String str=readKeyBoard(4);
            try {
                n=Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 用于收入和支出说明的输入。
     * 字符长度不超过8位，并作为返回值
     * @return
     */
    public static String readString(){
        String str=readKeyBoard(8);
        return str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y'或’N'，并将其作为方法的返回值
     * @return
     */
    public static char readConfirmSelection(){
        char c;
        while(true){
        String str=readKeyBoard(1).toUpperCase();
        c=str.charAt(0);
        if(c=='Y'||c=='N'){
            break;
        }else{
                System.out.println("选择错误，请重新输入：");
            }
    }
    return c;
    }
}
