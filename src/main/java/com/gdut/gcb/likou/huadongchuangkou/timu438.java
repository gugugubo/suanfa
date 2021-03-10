package com.gdut.gcb.likou.huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 古春波
 * @Description 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 *     字母异位词指字母相同，但排列不同的字符串。
 *     不考虑答案输出的顺序。
 *
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/4 20:02
 * @Version 1.0
 **/
public class timu438 {

    public List<Integer> findAnagrams(String s1, String s2) {
        int left = 0; int right = 0;
        int valid = 0;// valid 记录窗口中已经满足t中的一样多个数的字符的个数

        int sLength = s1.length();

        ArrayList<Integer> result = new ArrayList<>();
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
                    result.add(left);
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
        return result;
    }
    
}
