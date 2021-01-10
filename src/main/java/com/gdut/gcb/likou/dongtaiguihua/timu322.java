package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author 古春波
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/8 11:19
 * @Version 1.0
 **/
public class timu322  {


    /**
     * 使用一维数组实现
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        
        if (amount< 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        
        // dp数组，dp[n]表示 凑成n块钱最小的硬币数量
        int[] dp =  new int[amount+1];
        Arrays.fill(dp, amount+1);
        // 初始状态
        dp[0] = 0;
        
        // 外层 for 循环在遍历所有状态的所有取值
        for(int i=1; i <= amount; i++){
            // 内层 for 循环在求所有选择的最小值
            for(int j = 0 ; j < coins.length; j ++){
                if (i - coins[j] < 0){
                    continue;
                }else {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] == amount + 1? -1 :  dp[amount] ;
        
    }

    /**
     * 动态规划，使用二维数组实现
     * @param coins coins
     * @param amount amount
     * @return int
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount <=0){
            return 0;
        }
        
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0 ; i< coins.length +1 ; i++){
            for(int j = 1; j < amount+1 ; j++){
                    dp[i][j] = amount + 1;
            }
        }
        for (int i = 0 ; i< coins.length +1 ; i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i < coins.length + 1 ;i ++){
            for(int j = 1; j < amount+1 ; j++){
                if (j - coins[i-1] >=0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if ( dp[coins.length][amount] == amount + 1 || dp[coins.length][amount] == 0){
            return -1;
        }else  {
            return dp[coins.length][amount];
        }
    }

    /**
     * 对二维数组进行状态压缩变成一维数组
     * @param coins coins
     * @param amount amount
     * @return coinChange3
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount <=0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount +1);
        dp[0] = 0;
        for (int i =1; i<coins.length+1; i++){
            for (int j = 1; j <amount +1; j++){
                if (j - coins[i-1] >= 0){
                    dp[j] = Math.min(dp[j], 1 + dp[j-coins[i-1]]);
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        if ( dp[amount] == amount + 1 || dp[amount] == 0){
            return -1;
        }else  {
            return dp[amount];
        }
    }
    
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        new timu322().coinChange(coins, 11);

        int[] coins2 = new int[]{2};
        int i = new timu322().coinChange2(coins2, 3);
        System.out.println(i);
    }
    
    
    
}
