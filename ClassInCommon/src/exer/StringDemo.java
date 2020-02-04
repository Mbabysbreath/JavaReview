package exer;

import org.junit.Test;

/**
 * @author zhaomin
 * @date 2020/2/2 21:40
 */
public class StringDemo {
    /**
     * 将一个字符串进行反转。
     * 将字符串中指定部分进行反转
     * abcdefg-afedcbg
     */
    //方式一：转换为char型数组
    public String reverse(String str,int startIndex,int endIndex){
       if(str!=null&&str.length()!=0){
           char[] ch=str.toCharArray();
           for(int i=startIndex,j=endIndex;i<j;i++,j--){
               char temp=ch[i];
               ch[i]=ch[j];
               ch[j]=temp;
           }
           return new String(ch);
       }
       return null;
    }

    //方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex){
        String str1=str.substring(0,startIndex);
        for(int i=endIndex;i>=startIndex;i--){
            str1+=str.charAt(i);
        }
        str1+=str.substring(endIndex+1);
        return str1;
    }
    //方式三：替换
    public String reverse2(String str,int startIndex,int endIndex){
        String s1=str.substring(startIndex,endIndex+1);
        StringBuilder sb=new StringBuilder(s1);
        sb.reverse();
        String s2=sb.toString();
        String s3=str.replace(s1,s2);
        return s3;
    }
    //方式四
    public String reverse3(String str,int startIndex,int endIndex){
        if(str!=null){
            StringBuilder sb=new StringBuilder(str.length());
            //第一部分
            sb.append(str.substring(0,startIndex));
            //第二部分
            for(int i=endIndex;i>=startIndex;i--){
                sb.append(str.charAt(i));
            }
            //第三部分
            sb.append(str.substring(endIndex+1));
            return sb.toString();
        }
        return null;
    }
    @Test
    public void test1(){
        String str="abcdefg";
        String s1=reverse(str,1,5);
        System.out.println(s1);
        System.out.println(reverse1(str, 1, 5));
        System.out.println(reverse2(str, 1, 5));
        System.out.println(reverse3(str, 1, 5));

    }
}
