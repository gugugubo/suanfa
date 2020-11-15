package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/25 17:13
 * @Version 1.0
 **/
public class timu53_2 {


    public int missingNumber(int[] nums) {
        
        int ret = 0;
        for (int i = 0 ; i < nums.length ; i++){
            ret ^= i ^ nums[i];
        }
        return ret ^ nums.length;
    }
    
}
