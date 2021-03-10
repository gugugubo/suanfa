package com.gdut.gcb.likou.chazhaobiao;

/**
 * @Author 古春波
 * @Description 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 10:38
 * @Version 1.0
 **/
public class timu41 {


    /**
     * 原地哈希
     * 就把 1 这个数放到下标为 0 的位置， 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。
     * 然后我们再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数
     * 这个思想就相当于我们自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置
     * https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        
        for (int i=0; i<nums.length; i++){
            //这个是自己做的，可能会造成死循环，比如在输入的nums=[1,1]
            while (nums[i]-1 <nums.length && nums[i]>0 && nums[i] != i+1){  
//            while (nums[i]-1 <nums.length && nums[i]>0 &&  nums[nums[i] - 1] != nums[i]){  // 答案的
                swap(nums, nums[i]-1, i);
            }
        }
        
        for (int i=0 ; i<nums.length ; i++){
            if (i+1 != nums[i]){
                return i+1;
            }
        }
        
        return -1;
    }
    
    public void swap (int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 原地哈希 ，这个也是原地哈希，但是没有进行交换
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int length = nums.length;
        for (int i=0; i<length; i++){
            if (nums[i]<=0){
                nums[i] = length+1;
            }
        }
        
        for (int i=0; i<length; i++){
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i=0 ; i<nums.length ; i++){
            if (nums[i] > 0){
                return i+1;
            }
        }

        return length + 1;
    }
    
    
    public static void main(String[] args) {
        timu41 timu41 = new timu41();
        int[] nums = new int[]{3,4,1,-1};
        int[] nums1 = new int[]{1,1};
        int i = timu41.firstMissingPositive(nums);
        int i2 = timu41.firstMissingPositive2(nums);
        System.out.println(i);
        System.out.println(i2);
    }
}
