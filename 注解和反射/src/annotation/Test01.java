package annotation;

import java.util.ArrayList;

public class Test01 extends Object {

    // @Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // Deprecated 不推荐程序员使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    @SuppressWarnings("all")
    public void test2() {
        ArrayList list = new ArrayList();
    }
}
