import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
LeetCode.151
反转字符串中的单词顺序
 */
class Solution {
    public String reverseWords(String s) {
        //借助split()，非O(1)
        String[] str = s.trim().split("\\s+");//分割字符
        StringBuffer sb = new StringBuffer();
        //String ret = new String();
        for(int i = str.length -1; i > 0; i--){
            sb.append(str[i]);
            //性能杀手
            //ret = ret + str[i]+" ";//Java当中String类型具有不可变性，使用+实际上是新建了一个String对象并进行赋值
        }
        if(!str[0].equals(" ")){
            sb.append(str[0]);
        }
        return sb.toString();
    }
}
//class Solution {
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