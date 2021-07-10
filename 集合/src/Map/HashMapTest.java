package Map;

/**
 * @ClassName HashMapTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 15:26
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 现有一个数组int[] a=new int[]{1,2,3,22,3,4,2,4};请统计出每个数字出现的次数，输出格式如下：数字1出现1次，数字2出现2次，数字……
 * 思路：数组元素放在map的key值里，出现的次数放在value值里。
 */
public class HashMapTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 22, 3, 4, 2, 4};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println(key + "出现了" + map.get(key) + "次");
        }
    }
}
