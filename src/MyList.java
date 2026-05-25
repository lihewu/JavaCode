import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MyList {

    //将List转为数组

    /**
     * 方案一:Java 8 Stream 流
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 🚀 核心魔法：使用 Stream API
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(arr)); // 输出: [1, 2, 3, 4, 5]

        //清理数组
        list.clear();
        System.out.println(list);
    }


}

