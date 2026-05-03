import java.util.HashMap;//导入HashMap类

public class MyHashMap {
    public static void main(String[] args) {
        // 创建 HashMap 对象 Sites,其Key-Value值为int-String
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对[.put方法]
        Sites.put(1, "数组");
        Sites.put(2, "链表");
        Sites.put(3, "二叉树");
        Sites.put(4, "哈希表");
        Sites.put(5, "排序");
        System.out.println(Sites);

        //创建Key-Value值为String-String的HashMap对象
        HashMap<String, String> Sites2 = new HashMap<String, String>();
        Sites2.put("测试","验收");
        Sites2.put("审核","评估");
        System.out.println(Sites2);

        //get方法获取 其key值对应的Value值
        System.out.println("key=3对应的value值是:"+Sites.get(3));

        //remove(key)方法删除key对应的键对值
        Sites.remove(4);
        System.out.println("remove后的Sites"+Sites);

        //size方法计算大小
        System.out.println(Sites.size());


    }
}
