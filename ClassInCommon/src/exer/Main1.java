package exer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaomin
 * @date 2020/3/3 12:27
 */
public class Main1 {

        public static String change(String P,String A){
            String[] sp=P.split("\\.");
            String[] sa=A.split("\\.");
           //System.out.println(Arrays.toString(sp));
            System.out.println(Arrays.toString(sa));
            int pg=Integer.parseInt(sp[0]);
            int ps=Integer.parseInt(sp[1]);
            int pk=Integer.parseInt(sp[2]);

            int ag=Integer.parseInt(sa[0]);
            int as=Integer.parseInt(sa[1]);
            int ak=Integer.parseInt(sa[2]);
            if(pg>ag||(pg==ag&&ps>as)||(pg==ag&&ps==as&&pk>ak)){
                return "-"+change(A,P);
            }
            String res="";
            int rk=0,rs=0,rg=0;
            rk=ak-pk;
            rs=as-ps;
            rg=ag-pg;
            boolean k=false;
            if(rk<0) {
                rk = rk + 19;
               rs=rs-1;
            }
            if(rs<0){
                rs=rs+17;
                rg=rg-1;
            }
            res+=rg+"."+rs+"."+rk;
            return res;
        }

    public int countNumberOf2s(int n) {
        // write code here
        int count=0;
        for(int i=0;i<=n;i++){
            int j=i;
            while (j%10==2){
                count++;
                j=j/10;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        System.out.println(countNumberOf2s(22));
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String [] s=str1.split(" ");
        System.out.println(change(s[0], s[1]));
    }
    @Test
    public void test(){
       // System.out.println(change("10.16.27","9.1.28"));
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String [] s=str1.split(" ");
        System.out.println(change(s[0], s[2]));
    }
}
