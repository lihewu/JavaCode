import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //始终记得防御性编程
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] ret = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){//存入数组值-数组下标到Map中
            if(map.containsKey(target - nums[i])){//边存边查
                ret[0] = map.get(nums[i]);
                ret[1] = map.get(target-nums[i]);
            }
            map.put(nums[i],i);//如果没查到，则存入Map中
        }

        return ret;
    }
}

//import java.util.Set;
//import java.util.HashSet;
//
//class Solution {
//    public int getSum(int n){
//        int sum = 0;
//        while(n > 10){
//            sum += (n%10)*(n%10);
//            n = n/10;
//        }
//        sum += n*n;
//        return sum;
//    }
//    public boolean isHappy(int n) {
//        Set<Integer> set = new HashSet<>();//记录会出现的sum值
//        int sum = 0;
//        while(true){
//            sum = getSum(n);//计算当前n的sum值
//            if(sum == 1){
//                return true;
//            }
//            if(ret.contains(sum) == true){//如果出现的sum值已经在之前计算过，则说明发生了循环
//                return false;
//            }
//            n = sum;
//        }
//    }
//}