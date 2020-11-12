package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取Class对象
        Class c1 = Class.forName("reflection.User");

        // 构造一个对象
//        User user = (User) c1.newInstance(); //本质是调用了类的无参构造器
//        System.out.println(user); //User{name='null', sex='null', age=0}

        // 通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, String.class, int.class);
//        User user2 = (User) constructor.newInstance("小陈", "男", 18);
//        System.out.println(user2); //User{name='小陈', sex='男', age=18}

        //通过反射调用普通方法
//        User user3 = (User) c1.newInstance();
//        //通过反射获取一个方法
//        Method setName = c1.getDeclaredMethod("setName", String.class);
//
//        //invoke :激活的意思
//        //（对象，"方法的值"）
//        // !!!!注意：需要调用无参构造方法才不会报错
//        setName.invoke(user3, "小陈");
//        System.out.println(user3.getName());//小陈

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        // 不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);

        name.set(user4, "小陈2");//小陈2
        System.out.println(user4.getName());

    }
}
