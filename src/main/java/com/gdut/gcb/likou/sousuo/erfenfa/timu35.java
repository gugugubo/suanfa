package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/28 11:24
 * @Version 1.0
 **/
public class timu35 {


    /**
     * 自己想的二分法
     * 使用搜索左侧边界的二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0 ; int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid+1;
            }
        }
        return left;
    }
    
    
}
