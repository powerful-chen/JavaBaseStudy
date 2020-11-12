package reflection;

public class Test06 {

    static {
        System.out.println("Main被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1、主动引用
//        Son son = new Son();// Main被加载 父类被加载 子类被加载

        // 反射也会产生主动引用
//        Class.forName("reflection.Son");// Main被加载 父类被加载 子类被加载

        // 不会产生类的引用的方法
//        System.out.println(Son.b);// Main被加载 父类被加载 2
//        Son[] array = new Son[5];// Main被加载

        System.out.println(Son.M);// Main被加载 1
    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}