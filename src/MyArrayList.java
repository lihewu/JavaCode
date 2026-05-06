import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class MyArrayList {
    public static void main(String[] args) {
        /*
        Arrays方法的asList 数组转集合
         */
        String[] arr = {"A", "B", "C"};
        List<String> list = Arrays.asList(arr);

        //错误写法❌Arrays.asList返回的是Arrays的静态内部类，是一个假List
        //list.add("D");

        //正确写法✔
        List<String> realList = new ArrayList<>(list);//把List丢给ArrayList的构造方法中
        System.out.println(realList);

        // 我们修改了 List 中的第一个元素
        list.set(0, "X");

        // 猜猜原数组变成了什么？
        System.out.println("原数组: " + Arrays.toString(arr));
        // ⚠️ 输出: 原数组: [X, B, C]


    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.sort(nums);
//        return ret;
//    }
}