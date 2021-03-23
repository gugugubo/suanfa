package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description  给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/9 10:04
 * @Version 1.0
 **/
public class timu518 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0 ; i< coins.length +1 ; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < coins.length + 1 ;i ++){
            for(int j = 1; j < amount+1 ; j++){
                if (j - coins[i-1] >=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int change = new timu518().change(5, coins);
        System.out.println(change);
    }
}
