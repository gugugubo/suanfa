package com.gdut.gcb.likou.dongtaiguihua.tanxin;

/**
 * @Author 古春波
 * @Description 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/15 10:37
 * @Version 1.0
 **/
public class  timu45 {


    public int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int jump = 0;
        int end = 0;
        int fastest = 0;
        for(int i=0 ; i<nums.length; i++){
            // 这里可以在每次更新end的时候设置fastest为0，但是在每个区间中fastest是一定会至少比这个区间中的一个i + nums[i]要小，不然跳不出去 ，所以没必要
            fastest = Math.max(fastest, i + nums[i]);
            if (i==end){
                jump++;
                if (fastest >= nums.length-1){
                    return jump;
                }
                end = fastest;
            }
        }
        return jump;
    }

    /**
     * 使用动态规划的解法
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int length = nums.length;
        // nums 从 i 跳到结尾处最少需要dp[i]步
        int[] dp = new int[length];
        dp[length-1] = 0;
        for (int i=length-2;i>=0;i-- ){
            int min = dp[i+1];
            for (int j=i+1;j<=length-1 &&j<= i+nums[i];j++){
                min = Math.min(dp[j], min);
            }
            dp[i] = min + 1;
        }
        return dp[0];
    }
    
    
    
    public static void main(String[] args) {
        int[] jump = new int[]{1,1,2,1,2};
        int jump1 = new timu45().jump(jump);
        int jump2 = new timu45().jump2(jump);
        System.out.println(jump1);
        System.out.println(jump2);

    }

}
