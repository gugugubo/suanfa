package com.gdut.gcb.likou.dongtaiguihua;

/**
 * @Author  古春波
 * @Description 5. 最长回文子串
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/17 17:31
 * @Version 1.0
 **/
public class timu5 {


    /**解法来自下面链接评论区
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        // 特判
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin  = 0;

        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串


        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1;j < len;j++){
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin,begin + maxLen);
    }
    

    /** 解法参考：https://labuladong.github.io/algo/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E6%9C%80%E9%95%BF%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2.html
     * 注意这里的子串和子序列是不一样的
     * 使用双指针迭代的方式
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = ""; 
        for (int i=0 ;i<s.length(); i++){
            String first = palindrome(s, i, i);
            String second = palindrome(s, i, i + 1);
            res = first.length() > res.length()? first: res;
            res = second.length() > res.length() ? second : res;
        }
        return res;
    }
    
    // 判断一个字符串从left，right两个字符开始所能构成的最大回文子串，这里left要么等于right，要门left+1==right
    public String palindrome(String s, int left , int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left, right);
    }

    public static void main(String[] args) {
        String test = "abcdef";
        // substring() 函数是左闭右开
        System.out.println(test.substring(0, 0+3));
        longestPalindrome4("aacabdkac");
        longestPalindrome5("cbbd");
    }


    // 3-23 自己做的动态规划
    public static String longestPalindrome5(String s) {
        int length = s.length();
        // 特判
        if (length < 2){
            return s;
        }
        int maxLength=1;
        int startIndex=0;
        boolean[][] dp = new boolean[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = true;
        }
        for(int i=length-2; i>=0; i--){
            for (int j=i+1; j<=length-1; j++){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    // 主要是为了防止 j = i+1 并且 j 和 i 的字符相等的时候，会进行i+1,j-1 这样i就大于j了
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i +1>=maxLength){
                    maxLength = j-i +1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex ,startIndex+maxLength);
    }
    

    // 下面是自己做的，想法错了，做成子序列问题了
    public static String longestPalindrome4(String s) {
        int length = s.length();
        // dp[i][j] 表示 字符串i到j位置的最长回文子串
        int[][] dp = new int[length][length];

        for(int i=length-1; i>=0; i-- ){
            dp[i][i] = 1;
        }
        int maxLength = 1;
        int startIndex = 0;
        for(int i=length-1; i>=0; i-- ){
            for(int j=i+1; j<=length-1; j++ ){
                char chari = s.charAt(i);
                char charj = s.charAt(j);
                if(chari == charj){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if(j-i+1>=maxLength){
                        startIndex = i;
                    }
                }else{
                    int tempi = dp[i+1][j];
                    int tempj = dp[i][j-1];
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        int resLength = dp[0][length-1];
        String  substring= s.substring(startIndex, startIndex+resLength);
        
        return substring;
    }
}
