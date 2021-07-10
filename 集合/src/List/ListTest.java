package List;

import java.util.ArrayList;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 11:33
 */
// 学生List去重后重新输出List
public class ListTest {
    //方法一：定义另一个新集合，如果不包含旧集合的元素则加到新集合里。(自定义类型重写equals())
    public static void nonDuplicate(ArrayList<Student> list) {
        ArrayList<Student> listNew = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //contains默认调用equals()方法
            if (!listNew.contains(list.get(i))) {
                listNew.add(list.get(i));
            }
        }
        System.out.println(listNew);
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("001", "淳淳", 22);
        Student s2 = new Student("002", "钊钊", 21);
        Student s3 = new Student("002", "钊钊", 21);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        nonDuplicate(list);
    }
}
