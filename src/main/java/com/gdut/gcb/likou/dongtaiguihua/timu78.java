package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/1/10 15:02
 * @Version 1.0
 **/
public class timu78 {

    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        if (word1Length==0 ){
            return word2Length;
        }
        if (word2Length==0){
            return word1Length;
        }
        int[][] dp = new int[word1Length + 1][word2Length + 1];

        for (int i = 0; i <= word2Length; i++) {
            dp[0][i] =i;
        }
        for (int i = 0; i <= word1Length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int min = Math.min(dp[i-1][j],dp[i][j-1]);
                    min = Math.min(min , dp[i-1][j-1]);
                    dp[i][j] = min +1;
                }
            }
        }
        for (int i = 0; i <= word1Length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[word1Length][word2Length];
    }

    public static void main(String[] args) {
        int i = new timu78().minDistance("park", "spake");
        System.out.println(i);
    }

}
