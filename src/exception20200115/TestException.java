package exception20200115;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @author zhaomin
 * @date 2020/1/16 17:13
 */
public class TestException {
    /* *************编译时异常************* */
   /* @Test
    //FileNotException
    public void test(){
        File file=new File("hello.txt");
        FileInputStream fis=new FileInputStream(file);
        int data=fis.read();
        while(data!=-1){
            System.out.println((char)data);
            data=fis.read();
        }
        fis.close();
    }*/
    /* **************运行时异常************ */
    @Test
    //ArithmeticException
    public void test1(){
        int a=2;
        int b=0;
        System.out.println(a/b);
    }

    @Test
    //InputMismatchException
    public void test2(){
        Scanner scanner=new Scanner(System.in);
        int score=scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }

    @Test
    //NullPointerException
    public void test3(){
        int[] num=null;
        System.out.println(num[3]);
        String str=null;
        System.out.println(str.length());
    }

    @Test
    //ArrayIndexOutOfBoundsException
    //StringIndexOutOfBoundException
    public void test4(){
        int[] num = new int[2];
        System.out.println(num[3]);
        String str="abc";
        System.out.println(str.charAt(5));
    }

    @Test
    //ClassCastException
    public void test5(){
        Object obj=new Date();
        System.out.println(obj);
        String str=(String)obj;
    }

    @Test
    //NumberFormatException
    public void test6(){
        String str="abc";
        System.out.println(Integer.valueOf(str));
    }
}
