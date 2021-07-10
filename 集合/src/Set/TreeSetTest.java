package Set;

/**
 * @ClassName TreeSetTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 15:03
 */

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建一个TreeSet集合，在Set中增加4个工人，基本信息如下：
 * 姓名 年龄 工资
 * Zhang1 18 3000.2
 * li 1 28 500.3
 * li2 66 500.3
 * zhang2 45 3000.2
 * 要求：按照工资降序排序，工资一样的，按照姓名降序排序
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Worker w1 = new Worker("zhang1", 18, 3000.2);
        Worker w2 = new Worker("li1", 25, 500.3);
        Worker w3 = new Worker("zhang2", 18, 3000.2);
        Worker w4 = new Worker("li2", 55, 500.3);
        TreeSet<Worker> set = new TreeSet<>();
        set.add(w1);
        set.add(w2);
        set.add(w3);
        set.add(w4);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
