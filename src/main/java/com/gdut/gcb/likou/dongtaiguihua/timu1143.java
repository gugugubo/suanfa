package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/12 9:32
 * @Version 1.0
 **/
public class timu1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        
        // dp[i][j] 表示text1[0..i] 和text[0..j]的公共子序列为dp[i][j]
        int[][] dp = new int[text1Length+1][text2Length+1];
        for (int i=1;i<=text1Length;i++){
            for (int j=1; j<=text2Length; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }

    public static void main(String[] args) {
        int i = new timu1143().longestCommonSubsequence("abcde", "acfe");
        System.out.println(i);
    }
    
}
