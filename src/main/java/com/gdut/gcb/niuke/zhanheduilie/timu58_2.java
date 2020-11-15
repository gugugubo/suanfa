package com.gdut.gcb.niuke.zhanheduilie;


/**
 * @Author 古春波
 * @Description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @Date 2020/9/15 20:11
 * @Version 1.0
 * 
 * url https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 **/
public class timu58_2 {

    // abcdefg  cdefgab

    /**
     * 使用迭代 + java 的String的自带的substring函数
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        s = s.trim();
        
        StringBuffer result = new StringBuffer();
        
        result.append(s.substring(n,s.length()));
        result.append(s.substring(0,n));
        return result.toString();
    }
}
