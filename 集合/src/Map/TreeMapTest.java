package Map;

/**
 * @ClassName TreeMapTest
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 15:38
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * 写一个方法，传入一个int数组，返回一个结果，结果内包含每个数字出现的次数，并按照出现的次数降序，如果次数相同则按照数字进行降序排序
 * 例如：int[] numbers=new int[]{49,8,49,59,1,30,1,49};
 * 统计完结果为：数字49 次数3，数字59 次数2，数字30 次数1，数字8次数1
 */
class Com implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class TreeMapTest {
    public static void sort(int[] numbers) {
        Com com = new Com();
        TreeMap<Integer, Integer> map = new TreeMap<>(com);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            } else {
                map.put(numbers[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("数字" + key + " 次数" + map.get(key) + ",");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {49, 8, 49, 59, 1, 30, 1, 49};
        sort(numbers);
    }
}
