package exer;

import java.util.Scanner;

/**
 * @author zhaomin
 * @date 2020/2/12 10:41
 */
public class P {
    public static String subString(String str){
        char[] arr=str.toCharArray();
        String str1="";
        for(int i=0;i<arr.length;i++){
            if(arr[i]-'0'>=0&&arr[i]-'0'<=9){

                String st="";
                int j;
                for(j=i;j<arr.length;j++){
                    if(arr[j]-'0'>=0&&arr[j]-'0'<=9){
                        st+=arr[j];
                    }
                    else{
                        break;
                    }
                }
                if(str1.length()<=st.length()){
                    str1=st;
                }
                i=j;
            }
        }
        return str1;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(P.subString(str));
    }
}
