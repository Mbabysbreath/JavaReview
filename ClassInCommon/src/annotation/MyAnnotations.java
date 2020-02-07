package annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author zhaomin
 * @date 2020/2/5 14:17
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)  //注解的生命周期
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})//指明注解可以修饰哪些程序元素
public @interface MyAnnotations {
    MyAnnotation[] value();
}
