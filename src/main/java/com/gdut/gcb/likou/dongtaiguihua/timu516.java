package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/11 21:30
 * @Version 1.0
 **/
public class timu516 {

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length==0){
            return 0;
        }else if (length==1){
            return 1;
        }
        // 两个状态，二维数组
        int[][] dp = new int[length][length];
        
        for (int i=0; i<length ; i++){
            for (int j=0; j<length; j++){
                if (i==j){
                    // base case
                    dp[i][j] = 1;
                }
            }
        }

        for (int  i=length-2;  i>=0;  i--){
            for (int j=i+1; j<length; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    // 因为如果不相等，那么s.charAt(i) 和 s.charAt(j) 必定不可能同时出现在s.i到s.j的回文子序列中；因为如果同时在那么回文子序列的两端必定是s.charAt(i) 和 s.charAt(j) ，所以不可能
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }

    public static void main(String[] args) {
        int bbbab = new timu516().longestPalindromeSubseq("bbbab");
        System.out.println(bbbab);
    }
    
}
