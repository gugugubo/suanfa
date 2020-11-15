package com.gdut.gcb.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/14 0:12
 * @Version 1.0
 **/
public class timu680 {

    public boolean validPalindrome(String s) {
        int i = 0 ; int j = s.length() -1 ;
        while (i < j ){
            if (s.charAt(i++) != s.charAt(j--)){
                return subValidPalindrome(s, i-1, j)  || subValidPalindrome(s, i, j+1 );
            }
        }
        return true;
    }
    
    public boolean subValidPalindrome(String s , int i , int j ){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean aba = new timu680().validPalindrome("abc");
        System.out.println(aba);
    }
    
}
