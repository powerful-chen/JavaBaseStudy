package Map;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName MapIterator
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/10 6:41
 */
// Map的三种遍历方式
public class MapIterator {
    //用keySet()遍历
    @Test
    public void test01() {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "淳淳");
        map.put("002", "钊钊");
        Set<String> set = map.keySet();//把map里的key存入set中
        Iterator<String> it = set.iterator();//通过迭代器遍历set
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + "---" + map.get(key));
        }
    }

    //用values()遍历
    @Test
    public void test02() {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "淳淳");
        map.put("002", "钊钊");
        Collection<String> collection = map.values();//把map的value存入到Collection集合中
        Iterator<String> iterator = collection.iterator();//通过迭代器遍历collection集合
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //用entrySet()创建Entry对象
    @Test
    public void test03() {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "淳淳");
        map.put("002", "钊钊");
        Collection<Map.Entry<String, String>> c = map.entrySet();//把map中的key和value一起存入Collection中
        Iterator<Map.Entry<String, String>> it = c.iterator();//遍历
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
