package com.gdut.gcb.niuke.zhanheduilie;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 1047. 删除字符串中的所有相邻重复项
 * \给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/7 11:51
 * @Version 1.0
 **/
public class timu1047 {


    /**
     * 直接遍历
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        if (S.length()<2){
            return S;
        }
        char[] chars = S.toCharArray();
        int left = -1;
        for (int i=0 ; i<S.length(); i++){
            if (left==-1 || chars[left] != chars[i]){
                chars[++left] = chars[i];
            }else {
                left--;
            }
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, left + 1));
    }


    /**
     * 使用栈
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin-zh/
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    
    public static void main(String[] args) {
        timu1047 timu1047 = new timu1047();
        String s = timu1047.removeDuplicates("abbaca");
        System.out.println(s);
    }
}
