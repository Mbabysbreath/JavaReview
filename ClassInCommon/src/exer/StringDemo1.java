package exer;

import org.junit.Test;

/**
 * 获取一个字符串在另一个字符串中出现的次数
 * @author zhaomin
 * @date 2020/2/2 22:51
 */

public class StringDemo1 {

    //方式一：
    public int getCount(String mainStr,String subStr){
        int mainLength=mainStr.length();
        int subLength=subStr.length();
        int count=0;
        int index;
        if(mainLength<subLength){
            return 0;
        }
        while ((index=mainStr.indexOf(subStr))!=-1){
            count++;
            mainStr=mainStr.substring(index+subStr.length());
        }
        return count;
    }

    //方式二：改进方式一，不用改变mainStr
    public int getCount1(String mainStr,String subStr){
        int mainLength=mainStr.length();
        int subLength=subStr.length();
        int count=0;
        int index=0;
        if(mainLength<subLength){
            return 0;
        }
        while ((index=mainStr.indexOf(subStr,index))!=-1){
            count++;
            index=index+subLength;
        }
        return count;
    }
        @Test
    public void test1(){
        String str1="abcabccbasdefabccdefegaaabc";
        String str2="abc";
            System.out.println(getCount(str1, str2));
            System.out.println(getCount1(str1, str2));
        }

}
