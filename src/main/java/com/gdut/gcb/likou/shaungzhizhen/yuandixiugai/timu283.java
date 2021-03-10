package com.gdut.gcb.likou.shaungzhizhen.yuandixiugai;

/**
 * @Author 古春波
 * @Description 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @Date 2021/2/9 10:24
 * @Version 1.0
 **/
public class timu283 {


    /**
     * 复用27题的函数
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i1 = removeElement(nums, 0);
        for (int i=i1; i<nums.length ;i++){
            nums[i] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        int i=0 , j=0;
        int length = nums.length;
        if (length==0){
            return 0;
        }
        while (j<length){
            while (j<length && nums[j]==val){
                j++;
            }
            if (j<length){
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
