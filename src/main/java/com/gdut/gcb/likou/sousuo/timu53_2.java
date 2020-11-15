package com.gdut.gcb.likou.sousuo;

/**
 * @Author 古春波
 * @Description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/25 17:13
 * @Version 1.0
 **/
public class timu53_2 {


    /**
     * 位运算
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        
        int ret = 0;
        for (int i = 0 ; i < nums.length ; i++){
            ret ^= i ^ nums[i];
        }
        return ret ^ nums.length;
    }

    /**
     * 使用二分搜索：
     * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/ 
     * 
     * 
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        //根据题意，数组可以按照以下规则划分为两部分。 
        // 左子数组： nums[i]=i
        // 右子数组： nums[i]≠i
        
        int i = 0 ; int j = nums.length - 1; 
        
        while (i <= j ){
            
            int mid = (i + j) / 2;
            // 若 nums[m]=m ，则 “右子数组的首位元素” 一定在闭区间 [m+1,j] 中，因此执行 i=m+1
            if (nums[mid] == mid){
                i = mid + 1;
            }
            // 这里不是很懂，为什么要关心  “子数组的末位元素” 的位置呢？
            //若 nums[m]≠m ，则 “左子数组的末位元素” 一定在闭区间 [i,m−1]中，因此执行 j=m−1
            if(nums[mid]  != mid){
                j = mid -1;
            }
        }
        //  跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。
        return i ;
    }

    /**
     * 参考2自己想的方法
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        //根据题意，数组可以按照以下规则划分为两部分。 
        // 左子数组： nums[i]=i
        // 右子数组： nums[i]≠i

        int i = 0 ; int j = nums.length - 1;

        while (i < j ){
            int mid = (i + j) / 2;
            // 若 nums[m]=m ，则 “右子数组的首位元素” 一定在闭区间 [m+1,j] 中，因此执行 i=m+1
            if (nums[mid] == mid){
                i = mid + 1;
            }
            //若 nums[m]≠m ，则 “右子数组的首位元素” 一定在闭区间 [i,mid]中，因此执行  j = mid;
            if(nums[mid]  != mid){
                j = mid;
            }
        }
        //  跳出时 j 指向 “右子数组的首位元素”。
        return j ;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 3};
        new timu53_2().missingNumber3(ints);
    }
}
