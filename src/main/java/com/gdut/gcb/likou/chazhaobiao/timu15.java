package com.gdut.gcb.likou.chazhaobiao;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author 古春波
 * @Description 15.  三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 22:38
 * @Version 1.0
 **/
public class timu15 {

    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> totalResult = new ArrayList<>();
        if (nums.length<=2){
            return totalResult;
        }
        Arrays.sort(nums);
        // 枚举第一个元素
        for (int i=0; i<nums.length;i++){
            int target = nums[i];
            List<List<Integer>> lists = twoSumTarget(nums, i+1, -target);
            for (List<Integer> list: lists){
                list.add(target);
                totalResult.add(list);
            }
            while (i<nums.length-1&&nums[i+1]==nums[i]){
                i++;
            }
        }
        return totalResult;
    }



    /* 从 nums[start] 开始，计算有序数组
     * nums 中所有和为 target 的二元组 */
    List<List<Integer>> twoSumTarget(int[]nums , int left , int target){
        int right = nums.length-1;
        List<List<Integer>> totalResult = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (left<right){
            int leftValue = nums[left], rightValue = nums[right];
            int sum = leftValue+rightValue;
            if (sum == target){
                result.add(nums[left]); 
                result.add( nums[right]);
                totalResult.add(new ArrayList<>(result));
                result.clear();
                while (left<right && nums[left] == leftValue){
                    left++;
                }
                while (left<right && nums[right] == rightValue){
                    right--;
                }
            }else if (sum < target){
                while (left<right && nums[left] == leftValue){
                    left++;
                }
            }else if(sum > target){
                while (left<right && nums[right] == rightValue){
                    right--;
                }
            }
        }
        return totalResult;
    }
    
    public boolean repeatedSubstringPattern(String s) {
        ArrayList<Character> list = new ArrayList();
        int k = 0;
        for(int i=0 ; i< s.length(); i++){
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
                k = i;
            }else{
                k = i;
                break;
            }
        }
        if(s.length() % k != 0){
            return false;
        }
        for(int i=k ; i<s.length(); i++){
            if(s.charAt(i) == list.get(i%k)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {

//        timu15 timu15 = new timu15();
//        timu15.repeatedSubstringPattern("abab");
//        int[] ints = new int[]{1,2,-2,-1};
//        List<List<Integer>> lists = timu15.threeSum(ints);
        String s1 = new String("hello");
        String intern1 = s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = new String("hello") + new String("hello");
        String intern3 = s3.intern();
        System.out.println(s3 == intern3);
        String s4 = "hellohello";
        System.out.println(s3 == s4);
    }
}