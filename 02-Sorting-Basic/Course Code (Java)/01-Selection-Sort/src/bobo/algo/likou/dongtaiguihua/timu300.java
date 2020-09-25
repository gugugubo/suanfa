package bobo.algo.likou.dongtaiguihua;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * @Date 2020/9/26 0:38
 * @Version 1.0
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 **/
public class timu300 {

    /**
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 自底向上进行递归
     * @param nums  传入的数组
     * @return   子序列长度
     */
    public int lengthOfLIS(int[] nums) {
        
        if (nums.length == 0){
            return  0;
        }
        
        // 以 nums[index] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];

        Arrays.fill(memo, 1);

        getMaxLength(nums, memo);
        int result =  1;
        for (int i = 0 ; i< memo.length ; i++){
            if (memo[i] > result ){
                result  = memo[i];
            }
        }
        return result;
    }
    
    
    private void getMaxLength(int[] nums , int[] memo ){
        for (int i = 1 ; i < nums.length; i ++){
            for (int j = 0 ; j < i; j ++){
                if (nums[i] > nums[j] && memo[i] <= memo[j]){
                    memo[i] = 1 + memo[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,3,6,7,9,4,10,5,6};
        new timu300().lengthOfLIS(ints);
    }
    
}
