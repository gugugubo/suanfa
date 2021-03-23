package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author  古春波
 * @Description 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 *     num 的长度小于 10002 且 ≥ k。
 *     num 不会包含任何前导零。
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 10:49
 * @Version 1.0
 **/
public class timu402 {


    /**对比timu670,timu31
     *     链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
     *     答案：单调栈，贪心
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits2(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        // 如果最终的数字序列存在前导零，我们要删去前导零。
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        // 如果最终数字序列为空，我们应该返回 0。
        return ret.length() == 0 ? "0" : ret.toString();
    }

   
    
    
    /**
     * 自己看了答案尝试写，没写出来
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (k>=1){
            if (!stack.isEmpty() &&  k>=1 && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }else {
                stack.push(num.charAt(i));
                i++;
            }
        }
        for (int j=i ; j<num.length(); j++){
            stack.push(num.charAt(j));
        }
        StringBuilder res = new StringBuilder();
        int size = stack.size();
        for (int j=0; j<size; j++){
            res.append(stack.pop());
        }
        return String.valueOf(Integer.valueOf(res.reverse().toString()));
    }

    public static void main(String[] args) {
        timu402 timu402 = new timu402();
        String s = timu402.removeKdigits2("1432219", 3);
        System.out.println(s);
    }
    
    
    
    
}
