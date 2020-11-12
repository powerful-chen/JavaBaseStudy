package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.User");

        // 获取类的名字
        System.out.println(c1.getName()); //reflection.User
        System.out.println(c1.getSimpleName()); //User

        // 获取类的属性
        System.out.println("==========================");
        Field[] fields = c1.getFields(); // 只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = c1.getDeclaredFields();// 找到全部的属性
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        /**
         * 输出：
         * java.lang.String reflection.User.name
         * java.lang.String reflection.User.sex
         * int reflection.User.age
         */
        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name); //java.lang.String reflection.User.name

        // 获得类的方法
        System.out.println("==========================");
        Method[] methods = c1.getMethods(); //获得本类以及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
        /**
         * 正常的：public java.lang.String reflection.User.toString()
         * 正常的：public java.lang.String reflection.User.getName()
         * 正常的：public void reflection.User.setName(java.lang.String)
         * 正常的：public java.lang.String reflection.User.getSex()
         * 正常的：public int reflection.User.getAge()
         * 正常的：public void reflection.User.setSex(java.lang.String)
         * 正常的：public void reflection.User.setAge(int)
         * 正常的：public final void java.lang.Object.wait() throws java.lang.InterruptedException
         * 正常的：public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
         * 正常的：public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
         * 正常的：public boolean java.lang.Object.equals(java.lang.Object)
         * 正常的：public native int java.lang.Object.hashCode()
         * 正常的：public final native java.lang.Class java.lang.Object.getClass()
         * 正常的：public final native void java.lang.Object.notify()
         * 正常的：public final native void java.lang.Object.notifyAll()
         */
        methods = c1.getDeclaredMethods(); //获得本类的所有方法，包括本类的私有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods：" + method);
        }
        /**
         * getDeclaredMethods：public java.lang.String reflection.User.toString()
         * getDeclaredMethods：public java.lang.String reflection.User.getName()
         * getDeclaredMethods：public void reflection.User.setName(java.lang.String)
         * getDeclaredMethods：public java.lang.String reflection.User.getSex()
         * getDeclaredMethods：public int reflection.User.getAge()
         * getDeclaredMethods：public void reflection.User.setAge(int)
         * getDeclaredMethods：public void reflection.User.setSex(java.lang.String)
         */
        // 获得指定方法
        // 重载
        System.out.println("==========================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);//public java.lang.String reflection.User.getName()
        System.out.println(setName);//public void reflection.User.setName(java.lang.String)

        // 获得指定的构造器
        System.out.println("==========================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        /**
         * public reflection.User()
         * public reflection.User(java.lang.String,java.lang.String,int)
         */
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("getDeclaredConstructors:  " + constructor);
        }
        /**
         * getDeclaredConstructors:  public reflection.User()
         * getDeclaredConstructors:  public reflection.User(java.lang.String,java.lang.String,int)
         */
        // 获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, String.class, int.class);
        System.out.println("指定 " + declaredConstructor);//指定 public reflection.User(java.lang.String,java.lang.String,int)
    }

}
