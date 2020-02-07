package annotation;

import java.util.ArrayList;

/**
 * 注解的使用：
 * 1.理解Annotation：
 * (1)jdk5.0新增的功能
 *（2）Annotation其实是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。
 *    通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。代码分析工具、
 *    开发工具和部署工具可以通过这些补充信息进行验证或者进行部署
 * （3）在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
 *     在JavaEE/Android中注解占据类更重要的角色，例如用来配置应用程序的任何切面，
 *     代替JavaEE旧版中所遗留的繁冗代码和XML配置等
 * 2.Annotation的使用示例：
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 *      1.@Override:限定重写父类方法，该注解只能用于方法
        2.@Deprecated:用于表示所修饰的元素（类、方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
        3.@SuppressWarnings:抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解，参照@SuppresWarnings定义
 * (1)注解声明为：@interface
 * (2)内部定义成员，通常使用value表示
 * （3）可以指定成员的默认值，使用default定义
 * （4）如果自定义注解没有成员，表明是一个标识作用  @Override
 * (5)如果注解有成员，在使用注解时，需要指明成员的值
 * 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 * 自定义注解通常都会指明两个元注解：Retention、Target
 * //@MyAnnotation(value ="hello")
 * public @interface MyAnnotation {
     String value();
  }

 4.jdk5.0提供的4种元注解(对现有的注解进行解释说明的注解）
 *******出现频率较高*****
 * Retention---指明所修饰的Annotation的生命周期：
 *             SOURCE\CLASS(默认行为)\RUNTIME（只有声明为RUNTIME生命周期的注解，才能通过反射获取
 * Target------用于指定被修饰的Annnotation能用于修饰哪些程序元素（类、方法、构造器等）
 *
 * *****出现频率较低*****
 * Documented----表示所修饰的注解在被javadoc解析成文档时，可以保留下来，通常生成文档不包括注解
 * Inherited-----表示所修的注解有继承性
 *
 * 5.通过反射获取注解信息---到反射时在讲
 * 6.jdk8中注解的新特性：可重复注解、类型注解
 * （1）可重复注解（写两个一样的注解类型）：
 *     jdk8之前要想重复注解，需要定义一个成员变量是注解类型数组的形式
 *     public @interface MyAnnotations {
           MyAnnotation[] value();
     }
 *用的时候：
 * @MyAnnotations({@MyAnnotation(value ="hello"),@MyAnnotation(value ="hi")})
 *
 *  jdk8之后：（1）在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.class
 *            (2)MyAnnotation的Target和Retention等元注解和MyAnnotations中相同
 *
 * （2）类型注解：
 * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
 * ElementType.TYPE_USE：表示该注解能写在使用类型的任何语句中
 * @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE})
 *
 * @author zhaomin
 * @date 2020/2/5 11:52
 */
//jdk8之后可重复注解
@MyAnnotation(value ="hi")
@MyAnnotation(value = "hello")
public class AnnotationTest {
    @SuppressWarnings("unused")
    int num=0;
    //@MyAnnotation(value ="hello")
    //jdk8之前写重复注解
    @MyAnnotations({@MyAnnotation(value ="hello"),@MyAnnotation(value ="hi")})
    public  void test(){

    }
}
//jdk8新增类型注解，在类型前加注解
class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list=new ArrayList<>();
        int num=(@MyAnnotation int)10L;
    }
}
