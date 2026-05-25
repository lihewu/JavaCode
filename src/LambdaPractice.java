import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaPractice {
    public static void main(String[] args) {

        System.out.println("========== 关卡 1：无参数，无返回值 (Runnable) ==========");

        // 【传统写法】老包工头招人
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1. 传统工人正在干活...");
            }
        });
        t1.start();

        // 🎯 你的任务 1：用 Lambda 招募一个极速工人
        // 提示：没有参数就用 ()，里面有一行打印代码
        // Thread t2 = new Thread( /* 在这里填入你的 Lambda */ );
        // t2.start();
        Thread t2 = new Thread(() -> System.out.println("1. Lambda工人正在干活..."));
        t2.start();


        System.out.println("\n========== 关卡 2：多参数，有返回值 (Comparator 排序) ==========");

        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1));

        // 【传统写法】对数字进行从大到小（降序）排列
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; // b - a 是降序
            }
        });
        System.out.println("2. 传统写法降序结果: " + numbers);


        // 打乱数组，准备重新排
        Collections.shuffle(numbers);

        // 🎯 你的任务 2：用 Lambda 把数组变成从小到大（升序）排列
        // 提示：左边有两个参数 (a, b)，右边是一行计算逻辑 a - b
        // Collections.sort(numbers, /* 在这里填入你的 Lambda */ );
        // System.out.println("2. Lambda 升序结果: " + numbers);
        Collections.sort(numbers,(a,b) -> a - b);
        System.out.println("2. Lambda 升序结果: " + numbers);


        System.out.println("\n========== 关卡 3：单参数，无返回值 (forEach 遍历) ==========");

        List<String> names = List.of("Java", "Python", "Go", "C++");

        // 【传统写法】普通的增强 for 循环
        System.out.println("3. 传统 for 循环遍历：");
        for (String name : names) {
            System.out.println("学习: " + name);
        }

        // 🎯 你的任务 3：使用 List 自带的 forEach 方法结合 Lambda 进行遍历
        // 提示：forEach 方法每次会吐出一个名字，你只需要接收它并打印出来。
        // 因为只有一个参数，你连括号都可以省掉！
        // System.out.println("3. 极其优雅的 Lambda 遍历：");
        // names.forEach( /* 在这里填入你的 Lambda */ );
        System.out.println("3. 极其优雅的 Lambda 遍历：");
        names.forEach(a -> System.out.println("Lambda学习： " + a));
    }
}
