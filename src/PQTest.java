import java.util.PriorityQueue;

public class PQTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 乱序入队
        pq.offer(8);
        pq.offer(1);
        pq.offer(5);

        //本质是二叉堆,直接打印的话并不会按照顺序
        System.out.println(pq);//默认为小根堆

        // 出队时，会自动按从小到大的顺序出来！
        System.out.println(pq.poll()); // 输出: 1 (最小的先出)
        System.out.println(pq.poll()); // 输出: 5
        System.out.println(pq.poll()); // 输出: 8

        /**
         * 将小根堆 修改为 大根堆
         */
        // 默认写法：小顶堆 (a - b)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // ⚠️ 进阶写法：大顶堆 (b - a)，告诉 Java 反着来比大小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(15);

        // 这次出队的是最大的！
        System.out.println(maxHeap); // 输出: 15
    }
}