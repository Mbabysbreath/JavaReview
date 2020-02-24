package reflection2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhaomin
 * @date 2020/2/20 21:09
 */
public class ClassLoaderTest {
    /**
     * 三种类加载器--了解
     */
    @Test
    public void test1(){
        //对于自定类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent();获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent(),无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    /**
     * Hashtable的子类Properties使用-用类加载器进行替换
     */
    @Test
    public void test2() throws IOException {
        Properties p=new Properties();
        //方式一读取配置文件：默认文件在当前模块下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        p.load(fis);
//        String user = p.getProperty("user");
//        System.out.println(user);
//        String password = p.getProperty("password");
//        System.out.println(password);

        //方式二：用类加载器读取
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is1 = classLoader.getResourceAsStream("jdbc1.properties");
        p.load(is1);
        String user = p.getProperty("user");
        System.out.println(user);
        String password = p.getProperty("password");
        System.out.println(password);
    }

}
