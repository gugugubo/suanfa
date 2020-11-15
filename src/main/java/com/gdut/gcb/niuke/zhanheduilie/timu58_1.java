package com.gdut.gcb.niuke.zhanheduilie;

/**
 * @Author 古春波
 * @Description 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @Date 2020/9/14 23:35
 * @Version 1.0
 * url https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 **/
public class timu58_1 {


    /**
     * 使用双指针迭代 ，看了思路之后基本可以做出来，边界确认那里有点难搞
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     * t h e   s k y   i s     b  l  u  e
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0){
            return "";
        }
        int i = s.length() -1, j  = s.length()-1;
        StringBuffer result = new StringBuffer();
        
        while (i >= 0){
            while (  i >= 0&& s.charAt(i) != ' '){
                i --;
            }
            // substring 是左闭右开
            result.append(s.substring(i+1,j+1)).append(" ");
            while (  i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;

        }
        return result.toString().trim();
    }
    
    
    
    

    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "a good example";
        String s1 = new timu58_1().reverseWords(s);
        System.out.println(s1);
    }
}
