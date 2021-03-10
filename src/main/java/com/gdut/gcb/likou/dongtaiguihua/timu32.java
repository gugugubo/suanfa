package com.gdut.gcb.likou.dongtaiguihua;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/1 10:35
 * @Version 1.0
 **/
public class timu32 {


    /**
     * 自己想的，使用栈
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int resCount=0; 
        for (int i=0; i<s.length() ;i++){
            Character ch = s.charAt(i);
            if (ch=='('){
                stack.push(ch);
            }else if (ch==')'){
                if (!stack.isEmpty()){
                    resCount=resCount+2;
                    stack.pop();
                }
            }
        }
        return resCount;
        
    }
}
