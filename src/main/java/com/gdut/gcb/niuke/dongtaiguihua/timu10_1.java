package com.gdut.gcb.niuke.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 斐波那契数列
 * @Date 2020/10/6 21:58
 * @Version 2.0
 * url: https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 **/
public class timu10_1 {

    public int fib(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i<= n; i++){
            memo[i] = (memo[ i -1 ] % 1000000007) + (memo[i -2] % 1000000007);
        }
        return (int) (memo[n] % 1000000007);
    }
    
    
}
