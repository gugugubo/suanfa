package com.gdut.gcb.niuke.dongtaiguihua;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author 古春波
 * @Description 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/7 10:06
 * @Version 1.0
 **/
public class timu48 {


    /**
     *         链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        /**
         * 当 i<0 ，即 s[j] 左边无相同字符，则 dp[j]=dp[j−1]+1dp[j] = dp[j-1] + 1dp[j]=dp[j−1]+1 ；
         * 当 dp[j−1]<j−i ，说明字符 s[i] 在子字符串 dp[j−1] 区间之外 ，则 dp[j]=dp[j−1]+1 ；
         * 上面两种都是  dp[j−1]<j−i 情况，因为 dp[j−1]≤j恒成立，因而 dp[j−1]<j−i 恒成立，因此分支 1. 和 2. 可被合并。
         *
         * 当 dp[j−1]≥j−i ，说明字符 s[i] 在子字符串 dp[j−1] 区间之中 ，则 dp[j]dp[j]dp[j] 的左边界由 s[i] 决定，即 dp[j]=j−i；
         *
         */
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
        
    }


    /**
     *     链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
     *     双指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                //更新左指针 i： 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i+1,j] 内无重复字符且最大
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    
    
    /**
     * 自己做的，没做出来
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0){
            return 0;
        }
        //设置dp[j] 代表以字符 s[j] 为结尾的 “最长不重复子字符串” 的长度
        int [] dp = new int[s.length()];
        // base case
        dp[0] = 1;
        HashSet<Character> objects = new HashSet<>();
        objects.add(s.charAt(0));
        for (int i=1; i<s.length() ; i++){
            if (!objects.contains(s.charAt(i))){
                dp[i] = dp[i-1] +1;
                objects.add(s.charAt(i));
            }else {
                int j=i-1;
                while (s.charAt(j)!=s.charAt(i)){
                    j--;
                }
                dp[i] = dp[j+1]+1;
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        timu48 timu48 = new timu48();

        int length = timu48.lengthOfLongestSubstring("abcabcbb");
        int length2 = timu48.lengthOfLongestSubstring3("abba");
        System.out.println(length);
    }
    
    
}
