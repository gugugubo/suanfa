package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Stack;

/**
 * @Author 古春波
 * @Description 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *
 *
 * 说明：
 *
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/9 9:16
 * @Version 1.0
 **/
public class timu150 {

    /**使用栈：可以看看百度的解释https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437
     * 实现逆波兰式的算法，难度并不大，但为什么要将看似简单的中缀表达式转换为复杂的逆波兰式？原因就在于这个简单是相对人类的思维结构来说的，对计算机而言中序表达式是非常复杂的结构。 
     * 新建一个表达式,如果当前字符为变量或者为数字，则压栈，如果是运算符，则将栈顶两个元素弹出作相应运算，结果再入栈，最后当表达式扫描完后，栈里的就是结果
     * 
     *  链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-19/
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
