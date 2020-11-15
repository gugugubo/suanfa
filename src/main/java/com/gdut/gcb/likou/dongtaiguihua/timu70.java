package com.gdut.gcb.likou.dongtaiguihua;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Date 2020/9/20 17:56
 * @Version 1.0
 * 
 * https://leetcode-cn.com/problems/climbing-stairs/
 **/
public class timu70 {

    int[] memo;

    /**
     * 自顶向下
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        this.memo = new int[ n +1 ];
        Arrays.fill(memo, -1);
        return  recur(n);
    }

    private int recur(int n ) {
        if (n == 0 || n==1){
            return 1;
        }
        if (memo[n] == -1){
            memo[n] =  recur(n -1) + recur(n -2);
        }
        return memo[n];
    }

    /**
     * 自下向上
     * @param n
     * @return
     */
    public int climbStairs2(int n) { 
        
        this.memo = new int[ n +1 ];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i<=n; i ++){
            memo[i] = memo[i - 1 ] + memo[i - 2];
        }
        return  memo[n];
    }
    
    public static void main(String[] args) { 
        System.out.println(new timu70().climbStairs2(3));
    }
}
