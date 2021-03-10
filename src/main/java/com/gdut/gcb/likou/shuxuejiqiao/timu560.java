package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/21 12:43
 * @Version 1.0
 **/
public class timu560 {


    /**题解参考：https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%89%8D%E7%BC%80%E5%92%8C%E6%8A%80%E5%B7%A7.html
     * 使用前缀和，不能使用滑动窗口，因为元素的值可能是负数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int res = 0;
        int totalSum = 0;
        // base case
        prefixMap.put(0, 1);
        for (int i=0; i<nums.length ; i++){
            totalSum +=nums[i];
            // 下面两行不能交换，因为是在前缀中找
            res += prefixMap.getOrDefault(totalSum-k,0);
            prefixMap.put(totalSum, prefixMap.getOrDefault(totalSum,0) + 1);
        }
        res += prefixMap.getOrDefault(totalSum-k,0);
        return res;
    }

    
    public static void main(String[] args) {
        int[] ints =  new int[]{1,1,1};
        timu560 timu560 = new timu560();
        timu560.subarraySum(ints, 2);
    }
}
