package List;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName ListTest2
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 11:54
 */
public class ListTest2 {
    public static void nonDuplicate(ArrayList<Student2> list) {
        HashSet<Student2> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Student2> list = new ArrayList<>();
        Student2 s1 = new Student2("001", "淳淳", 22);
        Student2 s2 = new Student2("001", "淳淳", 22);
        Student2 s3 = new Student2("002", "钊钊", 22);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        nonDuplicate(list);
    }
}
