import java.util.*;
//import java.util.Stack;//最垃圾的类，没有之一

/**
 * oh yeah开启我的DP时间
 */


/**
 * 96，n个节点的二叉搜索树有多少种可能
 */

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //空树也表示一颗BST
        dp[0] = 1; dp[1] = 1;
        //记录总数为i的节点一共可能的二叉搜索树个数
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                //节点总数为i的，不同长度的左右子树情况之和
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}


/**
 * 63.不同路径Ⅱ
 */

//class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        //防空
//        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
//        //如果起点/中点有障碍，无法通行
//        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
//        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
//
//        for(int i = 0; i < obstacleGrid.length; i++) {
//            if(obstacleGrid[i][0] == 1) break;  //当其中一块被石头挡住之后，后续所有路都为0
//            dp[i][0] = 1;
//        }
//        for(int i = 0; i < obstacleGrid[0].length; i++) {
//            if(obstacleGrid[0][i] == 1) break;
//            dp[0][i] = 1;
//        }
//
//        for(int i = 1; i < obstacleGrid.length; i++) {
//            for(int j = 1; j < obstacleGrid[0].length; j++) {
//                if(obstacleGrid[i][j] == 0) {
//                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                } else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return dp[dp.length - 1][dp[0].length - 1];
//    }
//}



/**
 * 62.不同路径
 */

//class Solution {
//    public int uniquePaths(int m, int n) {
//        if(m == 0) return n;
//        if(n == 0) return m;
//
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for(int i = 0; i < n; i++) {
//            dp[0][i] = 1;
//        }
//
//        for(int i = 1; i < m; i++) {
//            for(int j = 1; j < n; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }
//}


/**
 * 746.最小花费爬楼梯
 */
//
//class Solution {
//    public int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length];//dp[i],表示走到第i格所需要的最小体力
//        dp[0] = 0; dp[1] = 0;
//        for(int i = 2; i < dp.length; i++) {
//            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
//        }
//        return Math.min(dp[dp.length-1] + cost[dp.length-1] , dp[dp.length-2] + cost[dp.length-2]);
//    }
//}


/**
 * 70.跳楼梯
 */

//class Solution {
//    public int climbStairs(int n) {
//        if(n <= 2) return n;
//        int a = 1; int b = 2; int c = 0;
//        for(int i = 3; i <= n; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//}



/**
 * 509.斐波那契数列
 */

//class Solution {
//    public int fib(int n) {
//        if (n < 2) return n;
//        int a = 0, b = 1, c = 0;
//        for (int i = 1; i < n; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//}

//非压缩写法
//class Solution {
//    int[] dp;
//    public int fib(int n) {
//        if(n < 2) {
//            return n;
//        }
//        dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i < n + 1; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//            System.out.println("dpi is " + dp[i]);
//        }
//        return dp[n];
//    }
//}








/**
 * 正式进入-贪心算法greedyProblem
 */



//class Solution {
//    int count = 0;
//    public int minCameraCover(TreeNode root) {
//        if(root == null) return 0;
//        //如果根节点在呼救，说明根节点需要一个摄像头
//        if(postOrder(root) == 0) return count+1;
//        return count;
//    }
//
//    /**
//     * 状态值：
//     * 0.表示未被覆盖,请求父节点覆盖（贪心：叶子节点装摄像头的话浪费）
//     * 1.表示有摄像头，可以覆盖孩子节点/父节点
//     * 2.表示被覆盖，但是无摄像头
//     * @param root
//     * @return 当前节点状态值 int
//     */
//    //后续遍历,从底部开始判断
//    private int postOrder(TreeNode root) {//每个节点，都根据其孩子的返回值判断是否需要装监控
//        //空节点一定是被覆盖的状态，因为我们不可能因为空节点取给叶子节点装摄像头
//        if(root == null) return 2;
//
//        //只有记录左右子树，才能表示遍历整棵树，不然只是单边遍历
//        int left = postOrder(root.left);
//        int right = postOrder(root.right);
//
//        //如果有任一个孩子呼叫，当前节点必须装摄像头
//        if(left == 0 || right == 0) {
//            count++;
//            return 1;
//        }
//        //如果有孩子都被覆盖，当前节点很危险，开始呼救
//        if(left == 2 && right == 2) return 0;
//        //剩余情况只有孩子有摄像头了,一人吃饱，全家不饿
//        else return 2;
//
//    }
//}






/**
 * 738.单调递增的数字
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 输入: n = 1234
 * 输出: 1234
 */

//class Solution {
//    public int monotoneIncreasingDigits(int n) {
//        //比传统的while处理更方便
//        String str = String.valueOf(n);
//        char[] ch = str.toCharArray();
//
//        int pos = ch.length;
//        for(int i = ch.length-2; i >= 0; i--) {
//            if(ch[i] > ch[i+1]) {
//                ch[i]--;
//                pos = i+1;
//            }
//        }
//
//        for(int i = pos; i < ch.length; i++) {
//            ch[i] = '9';
//        }
//
//        return Integer.parseInt(String.valueOf(ch));
//    }
//}

/**
 * 56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 */
//
//class Solution {
//    public int[][] merge(int[][] intervals) {
//        if(intervals == null || intervals.length == 0) return new int[0][];
//
//        List<int[]> resList = new ArrayList<>();
//
//        //根据起始区域进行排序
//        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
//        //记录起始位置
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        for(int i = 1; i < intervals.length; i++) {
//            //如果当前元素起始位置 > 上一元素起始位置
//            if(intervals[i][0] > end) {
//                int[] temp = {start,end};
//                resList.add(temp);
//                start = intervals[i][0];
//                end = intervals[i][1];
//            } else { //如果区域发生重叠，则右边界取最大值
//                end = Math.max(intervals[i][1],end);
//            }
//        }
//        //处理最后一个
//        resList.add(new int[]{start,end});
//        int[][] ret = new int[resList.size()][];
//        for(int i = 0; i < resList.size(); i++) {
//            ret[i] = resList.get(i);
//        }
//        return ret;
//    }
//}



/**
 * 763.划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 */

//
//class Solution {
//    public List<Integer> partitionLabels(String s) {
//        if(s == null) return new ArrayList<>();
//
//        List<Integer> resList = new ArrayList<>();
//        //记录每个字母最后一次出现在char[]的下标
//        int[] lastIndex = new int[26];
//        char[] str = s.toCharArray();
//
//        for(int i = 0; i < str.length; i++) {
//            lastIndex[str[i] - 'a'] = i;
//        }
//        //记录当前已经遍历元素的最大下标
//        int maxIndex = 0;
//        //记录先前内容的最后Index
//        int preLast = -1;
//        for(int i = 0; i < str.length; i++) {
//            //当前已经包含的元素最远位置
//            maxIndex = Math.max(maxIndex,lastIndex[str[i] - 'a']);
//            if(i == maxIndex) {
//                resList.add(i - preLast);
//                preLast = i;
//            }
//        }
//        return resList;
//    }
//}



/**
 * 435.无重叠区域
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠
 * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的
 */


//class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if(intervals == null || intervals.length == 0) return 0;
//
//        int count = 0;
//        //直接按照右边界排序
//        Arrays.sort(intervals,Comparator.comparing(a -> a[1]));
//        for(int i = 1; i < intervals.length; i++) {
//            //发生重叠
//            if(intervals[i][0] < intervals[i-1][1]) {
//                count++;
//                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
//            }
//        }
//        return count;
//    }
//}

//class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if(intervals == null || intervals.length == 0) return 0;
//
//        //根据左边界排序
//        Arrays.sort(intervals,Comparator.comparing(a -> a[0]));
//        int count = 0;
//        for(int i = 1; i < intervals.length; i++) {
//            //如果边界重合
//            if(intervals[i][0] < intervals[i-1][1]) {
//                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
//                count++;
//            }
//        }
//        return count;
//    }
//}



/**
 * 425.最小箭头数
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * 墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */

//class Solution {
//    public int findMinArrowShots(int[][] points) {
//        if(points == null || points.length == 0) return 0;
//
//        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
//        //只要数组非空,必定需要一个
//        int count = 1;
//        for(int i = 1; i < points.length; i++) {
//            if(points[i][0] > points[i-1][1]) {//如果当前气球左边界 > 重叠气球右边界，需要新的弓箭
//                count++;
//            } else {
//                //将重叠区域的右边界更改为旧重叠区域 与新气球的最小右边界
//                points[i][1] = Math.min(points[i][1],points[i-1][1]);
//            }
//        }
//        return count;
//    }
//}


/**
 * 860.柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
//
//class Solution {
//    public boolean lemonadeChange(int[] bills) {
//        int moneyFive = 0;
//        int moneyTen = 0;
//        for(int i = 0; i < bills.length; i++) {
//            if(bills[i] == 5) moneyFive ++;
//            if(bills[i] == 10) {
//                moneyFive--;
//                moneyTen++;
//            }
//            if(bills[i] == 20) {
//                if(moneyTen > 0) {//如果有十元钱，优先用十元钱
//                    moneyTen--;
//                }else {
//                    moneyFive -= 2;
//                }
//                moneyFive--;
//            }
//
//            if(moneyTen < 0 || moneyFive < 0) return false;
//        }
//        return true;
//    }
//}


/**
 * 406.根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）
 */


//
//class Solution {
//    public int[][] reconstructQueue(int[][] people) {
//        if(people == null) return new int[0][0];
//        //同样是两次贪心，但是可以进行内部排序
//        //对身高进行排序，身高较高的人排在前面
//        Arrays.sort(people,(a,b) -> {
//            //如果身高相同，对k进行升序排列
//            if(a[0] == b[0]) return a[1] - b[1];
//            return b[0] - a[0];
//        });
//        //建立一个队列用来进行插入操作
//        List<int[]> queue = new ArrayList<>();
//        //奇迹出现，每次选取都是当前最大且最靠前的people
//        for(int[] i : people) {
//            //把i插入到k的位置中(因为每次选取都是当前最大值，如果想要满足前面有k个人，一定会插入到index = k的位置)
//            queue.add(i[1],i);
//        }
//        return queue.toArray(new int[people.length][]);
//    }
//}



/**
 * 135.分糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */


//class Solution {
//    public int candy(int[] ratings) {
//        if(ratings == null || ratings.length == 0) return 0;
//        //建立数组存储每个人的糖果数量
//        int[] candy = new int[ratings.length];
//        Arrays.fill(candy,1);
//
//        //第一次贪心，比左边大就比左边+1
//        for(int i = 1; i < ratings.length; i++){//左边界边界默认为1
//            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
//        }
//        //第二次贪心:比右边大就比右边多1
//        for(int i = ratings.length - 2; i >= 0; i--) {//右边界默认为1
//            if(ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i+1] + 1,candy[i]);
//        }
//
//        int sum = 0;
//        for(int i : candy) {
//            sum += i;
//        }
//        return sum;
//    }
//}



/**
 * 134.加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的
 */

//贪心找最小:
//class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int totalSum = 0;//全程的燃油结余
//        int curSum = 0;//当前节点出发的燃油结余
//        int startPos = 0;
//        for(int i = 0; i < gas.length; i++) {
//            //当前站点出发的燃油结余
//            int rest = gas[i] - cost[i];
//            //计算燃油总量
//            totalSum += rest;
//            curSum += rest;
//
//            if(curSum < 0) {//如果当前节点出发的燃油结余<0，说明cur站点出发无法通行，中间站点也一定为负
//                curSum = 0;
//                startPos = i + 1;
//            }
//        }
//        //若燃油总量<耗油总量，则不存在可行性
//        if(totalSum < 0) return -1;
//        return startPos;
//    }
//}

//暴力解:
//class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
//        //for循环用于从头到尾遍历
//        for(int i = 0; i < gas.length; i++) {
//            //表示剩余汽油含量
//            int rest = gas[i] - cost[i];
//            //记录坐标位置
//            int index = (i + 1) % gas.length;
//            //while用于环形遍历
//            while(index != i && rest > 0) {
//                rest += gas[index] - cost[index];
//                index = (index + 1) % gas.length;
//            }
//            //一定要这样写，不然到无法处理到终点时 rest = 0的情况
//            if(rest >= 0 && index == i) return i;
//        }
//        return -1;
//    }
//}



/**
 * 1005.k次取反后的最大值
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和
 */


//class Solution {
//    public int largestSumAfterKNegations(int[] nums, int k) {
//        if(nums == null || nums.length == 0) return 0;
//
//        int sum = 0;
//
//        Arrays.sort(nums);
//        //先把可以反转的负数反转了
//        for(int i = 0 ; i < nums.length; i++) {
//            //当可以反转，且待处理的元素为负时
//            if(k > 0 && nums[i] < 0) {
//                nums[i] = -nums[i];
//                k--;
//            }
//        }
//        //处理剩余的k
//        if(k % 2 == 1) {
//            int minPos = 0;
//            //遍历，而非排序（因为排序是o(nlogn)）
//            for(int i = 1; i < nums.length; i++) {
//                if(nums[i] < nums[minPos]) minPos = i;
//            }
//            nums[minPos] = -nums[minPos];
//        }
//        //求和
//        for(int i : nums) {
//            sum += i;
//        }
//        return sum;
//    }
//}


/**
 * leetcode45.跳跃游戏Ⅱ
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * 0 <= j <= nums[i] 且 i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1
 */

//class Solution {
//    public int jump(int[] nums) {
//        if(nums == null || nums.length <= 1) return 0;
//        int count = 0;//记录跳跃次数
//        //当前遍历中，能跳的最远距离
//        int curDistance = 0;
//        //最大能跳跃范围
//        int maxDistance = 0;
//        for(int i = 0; i < nums.length; i++) {
//            //时刻更新能到达的最远distance
//            maxDistance = Math.max(maxDistance,i + nums[i]);
//
//            //如果遍历到起跳的最远距离,说明必须进行下一跳才能继续
//            if(i == curDistance) {
//                count++;
//                curDistance = maxDistance;
//            }
//        }
//        return count;
//    }
//
//}


/**
 * leetcode55.跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
 */
//
//class Solution {
//    public boolean canJump(int[] nums) {
//        if(nums == null || nums.length == 0) return false;
//        //记录跳的最远的位置
//        int cover = 0;
//        for(int i = 0; i <= cover; i++) {
//            cover = Math.max(cover,i + nums[i]);
//            if(cover >= nums.length - 1) return true;
//        }
//        return false;
//    }
//}



/**
 * 122.买卖股票的最佳时机
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
 * 返回 你能获得的 最大 利润
 */


//class Solution {
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 0) return 0;
//        //初始利润为0
//        int profit = 0;
//        for(int i = 1; i < prices.length; i++){
//            if(prices[i] > prices[i - 1]) {
//                //如果当前股票为上升趋势
//                profit += prices[i] - prices[i - 1];
//            }
//        }
//        return profit;
//    }
//}



/**
 * 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */

//class Solution {
//    public int maxSubArray(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if(sum > max) max = sum;
//            //贪心算法的核心:如果sum已经<0，说明前面的累加已经无意义，该丢弃的丢弃
//            if(sum < 0) sum = 0;
//        }
//        return max;
//    }
//}


/**
 * 376.摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度
 */

//class Solution {
//    public int wiggleMaxLength(int[] nums) {
//        if(nums.length < 2) return nums.length;
//
//        //只要长度>1,最小子序列长一定为1
//        int maxLength = 1;
//        int pre = 0;
//        int cur = 0;
//
//        for(int i = 1; i < nums.length; i++) {
//            cur = nums[i] - nums[i-1];
//            // 核心判断：出现峰谷（允许 preDiff = 0，为了兼容初始起点和平坡的情况）
//            if ( (pre<=0 && cur > 0) || (pre >= 0 && cur <0) )  {
//                maxLength++;
//                //千万不要写在外面，需要记录具有方向的梯度
//                pre = cur;
//            }
//        }
//        return maxLength;
//    }
//}




/**
 2410. 运动员和训练师的最大匹配数
 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，
 同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。
 除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
 */

//class Solution {
//    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
//        if(players == null || players.length == 0 || trainers == null || trainers.length == 0) return 0;
//        int count = 0;
//        Arrays.sort(players);
//        Arrays.sort(trainers);
//        int i = players.length - 1;
//        int j = trainers.length - 1;
//        while(i >= 0 && j >= 0) {
//            if(players[i] <= trainers[j]) {
//                j--;
//                count++;
//            }
//            i--;
//        }
//        return count;
//    }
//}


/**
 * 455.分配饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是满足尽可能多的孩子，并输出这个最大数值。
 */

//class Solution {
//    public int findContentChildren(int[] g, int[] s) {
//        //依旧排序
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int count = 0;
//        int sPos = s.length - 1;
//        int gPos = g.length - 1;
//        while(sPos >= 0 && gPos >= 0) {//当有一份满足时，结束
//            if(s[sPos] >= g[gPos]) {
//                sPos--;
//                count++;
//            }
//            gPos--;
//        }
//        return count;
//    }
//}


/**
 * 正式进入-回溯算法
 */

/**
 * N皇后问题
 */
//
//class Solution {
//    List<List<String>> res = new ArrayList<>();
//
//    public List<List<String>> solveNQueens(int n) {
//        char[][] chessboard = new char[n][n];
//        for (char[] c : chessboard) {
//            Arrays.fill(c, '.');
//        }
//        backTrack(n, 0, chessboard);
//        return res;
//    }
//
//
//    public void backTrack(int n, int row, char[][] chessboard) {
//        if (row == n) {
//            res.add(Array2List(chessboard));
//            return;
//        }
//
//        for (int col = 0;col < n; ++col) {
//            if (isValid (row, col, n, chessboard)) {
//                chessboard[row][col] = 'Q';
//                backTrack(n, row+1, chessboard);
//                chessboard[row][col] = '.';
//            }
//        }
//
//    }
//
//
//    public List Array2List(char[][] chessboard) {
//        List<String> list = new ArrayList<>();
//
//        for (char[] c : chessboard) {
//            list.add(String.copyValueOf(c));
//        }
//        return list;
//    }
//
//
//    public boolean isValid(int row, int col, int n, char[][] chessboard) {
//        // 检查列
//        for (int i=0; i<row; ++i) { // 相当于剪枝
//            if (chessboard[i][col] == 'Q') {
//                return false;
//            }
//        }
//
//        // 检查45度对角线
//        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
//            if (chessboard[i][j] == 'Q') {
//                return false;
//            }
//        }
//
//        // 检查135度对角线
//        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
//            if (chessboard[i][j] == 'Q') {
//                return false;
//            }
//        }
//        return true;
//    }
//}

/**
 * leetcode47.回溯算法-排列-全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

//class Solution {
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    boolean[] used;
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        if(nums == null || nums.length == 0) return resList;
//
//        used = new boolean[nums.length];
//        Arrays.fill(used,false);
//        Arrays.sort(nums);
//        backtracking(nums);
//        return resList;
//    }
//    private void backtracking(int[] nums) {
//        if(path.size() == nums.length) {
//            resList.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i = 0; i < nums.length; i++){
//            if(used[i]) continue;
//            //核心语句,只有当前的nums[i-1]相同，且未被used（说明后面还要再use），说明重复，需要剪枝
//            if(i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
//
//            path.add(nums[i]);
//            used[i] = true;
//            backtracking(nums);
//            used[i] = false;
//            path.removeLast();
//        }
//    }
//}





/**
 * leetcode46.回溯算法-排列-全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */

//
//class Solution {
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    //用于记录本层是否用过该元素
//    boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//        if(nums == null || nums.length == 0) return resList;
//        //重新实例化当前数组
//        used = new boolean[nums.length];
//        backtracking(nums);
//        return resList;
//    }
//    private void backtracking(int[] nums){
//        if(path.size() == nums.length) {
//            resList.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i = 0; i < nums.length; i++) {
//            //如果本层中，当前元素以及被使用，则跳过该元素
//            if(used[i]) continue;
//
//            used[i] = true;//use了num[i]
//            path.add(nums[i]);
//            backtracking(nums);
//            used[i] = false;//归还的时候，必须也要归还nums[i]
//            path.removeLast();
//        }
//    }
//}




/**
 * leetcode491.非递减子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况
 */

//class Solution {
//
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        if(nums == null || nums.length == 0) return resList;
//        backtracking(nums,0);
//        return resList;
//    }
//    private void backtracking(int[] nums, int startPos) {
//        if(path.size() >= 2) {
//            resList.add(new ArrayList<>(path));
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        for(int i = startPos; i < nums.length; i++) {
//            //一定要注意，getLast()和getFirst的防空处理
//            if(path.isEmpty() || nums[i] >= path.getLast()) {
//                if(!set.contains(nums[i])) {
//                    set.add(nums[i]);
//                    path.add(nums[i]);
//                    backtracking(nums,i+1);
//                    path.removeLast();
//                }
//            }
//        }
//    }
//}



/**
 * leetcode 90 子集Ⅱ
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */

//class Solution {
//
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        if(nums == null || nums.length == 0) return resList;
//
//        //因为此时nums含有重复元素，需要剪枝操作
//        Arrays.sort(nums);
//
//        backtracking(nums,0);
//        return resList;
//    }
//    private void backtracking(int[] nums,int startPos){
//        resList.add(new ArrayList<>(path));//解释了为什么开头就有空元素
//        for(int i = startPos; i < nums.length; i++) {
//            if(i > startPos && nums[i] == nums[i-1]) continue;
//            path.add(nums[i]);
//            backtracking(nums,i+1);
//            path.removeLast();
//        }
//    }
//}


/**leetcode.78 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 */

//class Solution {
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums == null || nums.length == 0) return resList;
//        backtracking(nums,0);
//        return resList;
//    }
//    private void backtracking(int[] nums,int startPos){
//        resList.add(new ArrayList<>(path));//解释了为什么开头就有空元素
//        for(int i = startPos; i < nums.length; i++) {
//            path.add(nums[i]);
//            backtracking(nums,i+1);
//            path.removeLast();
//        }
//    }
//}











/**
 * leetcode.93 复原ip地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */

//class Solution {
//    List<String> resList = new ArrayList<>();
//    List<String> path = new ArrayList<>();
//
//    public List<String> restoreIpAddresses(String s) {
//        //[剪枝操作:]合法的ip长度一定为4~12
//        if(s == null || s.length() < 4 || s.length() > 12) return resList;
//
//        backtracking(s,0);
//        return resList;
//    }
//
//    //回溯函数
//    private void backtracking(String s , int startPos) {
//        if(path.size() == 4) {//已经分了4段ip
//            //【剪枝操作】
//            if(startPos == s.length()) { //只有当恰好分成四段的时候，继续操作，其余直接return
//                String str = String.join(".",path);
//                resList.add(str);
//                return;
//            }
//        }
//
//        for(int i = startPos; i < s.length(); i++){
//            //【剪枝操作】每个地址段的最大长度为3，超过3的直接剪枝
//            if(i - startPos >= 3) return;
//
//            //substring左闭右开
//            String str = s.substring(startPos,i + 1);
//            if(isValidIp(str)) {
//                path.add(str);
//                backtracking(s,i + 1);
//                path.removeLast();
//            }
//        }
//    }
//
//    //验证合法性
//    private boolean isValidIp(String str) {
//        //去除前导0(不存在01这样的地址段)
//        if(str.length() > 1 && str.charAt(0) == '0') return false;
//        int value = Integer.parseInt(str);
//        return 0 <= value && value <= 255;
//    }
//}

//class Solution {
//    List<String> resList;
//    List<String> path;
//    public List<String> restoreIpAddresses(String s) {
//        //剪枝操作，ip最小长度1.1.1.1,最大长度255.255.255.255
//        if(s == null || s.length() < 4 ||s.length() > 12) return new ArrayList<>();
//
//        resList = new ArrayList<>();
//        path = new ArrayList<>();
//
//        backtracking(s,0);
//        return resList;
//    }
//    private void backtracking(String s, int startPos){
//        if(path.size() == 4) {//分割成四段
//            //此时正好分完,说明为合法数组
//            if(startPos == s.length()) {
//                resList.add(String.join(".",path));
//                //写这么多毛用没用，Java自带拼接的Api
////                StringBuilder sb = new StringBuilder();
////                for(int i = 0; i < path.size(); i++) {//有一说一，用path.size会慢，但是健壮性强
////                    sb.append(path.get(i));
////                    if(i != path.size()-1) sb.append(".");
////                }
////                list.add(sb.toString());
//                return;
//            }
//        }
//
//        for(int i = startPos; i < s.length(); i++){
//            // 【极致剪枝】：一个合法的 IP 段最多只有 3 位数字，切多了直接跳出循环
//            if (i - startPos + 1 > 3) break;
//
//            //substring左开右闭!
//            String str = s.substring(startPos,i + 1);
//            if(isValidIp(str)) {
//                path.add(str);
//                backtracking(s,i+1);
//                path.removeLast();
//            }
//        }
//    }
//    //判断是否为合法的ip地址
//    private boolean isValidIp(String str){
//        //规避前导0(不存在01这样的地址段)
//        if(str.length() > 1 && str.charAt(0) == '0') return false;
//        int value = Integer.parseInt(str);
//        return 0 <= value && value <= 255;
//    }
//}








/**
 * leetcode-131 分割回文字符串（回溯算法-分割）
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */

//class Solution {
//    List<List<String>> resList;
//    List<String> cur;
//    public List<List<String>> partition(String s) {
//        if(s == null) return new ArrayList<>();
//        resList = new ArrayList<>();
//        cur = new ArrayList<>();
//
//        backtracking(s,0,new StringBuilder());
//        return resList;
//    }
//
//    private void backtracking(String s,int startPos,StringBuilder sb) {
//        if(startPos == s.length()) {
//            resList.add(new ArrayList<>(cur));
//            return;
//        }
//        for(int i = startPos; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//            if(checkEcho(sb)) {//如果拼接后的sb是 回文字符串
//                cur.add(sb.toString());
//                backtracking(s,i+1,new StringBuilder());
//                cur.removeLast();
//            }
//        }
//    }
//
//    private boolean checkEcho(StringBuilder s) {
//        if(s == null) return true;
//        for(int i = 0; i < s.length()/2; i++) {
//            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
//        }
//        return true;
//    }
//}




/**
 * leetcode-40:组合总数二
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */

//class Solution {
//    List<List<Integer>> restList;
//    List<Integer> path;
//    int sum = 0;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        if(candidates == null || candidates.length == 0) return new ArrayList<>();
//
//        restList = new ArrayList<>();
//        path = new ArrayList<>();
//        Arrays.sort(candidates);//对数组进行排序
//        backtracking(candidates,target,0);
//        return restList;
//
//    }
//    private void backtracking(int[] candidates,int target,int startPos){
//        if(sum == target){
//            restList.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i = startPos; i < candidates.length; i++) {
//            //基础剪枝,因为candidates已经有序，此时大于target，后续candidates必然也大于
//            if(sum + candidates[i] > target) break;
//            //需要对重复的树干进行拦截
//            if(i > startPos && candidates[i] == candidates[i-1]) {//当i > startPos时，可以看作树的横向遍历
//                continue;//必然和前面一组相同，跳出本次
//            }
//            path.add(candidates[i]);
//            sum += candidates[i];
//            backtracking(candidates,target,i+1);
//            sum -= path.getLast();
//            path.removeLast();
//        }
//    }
//}







/**
 * 回溯算法-组合之和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个
 */


//class Solution {
//    List<List<Integer>> resList;
//    List<Integer> path;
//    int sum = 0;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if(candidates == null || candidates.length == 0) return new ArrayList<>();
//        resList = new ArrayList<>();
//        path = new ArrayList<>();
//        backtracking(candidates,target,0);
//        return resList;
//    }
//
//    private void backtracking(int[] candidates,int target,int startPos) {
//        if(sum > target) return; //因为同一数组可以无限制选取，所以必须要加上判断
//        if(sum == target) {
//            resList.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i = startPos; i < candidates.length; i++) {
//            path.add(candidates[i]);
//            sum += candidates[i];
//            backtracking(candidates,target,i);//因为可以无限选取自身，所以不能是i+1，必须是i
//            sum -= path.getLast();
//            path.removeLast();
//        }
//    }
//}





/**
 * 回溯算法——17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
 */

//class Solution {
//    List<String> list;
//    StringBuilder sb;
//
//    public List<String> letterCombinations(String digits) {
//        list = new ArrayList<>();
//        sb = new StringBuilder();
//
//        if(digits == null || digits.isEmpty()) return list;
//
//        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
//        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//
//        backtracking(digits,numString,0);
//        return list;
//    }
//
//    private void backtracking(String digits,String[] numString,int index) {
//        if(index == digits.length()) {//如果遍历完digits，则add
//            list.add(sb.toString());
//            return;
//        }
//        //记录digits[index]对应的numString
//        String str = numString[digits.charAt(index) - '0'];
//
//        for(int i = 0; i < str.length(); i++) {
//            //处理元素
//            sb.append(str.charAt(i));
//            //递归
//            backtracking(digits,numString,index + 1);
//            //回溯处理
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//    }
//}


//class Solution {
//
//    List<String> list;
//    StringBuilder sb;
//    public List<String> letterCombinations(String digits) {
//        sb = new StringBuilder();
//        list = new ArrayList<>();
//
//        if(digits == null || digits.isEmpty()) return list;
//
//        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
//        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        backtracking(digits,numString,0);
//        return list;
//    }
//
//    private void backtracking(String digits,String[] numString, int index) {//index记录当前digits的元素下标
//        if(index == digits.length()) {
//            list.add(sb.toString());
//            return;
//        }
//        String str = numString[digits.charAt(index) - '0'];//记录digits[index]对应数字的string
//        for(int i = 0; i < str.length(); i++) {
//            //收集元素
//            sb.append(str.charAt(i));
//            //递归
//            backtracking(digits,numString,index + 1);
//            //回溯处理
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
//}






/**
 * 回溯算法——组合总和
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回
 */
//class Solution {
//    List<List<Integer>> restList;
//    List<Integer> path;
//    int sum = 0;
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        restList = new ArrayList<>();
//        path = new ArrayList<>();
//        backtracking(k,n,1);
//        return restList;
//    }
//
//    private void backtracking(int k, int n, int strat) {
//        if(sum == n && path.size() == k) {
//            restList.add(new ArrayList<>(path));
//        }
//
//        for(int i = strat; i <= 9; i++) {
//            path.add(i);
//            sum += i;
//            backtracking(k,n,i+1);
//            path.removeLast();
//            sum -= i;
//        }
//    }
//}



/**
 * 回溯算法——组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */

//class Solution {
//    List<List<Integer>> resList = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        backtracking(n,k,1);
//        return resList;
//    }
//    //回溯算法
//    private void backtracking(int n, int k,int start){
//        if(path.size() == k ){//符合长度的组合就放到resList中
//            resList.add(new ArrayList<>(path));//tips:不能直接上传
//        }
//        for(int i = start; i <= n; i++) {
//            path.add(i);
//            backtracking(n,k,i+1);
//            path.removeLast();
//        }
//    }
//}










/**
 * 二叉搜索树转为累加树
 * 原本值加上原本二叉搜索树中所有比该节点值大的节点值的总和
 */

//class Solution {
//    int sum ;
//    public TreeNode convertBST(TreeNode root) {
//        if(root == null) return null;
//
//        root.right = convertBST(root.right);
//        sum += root.val;
//        root.val = sum;
//        root.left = convertBST(root.left);
//
//        return root;
//    }
//}






/**
 * 有序数组合并为平衡二叉搜索树
 */
//class Solution {
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length == 0) return null;
//
//        TreeNode root = insert(nums,0,nums.length-1);
//        return root;
//    }
//
//    private TreeNode insert(int[] nums, int left, int right) {
//        if(left > right) return null;
//        int pos = (left + right) / 2;
//        //向左取值
//        TreeNode node = new TreeNode(nums[pos]);
//        node.left = insert(nums,left,pos - 1);
//        node.right = insert(nums,pos + 1, right);
//
//        return node;
//    }
//}










/**
 * 二叉搜索树的修剪
 */


//class Solution {
//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if(root == null) return null;
//
//        if(low <= root.val && root.val <= high) {//如果根节点在low~high的范围内说明正确
//            //遍历整棵树
//            root.left = trimBST(root.left,low,high);
//            root.right = trimBST(root.right,low,high);
//        } else if (root.val < low) {
//            root = root.right;
//            return trimBST(root,low,high);
//        } else {
//            root = root.left;
//            return trimBST(root,low,high);
//        }
//        return root;
//    }
//}




/**
 * leetcode450.二叉搜索树的删除
 */
//class Solution {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null) return root;
//
//        if(root.val == key) {//对当前节点删除
//            if(root.right == null) {
//                return root.left;
//            } else if (root.left == null) {
//                return root.right;
//            } else { //当左右子树均不为空时
//                TreeNode cur = root.right;
//                while(cur.left != null) {//采用右子树最左（小）节点，左子树最右节点同理
//                    cur = cur.left;
//                }
//                cur.left = root.left;//让左子树全划分到右子树最左节点的左子树
//                root = root.right;
//            }
//            return root;
//        }
//
//        //通过 left = ...; right = ...才能遍历整棵树
//        if(root.val < key) root.right = deleteNode(root.right,key);
//        if(root.val > key) root.left = deleteNode(root.left,key);
//
//        return root;
//    }
//}



/**
 * 二叉搜索树增加
 */
//class Solution {
//    public TreeNode insertIntoBST(TreeNode root,int val) {
//        if(root == null) return new TreeNode(val);
//
//        if(root.val < val) root.right = insertIntoBST(root.right,val);
//        else root.left = insertIntoBST(root.left,val);
//
//        return root;
//    }
//}

//class Solution {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root == null) return new TreeNode(val);
//        insert(root,val);
//        return root;
//    }
//    private void insert(TreeNode root,int val) {
//        if(root.val < val) {
//            if(root.right == null) {
//                root.right = new TreeNode(val);
//            } else {
//                insert(root.right,val);
//            }
//        } else if(root.val > val){
//            if(root.left == null) {
//                root.left = new TreeNode(val);
//            } else {
//                insert(root.left,val);
//            }
//        }
//    }
//}


/**
 * 二叉搜索树最近祖先
 */

//递归法
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        while (true) {
//            if (root.val > p.val && root.val > q.val) {
//                root = root.left;
//            } else if (root.val < p.val && root.val < q.val) {
//                root = root.right;
//            } else {
//                break;
//            }
//        }
//        return root;
//    }
//}


//递归法
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
//        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
//        return root;
//    }
//}


/**
 * 二叉树最近公共祖先
 * work!这题确实有点Hard
 */
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null || root == p || root == q) return root;//用来找到节点，或者说明找不到节点
//
//        //遍历了整个二叉树
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//
//        if(left == null && right == null) {//遍历空，无结果
//            return null;
//        } else if (left == null && right != null) {//说明节点一定在右子树里，进入到右子树中
//            return right;
//        } else if (right == null && left != null){//表示只有有
//            return left;
//        } else return root; //此时两个节点一定是存在于root的子树中
//    }
//}


/**
 * 二叉搜索树的众数
 */

////递归-空间复杂度为0(1)
//class Solution {
//    TreeNode pre;
//    int maxCount = 0;
//    int count;
//    List<Integer> list;
//    public int[] findMode(TreeNode root) {
//        if(root == null) return new int[0];
//        list = new ArrayList<>();
//        inOrder(root);
//
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
//    private void inOrder(TreeNode root) {
//        if(root == null) return;
//
//        inOrder(root.left);
//
//        if(pre == null || pre.val != root.val) {
//            count = 1 ;
//        } else {
//            count += 1;
//        }
//        //对list进行操作
//        if(count > maxCount) { //如果有比maxCount更大的count，则说明一定前面的maxCount不为真正的count
//            list.clear();
//            maxCount = count;
//            list.add(root.val);
//        } else if (count == maxCount) {
//            list.add(root.val);
//        }
//        pre = root;
//
//        inOrder(root.right);
//    }
//}




////暴力法
//class Solution {
//    Map<Integer,Integer> map;
//    public int[] findMode(TreeNode root) {
//        map = new HashMap<>();//Key-Value值:val-count
//        List<Integer> list = new ArrayList<>();
//
//        inOrder(root);
//
//        int max = 0;//记录出现最大的频率
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() > max) max = entry.getValue();
//
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() == max) {
//                list.add(entry.getKey());
//            }
//        }
//        int[] arr = new int[list.size()];
//        for(int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
//    //中序遍历记录count
//    private void inOrder(TreeNode root){
//        if(root == null) return;
//        inOrder(root.left);
//        map.put(root.val,map.getOrDefault(root.val,0) + 1);
//        inOrder(root.right);
//    }
//}


/**
 * 二叉搜索树的最小节点差
 */

//class Solution {
//    TreeNode pre;
//    int min = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        if(root == null) return 0;
//        getMin(root);
//        return min;
//    }
//
//    private void getMin(TreeNode root) {
//        if(root == null) return;
//        getMin(root.left);
//        if(pre != null) {
//            if(Math.abs(root.val - pre.val) < min) min = Math.abs(root.val - pre.val);
//        }
//        pre = root;
//        getMin(root.right);
//    }
//}





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
// */


/**
 * 二叉树所有左叶子之和
 */
//class Solution {
//    public int sumOfLeftLeaves(TreeNode root) {
//        int sum = 0;
//        //迭代必须借助队列
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                if(cur.left != null && cur.left.left == null && cur.left.right == null)
//                    sum += cur.left.val;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return sum;
//    }
//}

/**
 * 257.返回二叉树的左右路径
 */

//回溯法-通过传统的path进行记录
//class Solution {
//    List<String> ret = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<Integer> path = new ArrayList<>();
//        backTrack(root,path);
//        return ret;
//    }
//    private void backTrack(TreeNode root, List<Integer> path) {
//        if(root == null) return;
//        //先序遍历（注意这里是把val存入到path中）
//        path.add(root.val);
//        //如果为叶子节点
//        if(root.left == null && root.right == null) {
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0; i < path.size()-1; i++) {//把当前path中所有的val组成一个路径存入到ret中
//                sb.append(path.get(i));
//                sb.append("->");
//            }
//            //最后一个字符没有”->“
//            sb.append(path.get(path.size()-1));
//            ret.add(sb.toString());
//        }
//
//        if(root.left != null) {
//            backTrack(root.left,path);
//            path.remove(path.size()-1);
//        }
//        if(root.right != null) {
//            backTrack(root.right,path);
//            path.remove(path.size()-1);
//        }
//
//    }
//}



//回溯法——通过sb.length进行判断
//class Solution {
//    List<String> list = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        if(root == null) return list;
//        StringBuilder sb = new StringBuilder();
//        backTrack(root,sb);
//        return list;
//    }
//
//    private void backTrack(TreeNode root, StringBuilder sb) {
//        //终止条件
//        if(root == null) return;
//        //记录当前sb长度
//        int len = sb.length();
//        if(len > 0) sb.append("->");//sb非空
//        sb.append(root.val);
//        //如果为叶子节点
//        if(root.left == null && root.right == null) {
//            list.add(sb.toString());
//        }else{
//            backTrack(root.left,sb);
//            backTrack(root.right,sb);
//        }
//        //回溯
//        sb.setLength(len);
//    }
//}


//递归法
//class Solution {
//    List<String> list = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        func(root,"");
//        return list;
//    }
//    private void func(TreeNode root,String str) {
//        //如果root 为空则终止
//        if(root == null) return;
//        //若为叶子节点，则直接结束此本递归，并将其add到list中
//        if(root.left == null && root.right == null) {
//            StringBuilder sb = new StringBuilder(str);
//            list.add(sb.append(root.val).toString());
//            return;
//        }
//        //路径中间值
//        StringBuilder sb = new StringBuilder(str);
//        sb.append(root.val);
//        sb.append("->");
//        func(root.left,sb.toString());
//        func(root.right,sb.toString());
//    }
//}




//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        //防空处理
//        if(root == null) return new ArrayList<>();
//        //借助队列遍历
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        List<List<Integer>> retList =  new ArrayList<>();
//
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            //每次遍历新的一行
//            int size = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for(int i = 0; i < size; i++){
//                TreeNode cur = queue.poll();
//                list.add(cur.val);
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//            retList.add(list);
//        }
//        return retList;
//    }
//}


/**
 * 110.平衡二叉树
 */
//用递归的方式根本无序后序遍历，因为递归本身就是从底向上返回
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        return getDeep(root) != -1;
//    }
//
//    private int getDeep(TreeNode root) {
//        if(root == null) return 0;
//        int leftDeep = getDeep(root.left);
//        if(leftDeep == -1) return -1;
//
//        int rightDeep = getDeep(root.right);
//        if(rightDeep == -1) return -1;
//
//        //如果左右子树高度之差>1，则说明不为二叉平衡树
//        if(Math.abs(leftDeep - rightDeep) > 1) return -1;
//
//        //如果执行到这里，说明left和right均为平衡树
//        return Math.max(leftDeep ,rightDeep) + 1;
//    }
//}






/**
 * 572.判断是否为另一个树的子树
 */

//class Solution {
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        if(root == null && subRoot == null) return true;
//        if((root == null && subRoot != null )|| (root != null &&  subRoot == null)) return false;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++){
//                TreeNode cur = queue.poll();
//                if(compare(cur,subRoot))//如果相等
//                    return true;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return false;
//    }
//    private boolean compare(TreeNode left, TreeNode right){
//        if(left == null && right == null) return true;//当左右均空时返回true
//        if(left == null || right == null || left.val != right.val) return false;
//        //此时左右非空且值相等
//        boolean leftSide = compare(left.left,right.left);//比较左侧
//        boolean rightSide = compare(left.right,right.right);//比较右侧
//        return leftSide && rightSide;
//    }
//}


/**
 * 100.判断两棵树是否相同
 *
 */
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        //本题可以直接把p,q视为统一树的左右子树
//        return compare(p,q);
//    }
//
//    private boolean compare(TreeNode left, TreeNode right){
//        if(left == null && right == null) return true;//当左右均空时返回true
//        if(left == null || right == null || left.val != right.val) return false;
//        //此时左右非空且值相等
//        boolean leftSide = compare(left.left,right.left);//比较左侧
//        boolean rightSide = compare(left.right,right.right);//比较右侧
//        return leftSide && rightSide;
//    }
//}


/**
 * 101.对称二叉树
 */

//递归法
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        return compare(root.left,root.right);
//    }
//
//    private boolean compare(TreeNode left, TreeNode right){
//        if(left == null && right == null) return true;//当左右均空时返回true
//        if(left == null || right == null || left.val != right.val) return false;
//        //此时左右非空且值相等
//        boolean inSide = compare(left.right,right.left);//比较内测
//        boolean outSide = compare(left.left,right.right);//比较外侧
//        return inSide && outSide;
//    }
//}


/**
 * 111.二叉树最小深度(tips:这里最小深度值得是左右子树均为null的节点)
 */

//递归法:
//class Solution {
//    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//        int leftDeep = minDepth(root.left);
//        int rightDeep = minDepth(root.right);
//
//        //如果左子树为空，返回右子树的minDeep
//        if(root.left == null)   return rightDeep + 1;
//        //如果右子树为空，返回左子树的minDeep
//        if(root.right == null)  return leftDeep + 1;
//
//        //此时一定是左右子树结尾非空
//        return Math.min(leftDeep,rightDeep) + 1;
//    }
//}

//层序迭代法:
//class Solution {
//    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//
//        int minDeep = Integer.MAX_VALUE;int deep = 0;
//        //依旧队列起手
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            deep++;
//            int size = queue.size();//记录每一层的节点数
//            for(int i = 0; i < size; i++){//遍历每一层
//                TreeNode cur = queue.poll();
//                //如果左右均为空
//                if (cur.left == null && cur.right == null) minDeep = Math.min(minDeep, deep);
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//
//            }
//        }
//        return minDeep;
//    }
//}


/**
 * 104.二叉树的最大深度
 *
 */
//class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        node1.left = node2;
//        node1.right = node3;
//        solution.maxDepth(node1);
//        return;
//    }
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//
//        int deep = 0;
//        //依旧队列起手，层序遍历
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            deep++;//每进入新的一层，先++层数
//            int size = queue.size();
//            for(int i = 0; i < size; i++){//遍历每一层的所有节点
//                TreeNode cur = queue.poll();
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return deep;
//    }
//}





/**
 *116.填充每个节点的下一个右侧节点
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, Node _left, Node _right, Node _next) {
 *         val = _val;
 *         left = _left;
 *         right = _right;
 *         next = _next;
 *     }
 * };
 */

/**
 * 验证是否为二叉搜索树
 */
//class Solution {
//    public boolean isValidBST(TreeNode root) {
//        if(root == null) return true;
//        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//    private boolean isBST(TreeNode root,long min, long max) {
//        if(root == null) return true;
//        if(root.val <= min || root.val >= max) return false;
//        return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
//    }
//}



/**
 * 二叉搜索树
 */
//class Solution {
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root == null) return null;
//        if(root.val == val) {
//            return root;
//        } else if(root.val > val) {
//             return searchBST(root.left,val);
//
//        } else {
//            return searchBST(root.right,val);
//        }
//    }
//}


/**
 * 合并两个二叉树
 */
//class Solution {
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if(root1 == null) return root2;
//        if(root2 == null) return root1;
//        TreeNode root = new TreeNode(root1.val + root2.val);
//        root.left = mergeTrees(root1.left,root2.left);
//        root.right = mergeTrees(root1.right,root2.right);
//        return root;
//    }
//}



/**
 * 654. 最大二叉树
 */
//class Solution {
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if(nums.length == 0) return null;
//        return findMaxNode(nums,0,nums.length);
//    }
//    private TreeNode findMaxNode(int[] nums,int left, int right) {
//        //依旧左开右闭
//        if(left >= right) return null;
//        int max = nums[left];
//        int pos = left;
//        for(int i = left; i < right; i ++) {
//            if(nums[i] > max) {//记录left - right的最大值及其下标pos
//                max = nums[i];
//                pos = i;
//            }
//        }
//        TreeNode root = new TreeNode(max);
//        root.left = findMaxNode(nums,left,pos);
//        root.right = findMaxNode(nums,pos + 1, right);
//        return root;
//    }
//}



/**
 * 112.路径之和
 */

//回溯（无path记录）
//class Solution {
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root == null) return false;
//        targetSum -= root.val;
//        if(root.left == null && root.right == null) {
//            if(targetSum == 0) return true;
//        } else {
//            if(hasPathSum(root.left,targetSum)) return true;
//            if(hasPathSum(root.right,targetSum)) return true;
//        }
//        targetSum += root.val;
//        return  false;
//    }
//}



//回溯算法
//class Solution {
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        List<Integer> path = new ArrayList<>();//借助path实现回溯
//        if(root == null && targetSum != 0) return false;
//        return backTrack(root,path,targetSum);
//    }
//    private boolean backTrack(TreeNode root,List<Integer> path,int targetSum) {
//        if(root == null) return false;
//        path.add(root.val);
//        if(root.left == null && root.right == null) { //如果为叶子节点，则计算
//            int sum = 0;
//            for(int i : path) sum += i;
//            if(sum == targetSum) return true;
//        } else {
//            //如果执行左子树有成功的，直接return true;
//            if(backTrack(root.left,path,targetSum)) return true;
//            if(backTrack(root.right,path,targetSum)) return true;
//        }
//        path.remove(path.size()-1);
//        return false;
//    }
//}

/**
 *leetcode105.根据前序遍历&后续遍历构造二叉树
 */
//class Solution {
//    Map<Integer,Integer> map;//构建inorder的value-index map
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length == 0 || inorder.length == 0) return null;
//        map = new HashMap<>();
//        for(int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i],i);
//        }
//        return findNode(inorder,0,inorder.length,preorder,0,preorder.length);
//    }
//    private TreeNode findNode(int[] inorder, int inBegin,int inEnd,int[] preorder,int preBegin,int preEnd) {
//        //左开右闭，如果不符合定义return null
//        if(inBegin >= inEnd || preBegin >= preEnd) return null;
//
//        int rootValue = preorder[preBegin];//记录当前root值
//        int rootIndex = map.get(rootValue);//root在inorder的index
//        TreeNode root = new TreeNode(rootValue);
//        //划分子树大小
//        int leftSize = rootIndex - inBegin;
//        root.left = findNode(inorder,inBegin,rootIndex,
//                preorder,preBegin+1,preBegin + leftSize + 1);
//        root.right = findNode(inorder,rootIndex + 1, inEnd,
//                preorder,preBegin + leftSize + 1, preEnd);
//        return root;
//    }
//}


/**
 * 106.根据中序 & 后序 构造二叉树
 */
//class Solution {
//    Map<Integer,Integer> map;
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if(inorder.length == 0 || postorder.length == 0) return null;
//        //HashMap存储inOrder
//        map = new HashMap<>();//K-V值:value-index
//        //存入键对值
//        for(int i = 0; i < inorder.length; i++){
//            map.put(inorder[i],i);
//        }
//        //采用左闭右开
//        return findNode(inorder,0,inorder.length,postorder,0,postorder.length);
//    }
//    //根据区间来确定树的结构,若inorder不符合区间结构，则return null
//    private TreeNode findNode(int[] inorder,int inBegin,int inEnd,int[] postorder,int postBegin,int postEnd) {
//        if(inBegin >= inEnd || postBegin >= postEnd) {//只要不符合区间大小，就return null
//            return null;
//        }
//        //记录当前根节点信息
//        int rootValue = postorder[postEnd-1];
//        TreeNode root = new TreeNode(rootValue);
//        int rootIndex = map.get(rootValue);
//
//        //必须对postorder进行分块，记录左子树的元素个数
//        int leftSize = rootIndex - inBegin;
//        root.left = findNode(inorder,inBegin,rootIndex,
//                postorder,postBegin,postBegin + leftSize);
//        root.right = findNode(inorder,rootIndex+1,inEnd,
//                postorder,postBegin + leftSize,postEnd-1);
//        return root;
//    }
//}




/**
 * 返回二叉树最底层的最左节点值
 */

////回溯法
//class Solution {
//    int maxDeep = -1;//用于记录最大深度
//    int val = 0;
//    public int findBottomLeftValue(TreeNode root) {
//        if(root == null) return 0;
//        val = root.val;//这一步一定要写，如果只有root，返回root.val
//        findLeftValue(root,0);
//        return val;
//    }
//    private void findLeftValue(TreeNode root,int deep){
//        if(root == null) return;
//        if(deep > maxDeep) { //如果当前的deep值 > maxDeep，说明不为最底层
//            maxDeep = deep;
//            val = root.val;
//        }
//        findLeftValue(root.left,deep+1);
//        findLeftValue(root.right,deep+1);
//    }
//}

//同样是迭代法:
//class Solution {
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        int res = 0;
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                //记录每层的第一个节点val,结束层序遍历时 此时res的val就是最后一层最左节点的val
//                if(i == 0) res = cur.val;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//
//        }
//        return res;
//    }
//}

//愚蠢的写法
//class Solution {
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        int deep = 0;
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//            deep++;
//        }
//        queue.offer(root);
//        while(--deep != 0) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return queue.poll().val;
//    }
//}


/**
 * 完全二叉树节点个数
 */

//class Solution {
//    public int countNodes(TreeNode root) {
//        if(root == null) return 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        int count = 0;
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                count++;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return count;
//    }
//}


//class Solution {
//    public Node connect(Node root) {
//        if(root == null) return new Node();
//
//        //依旧借助队列实现层序遍历，ArrayDeque真神了
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();//依旧记录当前层数的节点数
//            for(int i = 0; i < size; i++){
//                Node cur = queue.poll();
//                if(i != size-1) {//当不为层数的最后一位时
//                    cur.next = queue.peek();
//                }
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return root;
//    }
//}




/**
 * 515.二叉树行的最大值
 */
//class Solution {
//    public List<Integer> largestValues(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//
//        List<Integer> list = new ArrayList<>();
//        //借助队列来实现层序遍历
//        Queue<TreeNode> queue = new ArrayDeque<>();
//
//        queue.offer(root);
//        while (!queue.isEmpty()){//当队内为空，遍历结束
//            int size = queue.size();//记录当前层的节点数
//            int max = Integer.MIN_VALUE;//每层开始重置Max值
//
//            for(int i = 0; i < size; i++){//开始遍历当前这层元素
//                TreeNode cur = queue.poll();
//                if(cur.val > max) max = cur.val;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//            list.add(max);
//        }
//        return list;
//    }
//}



/**
 * 429.N叉树的层序遍历
 */

//class Solution {
//    public List<List<Integer>> levelOrder(Node root) {
//        if(root == null) return new ArrayList<>();
//        List<List<Integer>> retList = new ArrayList<>();
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();//记录每一层的节点个数
//            List<Integer> list = new ArrayList<>();//实例化list存储一层的节点值
//            for(int i = 0; i < size; i++){//遍历当前层的所有节点
//                Node cur = queue.poll();
//                list.add(cur.val);
//                for(Node child : cur.children){
//                    if(child != null) queue.offer(child);
//                }
//            }
//            retList.add(list);
//        }
//        return retList;
//    }
//}



/**
 * 637.二叉树每层的平均值
 */
//class Solution {
//    public List<Double> averageOfLevels(TreeNode root) {
//        //依旧递归，java中难以利用全局变量（指针）进行操作
//        if(root == null) return new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        List<Double> list = new ArrayList<>();
//        queue.offer(root);//root先入栈，保证了队列非空，也保证了先poll在对poll元素操作的特性
//        while (!queue.isEmpty()) {
//            int size = queue.size();//记录当前层节点数
//            double sum = 0;//初始化double;
//            for(int i = 0; i < size; i++){
//                TreeNode cur = queue.poll();
//                sum += cur.val;
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//            }
//            list.add(sum / size);
//        }
//        return list;
//    }
//}





/**
 * 二叉树右视图
 */
//迭代写法:
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        //采用迭代的方式
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        List<Integer> list = new ArrayList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {//当队列非空，执行循环
//            int size = queue.size();//记录当前队列的size
//            for (int i = 0; i < size; i++) {//站内入栈
//                TreeNode cur = queue.poll();//要记住，永远是对poll()出来的元素进行操作，且不要直接使用cur
//                if (i == size - 1) list.add(cur.val);//对于特殊值，永远是循环内置判断
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
//        }
//        return list;
//    }
//}


//class Solution {
//    Map<Integer,Integer> map = new HashMap<>();//Key-Value值为deep-num
//    int deep = 0;
//    public List<Integer> rightSideView(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        levelOrder(root,deep);
//        for(int i = 0; i < deep; i++) {
//            list.add(map.get(i));
//        }
//        return list;
//    }
//
//    private void levelOrder(TreeNode root,int deep){
//        if(root == null) return;
//        deep++;
//        map.put(deep,root.val);
//        if(root.left != null) levelOrder(root.left,deep);
//        if(root.right != null) levelOrder(root.right,deep);
//    }
//}







/**
 * 二叉树层序遍历
 */
////迭代实现——借助队列
//规范写法
//class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//        List<List<Integer>> retList = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int size = queue.size();//先记录当前层有多少元素
//            List<Integer> list = new ArrayList<>();//每层新建一个list
//            for(int i = 0; i < size; i++){
//                //1.对队列进行操作，永远是对poll出来的元素进行操作，千万不要直接对着栈顶元素进行操作
//                TreeNode cur = queue.poll();//用cur而非root，不然污染变量名
//                list.add(cur.val);
//                if(cur.left != null) queue.offer(cur.left);
//                if(cur.right != null) queue.offer(cur.right);
//                //因为依旧poll完了，所以无需再poll了
//            }
//            retList.add(list);
//        }
//        return retList;
//    }
//}


//这一部分写的十分混乱不堪！完全不规范❌
//class Solution{
//
//    public List<List<Integer>> levelOrder(TreeNode root){
//        if(root == null) return new ArrayList<>();
//        List<List<Integer>> retList = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){//如果队列为空，结束
//            List<Integer> list = new ArrayList<>();
//            int n = queue.size();//需要保存当前栈的大小
//            for(int i = 0 ; i < n;i++){//把当前队列的所有自节点全部入栈
//                if(root.left != null) queue.offer(root.left);
//                if(root.right != null) queue.offer(root.right);
//                list.add(queue.remove().val);//element() == peek(),remove() == poll();
//                root = queue.peek();//root需要变为队首元素
//            }
//            retList.add(list);
//        }
//        //二叉树从底向上层序遍历
//        //Collections.reverse(retList);
//        return retList;
//    }
//
//}


//递归实现
//class Solution{
//    List<List<Integer>> retList = new ArrayList<>();;//声明retList对象
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        levelFunc(root,0);//deep值默认为0，每进入一层deep + 1
//        return retList;
//    }
//    private void levelFunc(TreeNode root,int deep){
//        if(root == null) return;;
//        deep++;//每次进入新的一层时，deep+1(可以根据传入的参数deep来严格控制每层层数)
//        if(retList.size() < deep){//如果当前层数还没开辟list来存放元素，则开辟
//            List<Integer> list = new ArrayList<>();
//            retList.add(list);
//        }
//        retList.get(deep - 1).add(root.val);//deep-1表示所在层数下标
//        //此时deep已经+1,进入的子树一定是当前deep的下一层
//        levelFunc(root.left,deep);
//        levelFunc(root.right,deep);
//
//    }
//}


/**
 * 二叉树递归遍历
 */
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preOrder(root,list);
//        return list;
//    }
//
//    public void preOrder(TreeNode root,List<Integer> list){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        preOrder(root.left,list);
//        preOrder(root.right,list);
//    }
//}




/**
 * 347.前K个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */

////做前猜想:和上一题应该不同，上一题需要存储下标位置来判断生命周期;
//// 本体需要记录元素出现频率，出现频率应该是Map而不是Set(是否存在过)
//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();//Key-Value值为元素-次数
//        //优先级队列，并且通过Lambda表达式修  改为大根堆
//        //这里也可以用int[] 来从当pq元素
//        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1,e2)-> e1.getValue() - e2.getValue());
//        for(int i : nums){//先通过遍历,将每个元素的出现次数put到map中
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        for(var i : map.entrySet()){//注:var是JDK10引入的局部变量解析，会自动识别数据类型（Map.Entry<Integer, Integer>）
//            pq.offer(i);//将一整行数据项(map.entry)塞入队列中
//            if(pq.size() > k){//大根堆，前K个即为最高频率的k个元素
//                pq.poll();
//            }
//        }
//        //此时pq只保留了最高频率的k个元素
//        int[] ret = new int[k];
//        for(int i = 0; i < k; i++){
//            ret[i] = pq.remove().getKey();
//        }
//        return ret;
//    }
//}
//

/**
 * 239.滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */

//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums == null || nums.length == 0) return new int[0];
//        int[] ret = new int[nums.length - k + 1];
//        int index = 0;//用于记录ret的位置
//        //利用双端队列实现单调队列
//        //tips:队列存储的是下标元素
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        //这个世界从不记得谁活最久，只记得每个窗口滑过时，最前面那个杀红了眼的人
//        for(int i  = 0; i < nums.length; i++){
//            //1.淘汰永远当不了最大值的dinner
//            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){//牢记deque中存储的全是下标值i
//                deque.removeLast();
//            }
//            //2.新王登基，比我弱的和一样的都杀完了，剩下的只有比我强的
//            deque.add(i);//记录坐标
//
//            //3.你只不过是生在没有我的时代罢了，史上最强 VS 现代最强
//            if(deque.element() < i + 1 - k){//历代最强只能活到 滑动窗口的左边界，即 i - k
//                deque.removeFirst();
//            }
//
//            if(i >= k - 1){
//                ret[index++] = nums[deque.element()];//牢记deque中存储的全是下标值i
//            }
//        }
//        return ret;
//    }
//}


//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] ret = new int[nums.length - k + 1];
//        int index = 0;//用来记录ret的位置
//        //本质:利用双端队列实现单调栈
//        Deque<Integer> deque = new ArrayDeque<>();//双端队列
//
//        for (int i = 0; i < nums.length; i++){
//            while(deque.isEmpty() || nums[i] > deque.peekFirst()){//如果栈为空或者新元素比栈首元素还要大，则头插
//                deque.addFirst(nums[i]);
//            }
//            while(!deque.isEmpty() && nums[i] > deque.peekLast()){//如果只大于尾部元素，淘汰尾部元素
//                deque.removeLast();
//                deque.addLast(nums[i]);
//            }
//
            //错误❌
            //怎么可能直接出掉最大值啊，你个傻逼，你写滑动窗口给我写好的啊我chovy，顶部的最大值还可能是后续的最大值呢？
            //顶部元素的生命周期单独记录
//            if(i >= k-1){//从pos = k-1开始，每次出栈顶元素
//                ret[index++] = deque.pop();
//            }
//        }
//        return ret;
//    }
//}


/**
 * 150. 逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 有效的算符为 '+'、'-'、'*' 和 '/'
 */

//class Solution {
//    public int evalRPN(String[] tokens) {
//        //Stack效率极低，可以用Deque实现栈的功能
//        // Stack<String> stack = new Stack<>();
//        Deque<Integer> stack = new ArrayDeque<>();//ArrayDeque更强更快！
//
//        for(String str : tokens){//遍历tokens数组
//            if(str.equals("+")){
//                int right = stack.pop();
//                int left = stack.pop();
//                stack.push(left+right);
//            } else if (str.equals("-")) {
//                int right = stack.pop();
//                int left = stack.pop();
//                stack.push(left-right);
//            } else if (str.equals("*")) {
//                int right = stack.pop();
//                int left = stack.pop();
//                stack.push(left*right);
//            } else if (str.equals("/")) {
//                int right = stack.pop();
//                int left = stack.pop();
//                stack.push(left/right);
//            } else {
//                stack.push(Integer.valueOf(str));
//            }
//        }
//        return stack.pop();
//    }
//}


/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 s 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一
 */


//class Solution {
//    public String removeDuplicates(String s) {
//        //StringBuilder天然的尾插特性，使得其可以充当栈来使用
//        StringBuilder sb = new StringBuilder();
//        char[] ch = s.toCharArray();
//        for(int i = 0; i < s.length(); i++){
//            if(sb.isEmpty() || sb.charAt(sb.length()-1) != ch[i]){
//                sb.append(ch[i]);
//            }else{
//                sb.deleteCharAt(sb.length()-1);
//            }
//        }
//        return sb.toString();
//    }
//}


//class Solution {
//    public String removeDuplicates(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] ch = s.toCharArray();
//        for(int i = 0; i < ch.length; i++){
//            if(stack.isEmpty() || ch[i] != stack.peek()){
//                stack.push(ch[i]);
//            }else if(ch[i] == stack.peek()){
//                stack.pop();
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while(!stack.isEmpty()){
//            sb.append(stack.pop());
//        }
//        sb.reverse();
//        return sb.toString();
//    }
//}







/**
 * LeetCode.20.有效括号
 */

//class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] ch = s.toCharArray();
//        for(int i = 0; i < ch.length; i++){
//            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '['){//如果是左括号，入栈
//                stack.add(ch[i]);
//            }else{//如果为右括号
//                if(stack.isEmpty()) return false;//如果此时站内无元素，匹配失败
//                if(ch[i] == ')'){
//                    if(stack.peek() == '(') stack.pop();
//                    else return false;
//                }else if(ch[i] == '}'){
//                    if(stack.peek() == '{') stack.pop();
//                    else return false;
//                }else{
//                    if(ch[i] == ']'){
//                        if(stack.peek() == '[') stack.pop();
//                        else return false;
//                    }
//                }
//            }
//        }
//
//        return stack.isEmpty();
//    }
//}

//class Solution{
//    /**
//     * 不使用Java内置方法实现
//     * <p>
//     * 1.去除首尾以及中间多余空格
//     * 2.反转整个字符串
//     * 3.反转各个单词
//     */
//    public String reverseWords(String s){
//        //1.去除多余空格
//        StringBuilder sb = removeSpace(s);
//        //2.逆置整个String
//        reverseString(sb,0,sb.length()-1);
//        //3.逆置单词
//        reverseEachWords(sb);
//        return sb.toString();
//    }
//
//    public StringBuilder removeSpace(String s){//去除多余空格
//        int start = 0; int end = s.length()-1;
//        char[] ch = s.toCharArray();
//        while(ch[start] == ' '){start++;}//去除首部空格
//        while(ch[end] == ' '){end--;}//去除尾部空格
//
//        StringBuilder sb = new StringBuilder();
//        while(start <= end){//去除重复的空格
//            if(ch[start] != ' ' || sb.charAt(sb.length()-1)!=' '){//只有当读取到' '且sb末尾已经为' '时才不会读取
//                sb.append(ch[start]);
//            }
//            start++;
//        }
//        return sb;
//    }
//
//    public void reverseString(StringBuilder sb, int start, int end){//逆置字符串
//        char temp;
//        while(start < end){
//            temp = sb.charAt(start);
//            sb.setCharAt(start,sb.charAt(end));
//            sb.setCharAt(end,temp);
//            start++;
//            end--;
//        }
//    }
//
//    private void reverseEachWords(StringBuilder sb){
//        int start = 0;int end = 1;
//        while(start < sb.length()){//外层循环
//            while(end < sb.length() && sb.charAt(end) != ' '){//找到end的位置
//                end++;
//            }//此时end == ' '
//            reverseString(sb,start,end-1);
//            start = end+1;
//            end = start+1;
//        }
//    }
//}

/**
 * LeetCode 151 反转字符串中的words
 * O(1)复杂度
 */
//class Solution{
//    /**
//     * 不使用Java内置方法实现
//     * <p>
//     * 1.去除首尾以及中间多余空格
//     * 2.反转整个字符串
//     * 3.反转各个单词
//     */
//    private StringBuilder removeSpace(String s){//去除多余空格的方法
//        int start = 0; int end = s.length()-1;
//        char[] ch = s.toCharArray();//将String转化为ch便于操作（省的写charAt了）
//        while(ch[start] == ' '){//去除首部' '
//            start++;
//        }
//        while(ch[end] ==' '){//去除尾部' '
//            end--;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        while(start < end){//去除单词间重复的空格
//            if(end <sb.length() && ch[start] != ' '){//如果sb最后一位为空格且下一位仍为空格
//               sb.append(ch[start]);
//            }
//            start++;
//        }
//        return sb;
//    }
//
//    public void reverseString(StringBuilder sb,int left, int right){//逆置字符串
//        char temp;
//        while(left < right){
//            temp = sb.charAt(left);
//            sb.setCharAt(left,sb.charAt(right));
//            sb.setCharAt(right,temp);
//            left++;right--;
//        }
//    }
//
//    private void reverseEachWords(StringBuilder sb){//反转每一个单词
//       int start = 0; int end = 1;
//        while(start < sb.length()){//外层循环
//            while(sb.charAt(end) == ' ' || end == sb.length()-1){//找到end所在位置
//                end++;
//            }
//            reverseString(sb,start,end-1);
//            start = end+1;
//            end = end+1;
//
//       }
//
//    }
//    public String reverseWords(String s){
//        //无内鬼，来点O(1)空间复杂度
//        //1.删除首尾空格
//        StringBuilder sb = removeSpace(s);//删除首尾' '
//        //2.逆置整个字符串
//        reverseString(sb,0,sb.length()-1);
//        //3.逆置单词
//        reverseEachWords(sb);
//        return sb.toString();
//    }
//}

    /**
    LeetCode.151
    反转字符串中的单词顺序
     */
//class Solution {
//    public String reverseWords(String s) {
//        //借助split()，非O(1)
//        String[] str = s.trim().split("\\s+");//分割字符
//        StringBuffer sb = new StringBuffer();
//        //String ret = new String();
//        for(int i = str.length -1; i > 0; i--){
//            sb.append(str[i]);
//            //性能杀手
//            //ret = ret + str[i]+" ";//Java当中String类型具有不可变性，使用+实际上是新建了一个String对象并进行赋值
//        }
//        if(!str[0].equals(" ")){
//            sb.append(str[0]);
//        }
//        return sb.toString();
//    }
//}
////class Solution {
//    public String reverseWords(String s) {
//        //char[] ch = s.toCharArray();
//        String sentence = "Java,Python,C++";
//        String[] languages = sentence.split(",");
//
//    }
//}



//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.sort(nums);//对nums进行排序
//        // a = nums[i], b = nums[left], c = nums[right]
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] > 0){//如果第一个元素的值>0,则后续不可能凑出三元组
//                return ret;
//            }
//            if(i > 0 && nums[i] == nums[i-1]){//当出现连续的字符时，需要去重
//                continue;
//            }
//            int left = i+1;
//            int right = nums.length-1;
//            while(left < right){//定一个，动两个
//                int sum = nums[i]+nums[left]+nums[right];
//                if(sum > 0){
//                    right--;//如果sum值过大，则需--
//                }
//                if(sum < 0){
//                    left++;
//                }
//                if(sum == 0){//如果符合条件，则同样需要去重
//                    ret.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                    while(left < right && nums[left] == nums[left-1]) left++;
//                    while(left < right && nums[right] == nums[right+1]) right--;
//                }
//            }
//        }
//        return ret;
//
//    }
//}

//import java.util.Map;
//import java.util.HashMap;
//
//class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        if(ransomNote.length() > magazine.length()){//如果所需字符串>给定字符串，直接return false;
//            return false;
//        }
//        char[] count = new char[26];//记录ransomNote所需的字符数
//        for(char c : ransomNote.toCharArray()){
//            count[c - 'a']++;
//        }
//
//        for(char c : magazine.toCharArray()){
//            count[c -'a']--;
//        }
//
//        for(int i : count){
//            if(i < 0){
//                return false;
//            }
//        }
//        return true;
//    }
//}

//import java.util.Map;
//import java.util.HashMap;
//
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        //始终记得防御性编程
//        if(nums == null || nums.length == 0){
//            return new int[0];
//        }
//        int[] ret = new int[2];
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length;i++){//存入数组值-数组下标到Map中
//            if(map.containsKey(target - nums[i])){//边存边查
//                ret[0] = map.get(nums[i]);
//                ret[1] = map.get(target-nums[i]);
//            }
//            map.put(nums[i],i);//如果没查到，则存入Map中
//        }
//
//        return ret;
//    }
//}
//
////import java.util.Set;
////import java.util.HashSet;
////
////class Solution {
////    public int getSum(int n){
////        int sum = 0;
////        while(n > 10){
////            sum += (n%10)*(n%10);
////            n = n/10;
////        }
////        sum += n*n;
////        return sum;
////    }
////    public boolean isHappy(int n) {
////        Set<Integer> set = new HashSet<>();//记录会出现的sum值
////        int sum = 0;
////        while(true){
////            sum = getSum(n);//计算当前n的sum值
////            if(sum == 1){
////                return true;
////            }
////            if(ret.contains(sum) == true){//如果出现的sum值已经在之前计算过，则说明发生了循环
////                return false;
////            }
////            n = sum;
////        }
////    }
////}