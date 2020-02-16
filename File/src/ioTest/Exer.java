package ioTest;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 计算文本文件中出现相同字符的个数
 *
 * 菜的坑：一定要关闭流资源，否则会一直等待
 *
 * @author zhaomin
 * @date 2020/2/15 23:45
 */
public class Exer {
    @Test
    public void test(){
        BufferedReader bfr = null;
        Map<Character, Integer> map = null;
        try {
            File file = new File("hello2.txt");
            FileReader fr = new FileReader(file);
            bfr = new BufferedReader(fr);
            map = new HashMap<>();

            String data;
            while ((data = bfr.readLine()) != null) {
                for(int i=0;i<data.length();i++) {
                    int val=map.getOrDefault(data.charAt(i),0);
                    map.put(data.charAt(i),val+1);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileWriter fw= null;
        BufferedWriter bw=null;
        try {
            Set<Map.Entry<Character,Integer>> set=map.entrySet();
            Iterator iterator=set.iterator();
            File file1=new File("result.txt");
            fw = new FileWriter(file1);
            bw=new BufferedWriter(fw);
            while (iterator.hasNext()) {
                Map.Entry<Character,Integer> entry=(Map.Entry)iterator.next();
                bw.write(entry.toString()+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
