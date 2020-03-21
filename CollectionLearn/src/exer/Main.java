package exer;

/**
 * @author zhaomin
 * @date 2020/3/5 17:41
 */
import java.util.*;
public class Main{
    public static void wornout(String str1,String str2){
        LinkedHashSet list=new LinkedHashSet();
        String original=str1.toUpperCase();
        String result=str2.toUpperCase();

        for(int k=0;k<original.length();k++){
            if(original.charAt(k)>='A'||original.charAt(k)<='Z'
                    ||original.charAt(k)>='0'||original.charAt(k)<='9'
                    ||original.charAt(k)=='_'){
               continue;
            }else{
                return;
            }
        }
        int i=0,j=0;
        while(i<original.length()){
            if(j<result.length()){
                if(original.charAt(i)==result.charAt(j)){
                    i++;
                    j++;
                }
            }
            list.add(original.charAt(i));
            i++;
        }
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
    public static void main(String[] args){

        String s="ABC,";
        for(int i=0;i<4;i++){

            if((s.charAt(i)>='A'&&s.charAt(i)<='Z')
                    ||(s.charAt(i)>='0'&&s.charAt(i)<='9')
                    ||s.charAt(i)=='_'){
                System.out.println(s.charAt(i));
            }else{
                System.out.println("错误"+s.charAt(i));
            }
        }
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.next();
        String str2=scanner.next();
        wornout(str1,str2);
    }
}

