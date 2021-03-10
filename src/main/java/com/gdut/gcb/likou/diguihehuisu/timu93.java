package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/19 17:18
 * @Version 1.0
 **/
public class timu93 {


    /**
     * 回溯
     * https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode-solution/
     * 
     * @param s
     * @return
     */

    List<String> res ;
    List<Character> list;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length()==0){
            return res;
        }
        recur(s, 0, 0, new StringBuffer());
        return res;
    }


    /**
     * segId表示进行到ip地址4段中的哪一个，segStart 表示从s的哪个字符开始选择给segId中
     * @param s
     * @param segId
     * @param segStart
     */
    public void recur(String s, int segId, int segStart, StringBuffer s1){
        // 已经遍历完了，并且达到了4个
        if (segStart == s.length() && segId==4){
            res.add(s1.substring(0,s1.length()-1).toString());
            return;
        }
        
        
        // 已经遍历完了，但是没有达到4个
        if (segStart == s.length()|| segId==4){
            return;
        }

        // 对于字符0需要特殊判定
        if (s.charAt(segStart) == '0'){
            recur(s, segId+1, segStart+1 , s1.append("0").append("."));
            return;
        }


        for (int i=1; i< 4 && segStart+i<=s.length(); i++){
            StringBuffer s2 = new StringBuffer(s1);
            String substring = s.substring(segStart, segStart + i);
            if (Integer.valueOf(substring)>255){
                continue;
            }
            s2.append(substring).append(".");
            recur(s, segId+1, segStart+i, s2);
        }
    }


    public static void main(String[] args) {
        timu93 timu93 = new timu93();
        List<String> list = timu93.restoreIpAddresses("25525511135");
        System.out.println(list);
    }
}
