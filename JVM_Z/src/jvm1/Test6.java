package jvm1;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author zhaomin
 * @date 2020/4/7 18:54
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println("====启动类加载器=====");
        //获取引导类加载器BootstrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element);
        }
    //从上面的路径中随意选择一个类，观察他的类加载器是什么：引导类加载器--null
        ClassLoader classLoader=Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("====扩展类加载器===");
        String property = System.getProperty("java.ext.dirs");
        for(String path:property.split(";")){
            System.out.println(path);
        }
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
