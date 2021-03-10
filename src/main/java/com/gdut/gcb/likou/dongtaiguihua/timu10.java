package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/17 10:59
 * @Version 1.0
 **/
public class timu10 {

    /**
     * 下面这个我没完全做出来，从后往前初始化basecase的情况太难了！还是看isMatch2 ， isMatch3
     * @param s
     * @param p
     * @return
     */
//    public boolean isMatch(String s, String p) {
//
//
//        int sLength = s.length();
//        int pLength = p.length();
//        if (pLength == 1) {
//            return sLength != 1 ? false : p.charAt(0) == s.charAt(0) || p.charAt(0) == '.';
//        }
//        // dp数组，表示s[i...]和p[j...]之间是否完全匹配
//        boolean[][] dp = new boolean[sLength][pLength];
//        // 初始化base case
//        dp[sLength-1][pLength-1] = s.charAt(sLength-1) == p.charAt(pLength-1);
//        for (int j = pLength - 1; j >= 0; j--) {
//            if ((pLength - j) % 2 == 1) {
//                dp[sLength-1][j] =  false;
//            }
//            for (int j2= j; j2 + 1 < pLength; j2 += 2) {
//                if (p.charAt(j2 + 1) != '*') {
//                    dp[sLength-j2][j] = false;
//                }
//            }
//            dp[sLength-1][j] = true;
//        }
//        for (int i = sLength - 2; i >= 0; i--) {
//            for (int j = pLength - 2; j >= 0; j--) {
//                // 注意处理边界问题
//                // i和j可以匹配
//                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
//                    if (j + 1 <= pLength - 1 && p.charAt(j + 1) == '*') {
//                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
//                    } else {
//                        dp[i][j] = dp[i + 1][j + 1];
//                    }
//                } else { // i和j不能匹配
//                    if (j + 1 <= pLength - 1 && p.charAt(j + 1) == '*') {
//                        dp[i][j] = dp[i + 1][j + 2];
//                    } else {
//                        dp[i][j] = false;
//                    }
//                }
//            }
//        }
//        for (int i=0;i<sLength;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        return dp[0][0];
//    }


    /**
     * 注意，p为模式串，p不一定需要走到尽头(p中剩余的可以类似为s*p*b*)，但是s要走到尽头才能算匹配成功；
     * 1.数组使用从前往后的遍历方式
     * 2.划分情况使用最后一个字符是否相等
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        if (pLength == 1) {
            return sLength != 1 ? false : p.charAt(0) == s.charAt(0) || p.charAt(0) == '.';
        }
        // dp数组，表示s[0...i]和p[0...j]之间是否完全匹配
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        // 初始化base case
        dp[0][0] = true;
        for (int j = 1; j <= pLength; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {  // 其它结尾的情况都是false
                dp[0][j] = false;
            }
        }
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // i和j不能匹配
                    if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }


    /**
     * 相比2，去掉了初始化
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        if (pLength == 1) {
            return sLength != 1 ? false : p.charAt(0) == s.charAt(0) || p.charAt(0) == '.';
        }
        // dp数组，表示s[0...i]和p[0...j]之间是否完全匹配
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        // 初始化base case
        dp[0][0] = true;
        for (int i = 0; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (i-1>=0 && s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (i-1>=0 &&p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // i和j不能匹配
                    if (p.charAt(j - 1) == '*') {
                        if ( i-1>=0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) {
//        boolean match1 = new timu10().isMatch("aa", "a*");
        //        System.out.println(match1);
        boolean match2 = new timu10().isMatch2("aa", "a*");
        boolean match3 = new timu10().isMatch3("aa", "a*");
        System.out.println(match2);
        System.out.println(match3);
    }
}
