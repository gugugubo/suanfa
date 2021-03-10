package com.gdut.gcb.likou.chazhaobiao;

import java.util.HashSet;

/**
 * @Author 古春波
 * @Description 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 19:51
 * @Version 1.0
 **/
public class timu128 {


    /**https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
     * 哈希表
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        for (int num : nums){
            set.add(num);
        }
        int max = 1;
        for (int i=0; i<nums.length ; i++){
             // 只有前一个数不存在的才需要判断，这样可以避免重复判断
            if (set.contains(nums[i]-1)){
                continue;
            }
            int val = nums[i] + 1;
            int size = 1;
            while (set.contains(val)){
                size = size+1;
                val = val+1;
            }
            max = Math.max(max, size);
        }
        return max;
    }
    
    
}
