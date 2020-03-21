package exer;

import org.junit.Test;

import java.util.*;
/**
 * @author zhaomin
 * @date 2020/3/2 17:13
 */
public class NewCoder {
    public static String reverse(String str){
        String[] s1=new String[str.length()];
        int k=0;
       for(int i=0,j=0;j<str.length();){

           if(str.charAt(j)==' '||j==str.length()-1){
               s1[k++]=str.substring(i,j+1);
               i=j+1;
           }
           j++;
       }
        System.out.println(k);
        System.out.println(Arrays.toString(s1));
        String s2="";
        for(int i=k-1;i>=0;i--){
            if(i==0) {
                s2 += s1[i];
            }else{
                s2+=s1[i]+ " ";
            }
        }
        return s2;
    }
    @Test
    public void test(){
        String s=reverse1("i am here");
        System.out.println(s);
    }

    public static String reverse1(String str){
        String[] s1=str.split(" ");

        System.out.println(Arrays.toString(s1));
        String s2="";
        for(int i=s1.length-1;i>=0;i--){
            if(i==0) {
                s2 += s1[i];
            }else{
                s2+=s1[i]+ " ";
            }
        }
        return s2;
    }

    public  void recorder(String path,int row){
        Map<FF,Integer> map=new HashMap<>();
        if(map.size()==8){
            return ;
        }
        String str="";
        for(int i=path.length()-1;i>=0;){
            if(path.charAt(i)==','){
                str=path.substring(i);
            }
        }
        if(str.length()>16) {
            for (int i = str.length() - 1; i >= str.length() - 15; ) {
                str += str.charAt(i);
            }
        }
       FF obj=new FF(str,row);
        int val=map.getOrDefault(obj,0);
        map.put(obj,val+1);
        Set<Map.Entry<FF, Integer>> entries = map.entrySet();
        for(Map.Entry entry:entries){
            int values=(int)entry.getValue();
            FF key=(FF)entry.getKey();
            System.out.println(key);
            System.out.println(values);
        }
        System.out.println("pp");
    }

    @Test
    public void test1(){
        recorder("E:V1R2productfpgadrive.c", 1325);
    }
    class FF{
         String path;
         int row;
         public FF(String path,int row){
             this.path=path;
             this.row=row;
         }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FF ff = (FF) o;

            if (row != ff.row) return false;
            return path != null ? path.equals(ff.path) : ff.path == null;
        }

        @Override
        public int hashCode() {
            int result = path != null ? path.hashCode() : 0;
            result = 31 * result + row;
            return result;
        }

        @Override
        public String toString() {
            return "FF{" +
                    "path='" + path + '\'' +
                    ", row=" + row +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();

        System.out.println(reverse1(str));
    }
}
