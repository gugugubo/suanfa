package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * @Date 2021/2/9 16:57
 * @Version 1.0
 **/
public class timu316 {

    /**
     * 解法参考：https://labuladong.gitee.io/algo/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E6%A0%88%E5%8E%BB%E9%87%8D.html
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        // 判断后面还有没有相同的字符
        int[] count = new int[256];
        for (int i=0; i<s.length() ;i++){
            char ch = s.charAt(i);
            count[ch] ++;
        }
        // 实现去重
        boolean[] inStack = new boolean[256];
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            count[ch]--;
            if (inStack[ch]) {continue;}
            while (!stack.isEmpty() &&stack.peek()>ch && count[stack.peek()]>0){
                inStack[stack.pop()] = false;
            }
            stack.push(ch);
            inStack[ch] = true;
        }

        StringBuilder stringBuilder = new StringBuilder(stack.capacity());
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
    
    public static void main(String[] args) {
        timu316 timu316 = new timu316();
        String s = timu316.removeDuplicateLetters("cbacdcbc");
        System.out.println(s);
    }
}
