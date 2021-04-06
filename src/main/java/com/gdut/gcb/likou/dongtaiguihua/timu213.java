package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/2 17:38
 * @Version 1.0
 **/
public class timu213 {


    
    public int rob(int[] nums) {
        // dp[i] 表示偷窃前i个房屋所能获取的最大价值
        int[] dp =  new int[nums.length];
        
        dp[0] = nums[0];
        
        for(int i=1; i<nums.length ; i++){
            
        }
        
        return dp[nums.length -1];
    }
    
}
