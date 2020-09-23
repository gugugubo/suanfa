package bobo.algo.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * @Date 2020/9/20 19:22
 * @Version 1.0
 * 
 * https://leetcode-cn.com/problems/integer-break/
 **/
public class timu343 {

    int[] memo ;
    
    
    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo,-1);
        return recur(n);
    }

    /**
     * 将n进行分割(至少分割两部分), 可以获得的最大乘积
     * @param n
     * @return
     */
    private int recur(int n) {
        if ( n ==2 ){
            return 1;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        for (int i= 1; i <= n-1 ;i ++){
            int i1 = i * recur(n - i);
            int i2 = i * (n - i);
            int i3 = memo[n];
            if (i1 < i2){
                System.out.println("牛逼");
            }
            memo[n] = max2( i2,i1 , i3);
        }
        return memo[n];
    }
    private int max2(int i, int i1, int i2) {
        return Math.max(i, Math.max(i1,i2));
    }

    /**
     * 自底向上
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        memo = new int[n + 1];
        
        memo[0] = 0;
        memo[1] = 1;
        
        for (int i = 2; i<= n; i++){
            for (int j = 1; j < i; j++){
                int i1 = j * memo[i - j];
                int i2 = j * (i - j);
                int i3 = memo[i];
                memo[i] = max2(j * (i - j), j * memo[i-j], memo[i]);
             }
        }
        
        return memo[n];
    }
    
    public static void main(String[] args) {
        int i = new timu343().integerBreak(10);
        System.out.println(i);
    }

}
