package com.gdut.gcb.likou.shaungzhizhen;

import java.util.List;

/**
 * @Author 古春波
 * @Description 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出: 
 * "apple"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/14 13:29
 * @Version 1.0
 **/
public class timu524 {

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String word: d){
            
            // 如果已经找到的最长字符串比要比较的word还长   或者   与word等长但是字典排序较前
            if (longestWord.length() > word.length()  ||  (longestWord.length() == word.length()  && longestWord.compareTo(word) < 0)){
                continue;
            }
            if (isMordLonger(s, word)){
                longestWord = word;
            }
            
        }
        
        return longestWord;
    }
    
    public boolean isMordLonger(String s, String word){
        int i = 0 ; int j = 0;
        
        while (i < s.length() && j < word.length()){
            if (s.charAt(i) != word.charAt(j)){
                i ++ ;
            }else {
                i ++;
                j ++;
            }
        }
        
        return j == word.length();
    }
}
