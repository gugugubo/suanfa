package com.gdut.gcb.likou.huadongchuangkou;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 17:38
 * @Version 1.0
 **/
public class timu567 {


    public boolean checkInclusion(String s2, String s1) {
        int left = 0; int right = 0;
        int valid = 0;// valid 记录窗口中已经满足t中的一样多个数的字符的个数

        int sLength = s1.length();

        int start = 0 , len = Integer.MAX_VALUE, end = 0;

        HashMap<Character, Integer> windows = new HashMap<>(s2.length());
        HashMap<Character, Integer> needs = new HashMap<>(s2.length());
        char[] chars = s2.toCharArray();
        for (char node : chars){
            if (!needs.containsKey(node)){
                needs.put(node,1);
            }else {
                needs.put(node, needs.get(node)+1);
            }
        }
        
        
        while (right < sLength){
            char c = s1.charAt(right);
            if (s2.indexOf(c) != -1){

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


            // 相当于按序每t.length() 这样子进行检查
            while (right-left>= s2.length()){
                char c1 = s1.charAt(left);

                if (valid == needs.size()){
                    return true;
                }

                if (s2.indexOf(c1) != -1){
                    int integer = windows.get(c1);
                    windows.put(c1 , integer -1);
                    if (integer == needs.get(c1)){
                        valid --;
                    }
                }

                left++;

            }

        }
        return false;

    }

    public static void main(String[] args) {
        boolean b = new timu567().checkInclusion("eidbaooo", "ab");
        System.out.println(b);
    }
   

    
}
