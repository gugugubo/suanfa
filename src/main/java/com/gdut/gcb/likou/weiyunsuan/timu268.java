package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *
 *
 * 进阶：
 *
 *     你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/20 10:38
 * @Version 1.0
 **/
public class timu268 {

    /**
     * 自己做的
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res =nums.length;
        for(int i=0; i<nums.length;i++){
            res = res ^ i^nums[i];
        }
        return res;
    }
}
