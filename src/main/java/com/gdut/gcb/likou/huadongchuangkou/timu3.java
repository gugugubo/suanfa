package com.gdut.gcb.likou.huadongchuangkou;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 20:09
 * @Version 1.0
 **/
public class timu3 {


    public int lengthOfLongestSubstring(String s) {
        int left = 0; int right = 0;

        int sLength = s.length();

        int  len = 0;

        HashMap<Character, Integer> windows = new HashMap<>(s.length());
  
        while (right < sLength){
            char c = s.charAt(right);
            int integer;
            if (windows.containsKey(c)){
                integer= windows.get(c);
                windows.put(c,integer+1);
            }else {
                windows.put(c, 1);
            }

            right++;

            while (windows.get(c)>1){
                char c1 = s.charAt(left);
                int num = windows.get(c1);
                windows.put(c1 , num -1);
                left++;
            }
            // 这个长度计算不能放在while循环里面，不然如果s是不含重复的字符的话就无法进入到循环里面
            int newLen = right - left ;
            if (newLen  > len){
                len = newLen;
            }
        }
        return len;

    }

    public static void main(String[] args) {
        new timu3().lengthOfLongestSubstring(" ");
    }
    
}
