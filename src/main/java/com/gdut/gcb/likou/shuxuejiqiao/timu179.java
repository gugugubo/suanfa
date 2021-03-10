package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/6 10:42
 * @Version 1.0
 **/
public class timu179 {

    /**对比niuke.timu45
     * 算法需要证明传递性和正确性
     链接：https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode/
     */
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

}
