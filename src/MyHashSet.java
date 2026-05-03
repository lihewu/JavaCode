import java.util.HashSet;

public class MyHashSet {
    public static void main(String[] args) {
        //HashSet对象创建,HashSet无Key值
        HashSet<String> set = new HashSet<String>();
        set.add("数组");
        set.add("链表");
        set.add("二叉树");
        set.add("哈希表");
        System.out.println(set);
        System.out.println("set的长度="+set.size());

        set.remove("二叉树");
        System.out.println("remove后长度="+set.size());

        //判断是否包含
        System.out.println(set.contains("哈希表"));


    }
}
