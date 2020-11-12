package reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取系统类加载器的父类加载器--> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent); //sun.misc.Launcher$ExtClassLoader@1b6d

        // 获取扩展类加载器发父类加载器-->根加载器（C/C++）编写的
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); //null

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflection.Test07").getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        // 测试JDK 内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader); //null

        // 如何获取系统类加载器可以加载的路径
        String property = System.getProperty("java.class.path");
        System.out.println(property);

        // 双亲委托机制
        /**
         * D:\java\jdk 1.8\jre\lib\charsets.jar;
         * D:\java\jdk 1.8\jre\lib\deploy.jar;
         * D:\java\jdk 1.8\jre\lib\ext\access-bridge-64.jar;
         * D:\java\jdk 1.8\jre\lib\ext\cldrdata.jar;
         * D:\java\jdk 1.8\jre\lib\ext\dnsns.jar;
         * D:\java\jdk 1.8\jre\lib\ext\jaccess.jar;
         * D:\java\jdk 1.8\jre\lib\ext\jfxrt.jar;
         * D:\java\jdk 1.8\jre\lib\ext\localedata.jar;
         * D:\java\jdk 1.8\jre\lib\ext\nashorn.jar;
         * D:\java\jdk 1.8\jre\lib\ext\sunec.jar;
         * D:\java\jdk 1.8\jre\lib\ext\sunjce_provider.jar;
         * D:\java\jdk 1.8\jre\lib\ext\sunmscapi.jar;
         * D:\java\jdk 1.8\jre\lib\ext\sunpkcs11.jar;
         * D:\java\jdk 1.8\jre\lib\ext\zipfs.jar;
         * D:\java\jdk 1.8\jre\lib\javaws.jar;
         * D:\java\jdk 1.8\jre\lib\jce.jar;
         * D:\java\jdk 1.8\jre\lib\jfr.jar;
         * D:\java\jdk 1.8\jre\lib\jfxswt.jar;
         * D:\java\jdk 1.8\jre\lib\jsse.jar;
         * D:\java\jdk 1.8\jre\lib\management-agent.jar;
         * D:\java\jdk 1.8\jre\lib\plugin.jar;
         * D:\java\jdk 1.8\jre\lib\resources.jar;
         * D:\java\jdk 1.8\jre\lib\rt.jar;
         * E:\Code\JavaBase\注解和反射\out\production\注解和反射;
         * E:\compiler\IDEA\idealone\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar
         */

    }
}
