package Set;

/**
 * @ClassName HashSetTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 14:58
 */

import java.util.HashSet;
import java.util.Iterator;

/**
 * )创建一个HashSet集合，在Set中增加4个工人，基本信息如下：
 * 姓名 年龄 工资
 * zhang 18 3000.2
 * li 25 500.3
 * li 25 500.3
 * zhang 18 3000.2
 * 要求：将三个对象去重，去重条件为：姓名，年龄，工资都一样的对象，认为“相等”，即重复了。
 */
public class HashSetTest {
    public static void main(String[] args) {
        Worker w1 = new Worker("zhang", 18, 3000.2);
        Worker w2 = new Worker("li", 25, 500.2);
        Worker w3 = new Worker("zhang", 18, 3000.2);
        Worker w4 = new Worker("li", 25, 500.2);
        HashSet<Worker> set = new HashSet<>();
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
