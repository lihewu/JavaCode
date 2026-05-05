import java.util.Map;
import java.util.HashMap;//导入HashMap类

public class MyHashMap {
    public static void main(String[] args) {
        // 1. 创建第一个 HashMap (目标 Map)
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Java", 90);
        map1.put("Python", 85);

        System.out.println("合并前的 map1: " + map1);

        // 2. 创建第二个 HashMap (数据来源 Map)
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("C++", 80);
        map2.put("Java", 95); // 注意：这里也有 "Java" 这个键，值不同

        // 3. 使用 putAll() 方法，将 map2 的内容合并到 map1 中
        map1.putAll(map2);

        // 4. 打印合并后的结果
        System.out.println("合并后的 map1: " + map1);
    }


//    public static void main(String[] args) {
//        // 创建 HashMap 对象 Sites,其Key-Value值为int-String
//        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
//        // 添加键值对[.put方法]
//        Sites.put(1, "数组");
//        Sites.put(2, "链表");
//        Sites.put(3, "二叉树");
//        Sites.put(4, "哈希表");
//        Sites.put(5, "排序");
//        System.out.println(Sites);
//
//        //创建Key-Value值为String-String的HashMap对象
//        HashMap<String, String> Sites2 = new HashMap<String, String>();
//        Sites2.put("测试","验收");
//        Sites2.put("审核","评估");
//        System.out.println(Sites2);
//
//        //get方法获取 其key值对应的Value值
//        System.out.println("key=3对应的value值是:"+Sites.get(3));
//
//        //remove(key)方法删除key对应的键对值
//        Sites.remove(4);
//        System.out.println("remove后的Sites"+Sites);
//
//        //size方法计算大小
//        System.out.println(Sites.size());
//
//
//    }
}
