package exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 获取两个字符串的最大相同子串
 * 提示：将短的那个串进行长度依次递减的子串与长串进行比较
 * @author zhaomin
 * @date 2020/2/2 23:09
 */
//前提：两个字符串只有一个最大相同子串
public class StringDemo2 {
    public String getMaxCommon(String str1,String str2){
        if(str1!=null&&str2!=null){
            String maxStr=(str1.length()>=str2.length())?str1:str2;
            String minStr=(str1.length()<str2.length())?str1:str2;
            int length=minStr.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String subStr=minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
//有多个长度相同的最大子串
    public String[] getMaxCommon1(String str1,String str2){
        if(str1!=null&&str2!=null){
            StringBuffer sb=new StringBuffer();
            String maxStr = (str1.length() >=str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;

            int length=minStr.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String subStr=minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        sb.append(subStr+",");
                    }
                }
                if(sb.length()!=0){
                    break;
                }
            }
            String[] spilt = sb.toString().replaceAll(",$", "").split("\\,");
            return spilt;
        }
        return null;
    }
    @Test
    public void test(){
        String s1="fhkasfdjkfhkjabcdefgfsdfabcdefgh";
        String s2="abcdefghhdfksajabcdefgdkjsfahkj";
        System.out.println(getMaxCommon(s1,s2));
        System.out.println(Arrays.toString(getMaxCommon1(s1,s2)));
    }
}
