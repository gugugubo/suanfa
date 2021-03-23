package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 *     插入一个字符
 *     删除一个字符
 *     替换一个字符
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
