package com.gdut.gcb.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/8 15:25
 * @Version 1.0
 **/
public class timu125 {

    String SS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

    public boolean isPalindrome(String s) {
        int i=0; int j= s.length()-1;
        while (i<j){
            while (i<j && i<s.length() && SS.indexOf(s.charAt(i))==-1 ){
                i++;
            }
            char iChar = s.charAt(i);
            while (j>=0 && j>i && SS.indexOf(s.charAt(j))==-1 ){
                j--;
            }
            char jChar = s.charAt(j);
            if (Character.toLowerCase(iChar) == Character.toLowerCase(jChar)){
                j--;
                i++;
            }else {
                return false;
            }
        }
        return true;
    }


    /** 答案的
     *     链接：https://leetcode-cn.com/problems/valid-palindrome/solution/yan-zheng-hui-wen-chuan-by-leetcode-solution/
     *     
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                System.out.println(Character.toLowerCase(s.charAt(left)));
                System.out.println(Character.toLowerCase(s.charAt(right)));
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        timu125 timu125 = new timu125();
//        boolean palindrome = timu125.isPalindrome("A man, a plan, a canal: Panama");
        boolean palindrome2 = timu125.isPalindrome("0P");
        boolean palindrome3 = timu125.isPalindrome2("0P");
    }
}
