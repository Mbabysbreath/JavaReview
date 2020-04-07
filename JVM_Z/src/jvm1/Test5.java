package jvm1;

/**
 * 类加载器之间的关系是包含关系，不是继承关系
 * @author zhaomin
 * @date 2020/4/6 22:56
 */
public class Test5 {
    public static void main(String[] args) {
        //获取系统类加载器:sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader=ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取其上层:扩展类加载器:sun.misc.Launcher$ExtClassLoader@4554617c
        ClassLoader exClassLoader = systemClassLoader.getParent();
        System.out.println(exClassLoader);

        //试图获取其上层:（启动）引导类加载器。获取不到为null
        ClassLoader bootstrapClassLoader = exClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //用户自定义类，默认使用系统类加载器进行加载sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = Test5.class.getClassLoader();
        System.out.println(classLoader);
        //String类；null --String类使用引导类加载器进行加载的--》java的核心类库都是由引导类加载器加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
