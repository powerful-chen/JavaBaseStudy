package reflection;

// 测试Class类的创建方式有哪些
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        Person t1 = new Teacher();
        Class c = Class.forName("reflection.Teacher");
        System.out.println(c.hashCode());//460141958

        // 方式一：通过forName获得
        Class c1 = Class.forName("reflection.Student");
        System.out.println(c1.hashCode());//1163157884

        // 方式二：通过对象获得
        Class c2 = person.getClass();
        System.out.println(c2.hashCode());//1163157884

        // 方式三：通过类名.class 获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());//1163157884

        // 方式四：基本内置类型的包装类都有一个Type 类型
        Class c4 = Integer.TYPE;
        System.out.println(c4);// int

        // 通过父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);// class reflection.Person

    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
