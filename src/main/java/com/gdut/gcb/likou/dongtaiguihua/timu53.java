package com.gdut.gcb.likou.dongtaiguihua;

import java.util.HashMap;

/**
 * @Author  古春波
 * @Description 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/14 0:17
 * @Version 1.0
 **/
public class timu53 {

    public int maxSubArray(int[] nums) {
        // 以nums[i] 结尾的最大子数组和
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        for (int i=1 ;i< nums.length;i++){
            dp[i] = Math.max(nums[i] ,nums[i]+dp[i-1]);
        }
        int result =  Integer.MIN_VALUE;
        for (int i = 0 ; i< dp.length ; i++){
            if (dp[i] > result ){
                result  = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1);
        HashMap<Object, Object> map = new HashMap<>(2);
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
    }
    
}
