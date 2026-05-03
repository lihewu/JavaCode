import java.util.HashMap;//导入HashMap类

public class MyHashMap {
    public static void main(String[] args) {
        // 创建 HashMap 对象 Sites
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "数组");
        Sites.put(2, "链表");
        Sites.put(3, "二叉树");
        Sites.put(4, "哈希表");
        System.out.println(Sites);
    }
}
