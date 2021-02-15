package com.gdut.gcb.likou.zifuchuan;

/**
 * @Author 古春波
 * @Description 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * 提示：
 *
 *     num1 和num2 的长度都小于 5100
 *     num1 和num2 都只包含数字 0-9
 *     num1 和num2 都不包含任何前导零
 *     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/15 23:00
 * @Version 1.0
 **/
public class timu415 {


    /** 使用的是双指针
     * 题解参考：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i = num1.length() -1; int j = num2.length()-1;
        int carry = 0;
        while (i>=0 || j>=0|| carry>0){
            int sum = carry;
            sum += i<0? 0 : num1.charAt(i) - '0' ;
            sum += j<0? 0 :num2.charAt(j)  - '0' ;
            res.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        timu415 timu415 = new timu415();
        String s = timu415.addStrings("1", "1");
        System.out.println(s);

    }
}
