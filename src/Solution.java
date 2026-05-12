import java.util.*;
//import java.util.Stack;//最垃圾的类，没有之一

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
 * 二叉树自底向上层序遍历
 */

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    }
}

/**
 * 二叉树层序遍历
 */
//迭代实现——借助队列
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