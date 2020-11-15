package com.gdut.gcb.niuke.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * @Date 2020/10/9 10:20
 * @Version 1.0
 **/
public class timu42 {


    /**
     * 动态规划，
     */
    public int maxSubArray(int[] nums) {
        
        if (nums.length <= 0 ){
            return 0;
        }
        int[]  memo = new int[nums.length];
        Arrays.fill(memo, 0);
        memo[0] = nums[0];
        int result = memo[0];
        for (int i = 1 ; i < nums.length ; i++){
            int temp = memo[i - 1] <= 0 ? 0 : memo[ i -1];
            memo[i] = nums[i] + temp;
            result = memo[i] > result ? memo[i] : result;
            System.out.println(memo[i]);
            System.out.println(result);
        }
        return result;
    }

    /**
     * 动态规划，将空间复杂度降低到O(1)
     * 由于 memo[i]只与 memo[i−1] 和 nums[i]有关系，因此可以将原数组 nums用作 memo 列表，即直接在 nums上修改即可。
     *https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     */
    public int maxSubArray2(int[] nums) {

        if (nums.length <= 0 ){
            return 0;
        }
        int result = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            int temp = nums[i - 1] <= 0 ? 0 : nums[ i -1];
            nums[i] = nums[i] + temp;
            result = nums[i] > result ? nums[i] : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new timu42().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
