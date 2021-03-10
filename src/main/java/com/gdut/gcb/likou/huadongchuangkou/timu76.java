package com.gdut.gcb.likou.huadongchuangkou;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 15:18
 * @Version 1.0
 **/
public class timu76 {


    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int left = 0; int right = 0;
        int valid = 0;// valid 记录窗口中已经满足t中的一样多个数的字符的个数
        
        int sLength = s.length();
        
        int start = 0 , len = Integer.MAX_VALUE, end = 0;
        
        HashMap<Character, Integer> windows = new HashMap<>(t.length());
        HashMap<Character, Integer> needs = new HashMap<>(t.length());
        char[] chars = t.toCharArray();
        for (char node : chars){
            if (!needs.containsKey(node)){
                needs.put(node,1);
            }else {
                needs.put(node, needs.get(node)+1);
            }
        }
        while (right < sLength){
            char c = s.charAt(right);
            if (t.indexOf(c) != -1){
                
                int integer;
                if (windows.containsKey(c)){
                    integer= windows.get(c);
                    windows.put(c,integer+1);
                    integer= integer+1;
                }else {
                    windows.put(c, 1);
                    integer = 1;
                }
                if (integer == needs.get(c)){
                    valid ++;
                }
            }
            
            right++;
            
            
            while (valid == needs.size()){
                char c1 = s.charAt(left);

                int newLen = right - left ;
                if (newLen  < len){
                    start = left;
                    end = right;
                    len = newLen;
                }
            
                if (t.indexOf(c1) != -1){
                    int integer = windows.get(c1);
                    windows.put(c1 , integer -1);
                    if (integer == needs.get(c1)){
                        valid --;
                    }
                }

                left++;

            }
            
        }
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, end);
        
    }

    public static void main(String[] args) {
        timu76 timu76 = new timu76();
        String s = timu76.minWindow("aa", "aa");
        System.out.println(s);
    }
    
}
