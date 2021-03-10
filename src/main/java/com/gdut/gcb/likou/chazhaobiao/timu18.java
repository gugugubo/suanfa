package com.gdut.gcb.likou.chazhaobiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 古春波
 * @Description 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 23:42
 * @Version 1.0
 **/
public class timu18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> totalResult = new ArrayList<>();
        if (nums.length<3){
            return totalResult;
        }
        Arrays.sort(nums);
        // 枚举第一个元素
        for (int i=0; i<nums.length;i++){
            List<List<Integer>> lists = threeSum(nums,i+1, target - nums[i]);
            for (List<Integer> list: lists){
                list.add(nums[i]);
                totalResult.add(list);
            }
            while (i<nums.length-1&&nums[i+1]==nums[i]){
                i++;
            }
        }
        return totalResult;
    }

    
    
    
    
    public List<List<Integer>> threeSum(int[] nums, int start,  int target) {
        List<List<Integer>> totalResult = new ArrayList<>();
        if (nums.length<=2){
            return totalResult;
        }
        Arrays.sort(nums);
        // 枚举第一个元素
        for (int i=start; i<nums.length;i++){
            List<List<Integer>> lists = twoSumTarget(nums, i+1, target - nums[i]);
            for (List<Integer> list: lists){
                list.add(nums[i]);
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

    public static void main(String[] args) {
        int[] ints = new int[]{-2,-1,-1,1,1,2,2};
        new timu18().fourSum(ints, 0);
    }
}
