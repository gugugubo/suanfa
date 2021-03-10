package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5 
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/19 19:51
 * @Version 1.0
 **/
public class timu162 {


    /**
     * https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
     * 找规律，直接一次遍历就行
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i=0 ;i<nums.length -1; i++){
            if (nums[i] > nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }


    /**
     * 寻找左侧边界？
     * 
     * 链接：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
     * 二分法
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}
