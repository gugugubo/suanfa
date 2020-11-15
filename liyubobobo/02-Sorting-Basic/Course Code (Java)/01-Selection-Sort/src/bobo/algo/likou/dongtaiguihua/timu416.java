package bobo.algo.likou.dongtaiguihua;

import java.lang.reflect.Array;

/**
 * @Author 古春波
 * @Description 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Date 2020/9/23 16:38
 * @Version 1.0
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 **/
public class timu416 {
    int[] nums;
    int[][] memo ;
    /**
     * 自顶向下
     * 这个问题其实就是一个背包问题，用数组填充元素之和的二分之一
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int total = 0;
        for (int i = 0; i <nums.length ; i++){
            total += nums[i];
        }
        if (total%2 != 0){
            return false;
        }
        int sum = total /2;
        memo = new int[nums.length][sum +1];

        for (int i = 0 ; i< nums.length ; i++){
            for (int j = 0 ; j< sum +1; j ++){
                memo[i][j] = -1;
            }
        }
        boolean resu = recur(nums.length - 1, sum);
        return resu;
    }
    /**
     * 自顶向下
     * 用 [0...index]数字,填充sum
     * @param index
     * @param sum
     * @return
     */
    private boolean recur(int index, int sum ){
        if (sum == 0){ 
            return true; }
        if (sum < 0 || index < 0){
            return false; }
        
        if (memo[index][sum] != -1){
            return (memo[index][sum]) == 0? true: false;
        }
        boolean recur1 = recur(index - 1, sum);
        if (recur1){
            return true;
        }
        boolean recur2 = false;
        if (sum >= nums[index]){
             recur2 = recur(index - 1, sum - nums[index]);
        }
        memo[index][sum] = (recur1 || recur2) == true? 0: 1;
        return recur1 || recur2;
    }

    public static void main(String[] args) {
        boolean b = new timu416().canPartition(new int[]{1,5,6
        });
        System.out.println(b);
    }

    /**
     * 自底向上，动态规划
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int total = 0;
        for (int i = 0; i <nums.length ; i++){
            total += nums[i];
        }
        if (total%2 != 0){
            return false;
        }
        int sum = total /2;
        boolean[] memor = new boolean[sum + 1];

        for (int i = 0 ; i<= sum; i ++){
            memor[i] = i == nums[0] ? true : false;
        }

        for(int i = 1; i < nums.length; i ++){
            for (int j = sum ; j >= nums[i] ; j --){
                boolean result = memor[j ];
                if (j >= i){
                    result = result || memor[j - nums[i]];
                }
                memor[j] = result;
            }
        }

        /**
         * for(int i = 1; i < nums.length; i ++){
         *     for (int j = sum ; j >= nums[i] ; j --){
         *         memor[j] = memor[j] || memor[j - nums[i]];
         *     }
         * }
         */

        return memor[sum];
    }
}
