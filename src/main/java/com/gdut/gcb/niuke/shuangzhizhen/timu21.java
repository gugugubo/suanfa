package com.gdut.gcb.niuke.shuangzhizhen;

/**
 * @Author 古春波
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4] 
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/19 11:32
 * @Version 1.0
 **/
public class timu21 {


    public int[] exchange(int[] nums) {
        int i=0; int j = nums.length -1;
        while (i<j){
            while (i<j && nums[i]%2==1){
                i++;
            }
            while (j>i && nums[j]%2==0){
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }
    
    public void swap(int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i]  =  nums[j];
        nums[j] = temp;
    }

    /**
     * 快慢指针
     *         链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int low = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] %2== 1) {
                swap(nums, fast, low);
                low ++;
            }
            fast ++;
        }
        return nums;
    }
    
}
