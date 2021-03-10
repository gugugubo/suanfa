package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;

/**
 * @Author 古春波
 * @Description 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"1" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/7 15:39
 * @Version 1.0
 **/
public class timu91 {


    /**对比niuke.timu46
     * 使用dp
     * https://leetcode-cn.com/problems/decode-ways/solution/san-chong-jie-fa-dfsyi-wei-dong-tai-gui-tfvin/
     * 
     * @return
     */
    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        // dp[i] 表示以i结尾的字符最多能表示的种类数
        int[] dp = new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {  
                //如果前一位不是1或者2,显然无法解码
                if (chars[i - 1] != '1' && chars[i - 1] != '2') return 0;  // 出现前导 ‘0’ 的情况，不能解码，直接返回
                //如果前一位是1或者2
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {   // 两种解码方式
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];  
            } else {
                dp[i] = dp[i - 1];  // '01'到 ‘09’ 或 > '26'，只有单独才能解码
            }
        }
        return dp[chars.length - 1];

    }
    
    
    


    /**
     * 对比niuke.timu46  递归会超时
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0)=='0'){
            return 0;
        }
        return recur(s, 0);
    }
    
    
    public int recur(String s, int i){
        if (i==s.length()){
            return 1;
        }
        int ans = 0;
        if (s.charAt(i)!= '0' && i<s.length()-1 && (Integer.parseInt(s.substring(i,i+2)) <=26 )  ) {
            ans += recur(s, i+2);
        }
        if (s.charAt(i) != '0') {
            ans += recur( s,i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        timu91 timu91 = new timu91();
        int i = timu91.numDecodings("0");
        System.out.println(i);
    }
    
}
