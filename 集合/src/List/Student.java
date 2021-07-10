package List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 11:26
 */
// 学生List去重后重新输出List
public class Student {
    private String stuNo;
    private String stuName;
    private int age;

    public Student() {
    }

    public Student(String stuNo, String stuName, int age) {
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
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        if (s.stuNo.equals(this.stuNo) && s.stuName.equals(this.stuName) && s.age == this.age) {
            return true;
        }
        return false;
    }
}
