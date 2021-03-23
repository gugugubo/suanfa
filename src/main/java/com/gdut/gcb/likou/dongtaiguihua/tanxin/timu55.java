package com.gdut.gcb.likou.dongtaiguihua.tanxin;

/**
 * @Author 古春波
 * @Description 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/15 10:02
 * @Version 1.0
 **/
public class timu55 {

    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        int end = 0;
        int fastest = 0;
        for(int i=0 ; i<nums.length; i++){
            // 这里可以在每次更新end的时候设置fastest为0，但是在每个区间中fastest是一定会至少比这个区间中的一个i + nums[i]要小，不然跳不出去 ，所以没必要
            fastest = Math.max(fastest, i + nums[i]);
            if (i==end){
                if (fastest<=end){
                    return false;
                }
                if (fastest >= nums.length-1){
                    return true;
                }
                end = fastest;
            }
        }
        // [2,3,1,1,4]
        return true;
    }


    public static void main(String[] args) {
        timu55 timu55 = new timu55();
        timu55.canJump(new int[]{2,3,1,1,4});
    }
}
