package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/20 9:20
 * @Version 1.0
 **/
public class timu22 {


    /**递归和回溯 
     * 下面评论的题解：剩余左括号总数要小于等于右括号。 递归把所有符合要求的加上去就行了
     * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     * @param n
     * @return
     */

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        recur("", n, n);
        return res;
    }
    
    public void recur(String s , int left , int right){
        if (left==0 && right==0){
            res.add(s);
            return;
        }
        
        // 相等的时候只能够放左括号
        if (left==right){
            recur(s+"(",left-1, right);
        }
        
        // left<right的时候两种都可以
        if (left < right){
            if (left>0){
                recur(s+"(",left-1,right);
            }
            recur(s+")", left, right-1);
        }
    }
}
