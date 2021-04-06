package com.gdut.gcb.likou.huadongchuangkou;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author 古春波
 * @Description 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2 
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4. 
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4. 
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 来源：力 扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 17:36
 * @Version 1.0
 **/
public class timu1438 {

    /**
     *     链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/jue-dui-chai-bu-chao-guo-xian-zhi-de-zui-5bki/
     *     滑动窗口+单调队列（递增和递减）
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }


    public int longestSubarray2(int[] nums, int limit) {
        LinkedList<Integer> maxList = new LinkedList();
        LinkedList<Integer>  minList = new LinkedList();
        int maxLength =0;
        int right = 0;
        int left = 0;
        while(right< nums.length ){
            while(!maxList.isEmpty() && maxList.getLast() < nums[right]){
                maxList.removeLast();
            }
            while(!minList.isEmpty() && minList.getLast() > nums[right]){
                minList.removeLast();
            }
            minList.addLast(nums[right]);
            maxList.addLast(nums[right]);


            while(!maxList.isEmpty() && !minList.isEmpty()  && maxList.getFirst() - minList.getFirst() > limit){
                if(maxList.getFirst() == nums[left]){
                    maxList.removeFirst();
                }
                if(minList.getFirst() == nums[left]){
                    minList.removeFirst();
                }
                left++;
            }
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
            }
            right++;
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        timu1438 timu1438 = new timu1438();
        int[] ints = new int[]{8,2,4,7};
        timu1438.longestSubarray(ints,4);
        timu1438.longestSubarray2(ints,4);
    }
    
}
