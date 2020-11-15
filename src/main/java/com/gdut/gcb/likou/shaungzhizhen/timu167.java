package com.gdut.gcb.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/8 23:29
 * @Version 1.0
 **/
public class timu167 {

    /**
     * 这题还有一个没排序的版本 timu1
     * 
     * 这里使用双指针完成，因为是排好序的
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        
        int i = 0 ; int j = numbers.length -1;
        
        while (i < j){
            if (numbers[i] + numbers[j] == target){
                return new int[]{i +1 , j + 1};
            }else if (numbers[i] + numbers[j] > target){
                j --;
            }else {
                i ++;
            }
            
        }
        
        return null;
        
    }
}
