package com.gdut.gcb.niuke.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * @Date 2020/10/6 0:30
 * @Version 1.0
 **/
public class timu10_2 {

    /***
     * 动态规划
     */
    public int numWays(int n) {
        if (n < 0){
            return 0;
        }
        if (n == 0 || n == 1){
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i< n + 1 ;i ++){
            memo[i] = (memo[ i -1 ] % 1000000007) + (memo[i -2] % 1000000007);
            
        }
        return memo[n] % 1000000007;
    }



    /***
     * 动态规划，将空间复杂度降到O(1)
     */
    public int numWays2(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 0; i< n - 1   ;i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return  sum;
    }


    public static void main(String[] args) {
        new timu10_2().numWays2(2);
    }

}
