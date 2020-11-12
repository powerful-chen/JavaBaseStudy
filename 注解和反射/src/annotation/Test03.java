package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
public class Test03 {
    @MyAnnotation2(name = "小陈", age = 18, id = 1, schools = {"我爱你老婆"})
    public void test1() {
    }

    @MyAnnotation3("hello")
    public void test2() {
    }

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数 ：参数类型 + 参数名（）；
    String name() default "";

    int age();

    int id() default -1;// 如果默认值为-1，代表不存在

    String[] schools() default {"我爱黄捷淳", "黄捷淳是我老婆"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();// 当只有一个变量时可以这么表示
}
