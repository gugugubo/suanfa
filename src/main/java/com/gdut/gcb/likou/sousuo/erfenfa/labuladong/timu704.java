package com.gdut.gcb.likou.sousuo.erfenfa.labuladong;

/**
 * @Author 古春波
 * @Description 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/3 8:58
 * @Version 1.0
 **/
public class timu704 {

    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1; // 注意 
            }
            else if (nums[mid] > target){
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

    // int right = nums.length - 1;  left < right, 在left==right的时候就推出了，所以需要考虑left==right的时候
    int binarySearch4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1; // 注意 
            }
            else if (nums[mid] > target){
                right = mid - 1; // 注意
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }

    //  int right = nums.length ;  需要考虑一下由于left <= right等号越界的情况
    int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length ; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (mid>=nums.length){
                return -1;
            }
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1; // 注意
            }
            else if (nums[mid] > target){
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

    //  int right = nums.length ;  由于left < right等号，因为不会越界，left < right,在left==right的时候就推出了，所以需要考虑left==right的时候
    int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length ; // 注意

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1; // 注意
            }
            else if (nums[mid] > target){
                right = mid - 1; // 注意
            }
        }
        if (left<nums.length && nums[left]==target){
            return left;    
        }
        return -1;
    }

    /**
     * 总结上面四种   
     * 初始化int right = nums.length ; 可能会导致数组越界     使用left < right不存在越界，但是left==right的情况取不到   使用left <= right存在越界，但是left==right的情况可以取到
     * 初始化int right = nums.length-1; 不可能导致数组越界    使用left < right不存在越界，但是left==right的情况取不到   使用left <= right也不存在越界，但是left==right的情况可以取到
     * 
     * 使用 < 那么《while循环内的》取值范围是 [left, right); 如果right = nums.length， 那么刚好全部取完； 如果nums.length-1 需要判断最后一个
     * 使用 <= 那么《while循环内的》取值范围是[left, right]; 如果right = nums.length, 那么可能存在越界； 如果是nums.length-1 刚好全部取完
     * 
     */
    public static void main(String[] args) {
        int[] ints = new int[]{-1,0,3,5,9,12};
        new timu704().binarySearch(ints, 2);
        new timu704().binarySearch2(ints, 13);
        new timu704().binarySearch3(ints, 13);
    }
}
