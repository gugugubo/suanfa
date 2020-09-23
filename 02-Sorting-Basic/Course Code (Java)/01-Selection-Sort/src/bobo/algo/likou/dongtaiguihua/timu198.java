package bobo.algo.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 链接：https://leetcode-cn.com/problems/house-robber
 * @Date 2020/9/22 0:13
 * @Version 1.0
 **/
public class timu198 {

    /**
     * memo[i] 表示考虑抢劫 nums[i...n] 所能获得的最大收益
     */
    int[] nums ;
    
    int[] memo ;
    
    public int rob(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return recur(0);
    }
    /**
     * 考虑抢劫nums[index...nums.size()-1]这个范围的所有房子
     * 空间复杂度: O(n)
     * 时间复杂度: O(n^2)
     * @param index
     * @return
     */
    private int recur(int index) {
        if (index > nums.length -1){
            return 0;
        }
        if (memo[index] != -1){
            return memo[index];
        }
        for (int i = index ; i< nums.length; i ++ ){
            int i1 = memo[index];
            int i2 = nums[i] + recur(i + 2);
            memo[index]  = Math.max(i1, i2 ); 
        }
        return memo[index];
    }

    /**
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        
        if (nums == null ||nums.length == 0){
            return 0;
        }
        
        // memo[i] 表示考虑抢劫 nums[i...n] 所能获得的最大收益
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        memo[nums.length -1] = nums[nums.length -1];
        
        for(int i = nums.length -2; i>= 0 ; i--){
            for (int j = i ; j < nums.length ; j++){
                int i1 = memo[i];
                int i2 = nums[j] + (j + 2 > nums.length-1? 0 :  memo[j + 2]);
                memo[i] = Math.max(i1, i2);
            }
        }
        
        return memo[0];
    }
    
    
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 1};
        int rob = new timu198().rob(ints);
        System.out.println(rob);
    }
}
