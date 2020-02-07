package annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author zhaomin
 * @date 2020/2/5 13:28
 */
//和接口没有关系
@Repeatable(MyAnnotations.class)
@Inherited//继承
@Retention(RetentionPolicy.RUNTIME)  //注解的生命周期
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE})//指明注解可以修饰哪些程序元素
public @interface MyAnnotation {
    String value()default "hello";
}
