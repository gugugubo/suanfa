package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/1/12 10:57
 * @Version 1.0
 **/
public class timu712 {
    public int minimumDeleteSum(String s1, String s2) {
        int text1Length = s1.length();
        int text2Length = s2.length();
       
        
        // dp[i][j] 表示text1[0..i] 和text[0..j]的公共子序列为dp[i][j]
        int[][] dp = new int[text1Length+1][text2Length+1];
        for (int i=1;i<=text1Length;i++){
            dp[i][0] = s1.charAt(i-1)+  dp[i-1][0]; 
        }
        for (int j=1; j<=text2Length; j++) {
            dp[0][j] = s2.charAt(j-1)+ dp[0][j-1];
        }
        for (int i=1;i<=text1Length;i++){
            for (int j=1; j<=text2Length; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[text1Length][text2Length];
    }

    public static void main(String[] args) {
        new timu712().minimumDeleteSum("delete","leet");
    }
}
