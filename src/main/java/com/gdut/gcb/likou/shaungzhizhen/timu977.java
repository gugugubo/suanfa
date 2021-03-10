package com.gdut.gcb.likou.shaungzhizhen;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 11:31
 * @Version 1.0
 **/
public class timu977 {


    /**参考方法二自己做的
     *         链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
     *         
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } 
            nums[i] = nums[i] * nums[i];
        }
        // 16,1,0,  9,10
        int[] ans = new int[n];
        int i = negative, index = 0, j = negative+1;
        while (i >= 0 || j < n) {
            
            int iVal = i>=0? nums[i] : Integer.MAX_VALUE;
            int jVal = j>=n? Integer.MAX_VALUE: nums[j];
            if (iVal> jVal){
                ans[index++] = jVal;
                j++;
            }else {
                ans[index++] = iVal;
                i--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        timu977 timu977 = new timu977();
        int[] ints = new int[]{-4,-1,0,3,10};
        int[] ints1 = timu977.sortedSquares(ints);
        System.out.println(Arrays.toString(ints1));
    }
}
