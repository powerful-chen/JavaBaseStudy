package Set;

/**
 * @ClassName Worker
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 14:34
 */

/**
 * 创建一个HashSet集合，在Set中增加4个工人，基本信息如下：
 * 姓名 年龄 工资
 * zhang 18 3000.2
 * li 25 500.3
 * li 25 500.3
 * zhang 18 3000.2
 * 要求：将三个对象去重，去重条件为：姓名，年龄，工资都一样的对象，认为“相等”，即重复了。
 */
public class Worker implements Comparable<Worker> {
    private String name;
    private int age;
    private double salary;

    public Worker() {
    }

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 11 + this.age * 13 + String.valueOf(this.salary).hashCode() * 17;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Worker) {//instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例
            Worker w = (Worker) obj;
            if (this.name.equals(w.name) && this.age == w.age && this.salary == w.salary) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Worker w) {
        return w.salary == this.salary ? w.name.compareTo(this.name) : (int) (w.salary - this.salary);
    }
}
