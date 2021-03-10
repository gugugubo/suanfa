package com.gdut.gcb.likou.zifuchuan;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 16:51
 * @Version 1.0
 **/
public class timu20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i=0;  i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='{' || c=='(' || c=='['){
                stack.push(c);
            }else {
                if (!stack.isEmpty() && stack.peek()==leftOf(c)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')'){
            return '(';
        } 
        return '[';
    }
}
