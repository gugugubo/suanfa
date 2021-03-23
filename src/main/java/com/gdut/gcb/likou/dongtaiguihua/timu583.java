package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *
 *
 * 示例：
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/10 11:46
 * @Version 1.0
 **/
public class  timu583 {


    public int minDistance(String word1, String word2) {
        int text1Length = word1.length();
        int text2Length = word2.length();

        // dp[i][j] 表示text1[0..i] 和text[0..j]的公共子序列为dp[i][j]
        int[][] dp = new int[text1Length+1][text2Length+1];
        for (int i=1;i<=text1Length;i++){
            for (int j=1; j<=text2Length; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return text1Length + text2Length - 2 * dp[text1Length][text2Length];
    }

    public static void main(String[] args) {
        new timu583().minDistance("sea","ate");
    }
}
