package com.gdut.gcb.likou.fenzhi;

/**
 * @Author 古春波
 * @Description 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/26 17:21
 * @Version 1.0
 **/
public class timu51 {

    public static void main(String[] args) {
        timu51 timu51 = new timu51();
        timu51.reversePairs(new int[]{7,5,6,4});
    }
    
    /**
     *思想是「分治算法」，所有的「逆序对」来源于 3 个部分：
     左边区间的逆序对；
     右边区间的逆序对；
     横跨两个区间的逆序对。
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] newNums = new int[nums.length];
        int[] temp = new int[nums.length];
        for (int i=0; i<nums.length ; i++){
            newNums[i] = nums[i];
        }
        int res = recur(nums, temp, 0, nums.length -1);
        return res;
    }

    private int recur(int[] nums, int[] temp, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) /2;
        
        int leftCount = recur(nums, temp, left , mid); 
        int rightCount = recur(nums, temp, mid+1, right);

        // 注意这里
        if (nums[mid] <= nums[mid+1]){
            return leftCount + rightCount;
        }
        int count = mergeAndCount(nums, left, mid, right, temp);
        
        return leftCount + count + rightCount;

    }


    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 注意这里
        for (int i=left; i<=right; i++){
            temp[i] = nums[i];
        }
        int i = left ; int j =mid+1;
        int count =0;
        for (int k=left; k<=right; k++){
            if (i==mid+1){
                nums[k] = temp[j++];
            }else if (j==right+1){
                nums[k] = temp[i++];
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i++];
            }else {
                // 注意这里
                nums[k] = temp[j++];
                count += mid - i +1;
            }
        }
        return count;
    }
    
}
