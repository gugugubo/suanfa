package com.gdut.gcb.likou.diguihehuisu.kuohao;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 *     任何左括号 ( 必须有相应的右括号 )。
 *     任何右括号 ) 必须有相应的左括号 ( 。
 *     左括号 ( 必须在对应的右括号之前 )。
 *     * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *     一个空字符串也被视为有效字符串。
 *
 * 示例 1:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/24 17:47
 * @Version 1.0
 **/
public class timu678 {

    //    链接：https://leetcode-cn.com/problems/valid-parenthesis-string/solution/fen-zhi-tan-xin-shuang-xiang-bian-li-shuang-zhan-j/
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        for (int i = start; i < s.length(); i++) {
            /**
             * 先编写无 * 情况的代码
             *
             * count 记录左括号个数
             * 遇左则增，遇右则减
             * 若不够减则 return false
             */
            char c = s.charAt(i);
            if (c == '(') count++;
            else if (c == ')') {
                if (count-- == 0) return false;
            } else if (c == '*') {  // 补充有 '*' 的情况分别开出三种可能继续探索任何一种成了即可
                return check(s, i + 1, count + 1) ||  // 作为 (
                        check(s, i + 1, count - 1) || // 作为 )，抵消一个左括号
                        check(s, i + 1, count);       // 作为 空
            }
        }
        return count == 0;
    }


    /**
     *     链接：https://leetcode-cn.com/problems/valid-parenthesis-string/solution/fen-zhi-tan-xin-shuang-xiang-bian-li-shuang-zhan-j/
     * 括号匹配问题的经典解法
     * 栈存放的是索引
     * 一栈存左括号，一栈存星号
     * 遍历过程中，同时判断是否有足够的右括号使他们出栈
     *
     * 优先抵消左括号（贪心思想）
     * 两栈同时出栈并判断，要求所有左括号，都有 其右边索引的星号 能使其抵消
     * 左括号不能还有富余
     *
     * @param s
     * @return
     */
    public boolean checkValidString4(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>(); // index stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') star.push(i);
            else {
                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }
        //对于任何一个左括号，它的右边必须至少有一个星号
        //所以从后往前看，如果有一个左括号的右边没有星号，也就是star.back()<left.back() 就不合法
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }



    // 参考答案自己做的
    public boolean checkValidString5(String s) {
        LinkedList<Integer> left  = new LinkedList();
        LinkedList<Integer> star  = new LinkedList();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)== '('){
                left.addLast(i);
            }else if(s.charAt(i) == '*'){
                star.addLast(i);
            }else{
                if(!left.isEmpty()){
                    left.removeLast();
                }else if(!star.isEmpty()){
                    star.removeLast();
                }else{
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            if(left.removeLast() > star.removeLast()){
                return false;
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        timu678 timu678 = new timu678();
        timu678.checkValidString("(())");
    }
}
