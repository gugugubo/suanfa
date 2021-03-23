package com.gdut.gcb.likou.shuxuejiqiao;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源： 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/27 15:51
 * @Version 1.0
 **/
public class timu31 {


    /**对比timu670,timu402 
     * 1 2 3
     *  1 3 2
     *  2 1 3
     *  2 3 1
     *  3 1 2
     *  3 2 1
     * 
     *
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     *
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0){
            if (nums[i] >= nums[i+1]){
                i--;
            }else {
                break;
            }
        }
        int left = i;
        if (i>=0){
            i=nums.length-1;
            while (i>0&&nums[i]<=nums[left]){
                i--;
            }
            int right = i;
            swap(nums, left , right);
        }
        res(nums, left);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }
    
    public void res(int[] nums , int left){
        int right = nums.length-1;
        left = left+1;
        while (left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        timu31 timu31 = new timu31();
        int[] ints = {1, 2, 3};
        timu31.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        
    }
}
