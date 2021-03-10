package com.gdut.gcb.niuke.diguihehuisu;

/**
 * @Author 古春波
 * @Description 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/20 11:10
 * @Version 1.0
 **/
public class timu46 {


    /**
     * 使用动态规划解题
     * @param num
     * @return
     */
    public int translateNum2(int num) {
        String nums = String.valueOf(num);
        // dp[i] 表示以i结尾的字符最多能表示的种类数
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i=1;i<nums.length(); i++){
            dp[i] = dp[i-1];
            if (nums.charAt(i-1) == '1' || nums.charAt(i-1)== '2' && nums.charAt(i) < '6'){
                dp[i] += i>1?dp[i-2]: 1;
            }
        }
        return dp[nums.length()-1];
    }
    

    /**
     * 递归和回溯解法，对比timu91
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        return recur(nums, 0);
    }
    
    public int recur(String nums, int start){
//        if (nums.length()-1 <= start){  或者这个
        if (nums.length() == start){
            return 1;
        }

        int sum = recur(nums, start + 1);
        
        if (start+2<=nums.length()){
            String num = nums.substring(start, start + 2);
            Integer val = Integer.valueOf(num);
            if (val>=10 && val<=25){
                sum += recur(nums, start + 2);
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        timu46 timu46 = new timu46();
        int i = timu46.translateNum(25);
        System.out.println(i);
    }
}
