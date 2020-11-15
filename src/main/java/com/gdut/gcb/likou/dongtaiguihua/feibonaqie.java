package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 斐波那契的优化，
 * @Date 2020/9/20 17:22
 * @Version 1.0
 **/
public class feibonaqie {


    public int fib( int n ){
        if( n == 0 ){
            return 0;
        }
        if( n == 1 ){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }


    /**
     * 自顶向下使用记忆化搜索解决问题
     * @param n
     * @return
     */
    public int fib2( int n ){
        int[] memo = new int[n +1];
        Arrays.fill(memo,-1);
        return subfib2(n,memo);
    }
    public int subfib2( int n ,int[] memo){
        if (n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        if (memo[n] == -1){
            return memo[n] = subfib2(n-1,memo) + subfib2(n-2,memo) ;
        }
        return memo[n];
    }

    /**
     * 动态规划，自底向上解决问题
     * @param n
     * @return
     */
    public int fib3( int n ){
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
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {

        //int n = 42;
        int n = 1000; // 注意: 我们使用n = 1000只是为了测试性能, 实际上会溢出
        // 斐波那契额数列是以指数速度上涨的

        feibonaqie solution = new feibonaqie();
        long startTime = System.currentTimeMillis();
        int res = solution.fib3(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
    }
    
}
