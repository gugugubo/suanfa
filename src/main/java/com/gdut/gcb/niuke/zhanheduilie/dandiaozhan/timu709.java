package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/6 14:50
 * @Version 1.0
 **/
public class timu709 {

    /**
     * 解法参考timu496
     * @param nums2
     * @return
     */
    public int[] dailyTemperatures(int[] nums2) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[nums2.length];
        // 从后往前遍历
        for (int i=nums2.length -1 ; i>=0 ; i--){
            // 注意加了等号
            while (!stack.isEmpty() &&  nums2[stack.peek()] <= nums2[i]  ){
                stack.pop();
            }
            if (!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }else {
                res[i] = 0;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        timu709 timu709 = new timu709();
        int[] ints = timu709.dailyTemperatures(ints1);
        System.out.println(Arrays.toString(ints));
    }
        
}
