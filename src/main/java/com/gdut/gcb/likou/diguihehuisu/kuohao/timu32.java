package com.gdut.gcb.likou.diguihehuisu.kuohao;

import java.util.LinkedList;
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

    public static void main(String[] args) {
        timu32 timu32 = new timu32();
        timu32.longestValidParentheses2(")()())");
    }

    /**
     *  链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        // 如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中
        // 这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素。
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // // 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
            if (s.charAt(i) == '(') {  
                stack.push(i);
            } else {
                stack.pop();  // 对于遇到的每个 ‘)' ，我们先弹出栈顶元素表示匹配了当前右括号：
                // 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                if (stack.empty()) {
                    stack.push(i);
                } else { // 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    /**
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     * 时间复杂度： O(n)，其中 n 为字符串长度。我们只要正反遍历两边字符串即可。
     * 空间复杂度： O(1)。我们只需要常数空间存放若干变量。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
    
    
    
    /**
     * 自己模仿第一种方法做的
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        LinkedList<Integer> list = new LinkedList();
        list.addLast(-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                list.addLast(i);
            }else{
                int left = list.removeLast();
                if(list.isEmpty()){
                    list.add(i);
                }else{
                    // 注意这里！！list.getLast()  分为 )()()  和)(((()) 代入就行了
                    maxLength = Math.max(i - list.getLast(), maxLength);
                }
            }
        }
        return maxLength;
    }

}
