package com.gdut.gcb.niuke.zifuchuan;

/**
 * @Author 古春波
 * @Description 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/21 10:24
 * @Version 1.0
 **/
public class timu43 {


    /**
     * 双指针解决
     * 解法参考：https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95.html
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] res = new int[num1Len + num2Len];
       
       
        for ( int j = num1Len-1; j>=0; j--){
            for ( int i = num2Len-1; i>=0 ;i--){
                int c1 = num1.charAt(j) - '0';
                int c2 = num2.charAt(i)  - '0';
                res[i+j+1] +=( c1 * c2 ) % 10;
                res[i+j] +=( c1 * c2 ) / 10;
            }
        }
      
        StringBuilder resString = new StringBuilder();
        for (int i=res.length-1;i>=0; i--){
            if (res[i]>=10){
                res[i-1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }
        int r = 0;
        while (res[r]==0 && r<res.length-1){
            r++;
        }
        for (int i=r;i<res.length; i++){
            resString.append(res[i]);
        }
        return resString.toString();
    }

    public static void main(String[] args) {
        timu43 timu43 = new timu43();
        String multiply = timu43.multiply("99", "99");
        System.out.println(multiply);
    }
    
}
