package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/8 20:15
 * @Version 1.0
 **/
public class timu394 {
    

    /**对着答案敲的
     *        链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        int multi=0;
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if (ch=='['){
                stackMulti.add(multi);
                stackRes.add(res.toString());
                multi=0;
                res= new StringBuilder();
            }
            else if (ch==']'){
                StringBuilder temp = new StringBuilder( );
                if (!stackMulti.isEmpty()){
                    Integer pop = stackMulti.pop();
                    for (int j=0; j<pop; j++){
                        temp.append(res);
                    }
                }
                res = new StringBuilder(stackRes.pop() + temp.toString());
            }else if (ch>='0' && ch<='9'){
                multi = multi*10 + Integer.parseInt(ch + "");
            }else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        timu394 timu394 = new timu394();
        String s = timu394.decodeString2("3[a]2[bc]");
        System.out.println(s);
    }
    
    // 答案
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
    
}
