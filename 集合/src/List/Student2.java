package List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 11:26
 */
// 学生List去重后重新输出List
public class Student2 {
    private String stuNo;
    private String stuName;
    private int age;

    public Student2() {
    }

    public Student2(String stuNo, String stuName, int age) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.age = age;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }

    //另外在Set比较自定义类型是否相等时还要先比较hashcode是否相等
    @Override
    public int hashCode() {
        return this.stuNo.hashCode() * 11 + this.stuName.hashCode() * 13 + this.age * 17;
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        Student2 s = (Student2) obj;
        if (s.stuNo.equals(this.stuNo) && s.stuName.equals(this.stuName) && s.age == this.age) {
            return true;
        }
        return false;
    }
}
