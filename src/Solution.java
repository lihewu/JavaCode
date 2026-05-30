import java.util.*;
//import java.util.Stack;//最垃圾的类，没有之一


/**
 * 回溯算法——17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
 */

class Solution {

    List<String> list;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        sb = new StringBuilder();
        list = new ArrayList<>();

        if(digits == null || digits.isEmpty()) return list;

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits,numString,0);
        return list;
    }

    private void backtracking(String digits,String[] numString, int index) {//index记录当前digits的元素下标
        if(index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];//记录digits[index]对应数字的string
        for(int i = 0; i < str.length(); i++) {
            //收集元素
            sb.append(str.charAt(i));
            //递归
            backtracking(digits,numString,index + 1);
            //回溯处理
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}






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