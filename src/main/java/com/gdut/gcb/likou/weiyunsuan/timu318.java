package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/28 23:27
 * @Version 1.0
 **/
public class timu318 {


    /**
     * 由于字符串只含有小写字符，总共26位，所以可以用一个32位的整数来储存每个字符是否出现过
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int[] ifExist = new int[words.length];

        for (int i = 0 ;i < words.length ; i++){
            for (char ch : words[i].toCharArray()){
                ifExist[i] |= 1 << (ch - 'a');
            }
        }


        int maxVal = 0;
        for (int i = 0 ;i < words.length ; i++){
            for (int j = i + 1; j < words.length ; j++){
                if ( (ifExist[i]  & ifExist[j]) == 0){
                    maxVal = Math.max(maxVal , words[i].length() * words[j].length());
                }
            }
        }
        
        return maxVal;
    }
}
